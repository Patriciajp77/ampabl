package com.ampa.bl.bl.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.PrestamoVO;
import com.ampa.bl.bl.servicio.AlumnoServicio;
import com.ampa.bl.bl.servicio.AsignaturaServicio;
import com.ampa.bl.bl.servicio.CursoServicio;
import com.ampa.bl.bl.servicio.EjemplarServicio;
import com.ampa.bl.bl.servicio.LibroServicio;
import com.ampa.bl.bl.servicio.PrestamoServicio;
import com.ampa.bl.bl.servicio.SocioServicio;

@Controller
@RequestMapping("/prestamo")
public class PrestamoControlador {

	// Inyecto Servicios para que interactuar con la bbdd
	@Autowired
	PrestamoServicio ps;
	@Autowired
	EjemplarServicio es;
	@Autowired
	LibroServicio ls;
	@Autowired
	AlumnoServicio as;
	@Autowired
	CursoServicio cs;
	@Autowired
	AsignaturaServicio asigs;
	@Autowired
	SocioServicio ss;
	@Autowired
	AsignaturaServicio asi;

	/**
	 * Cada vez que se pida el recurso sa mostrará un formulario de solicitud. El
	 * solicitante está previamente verificado
	 **/
		/** @ModelAttribute public String datosDeCarga(@RequestParam(name="idcurso",
		  required=false) Long idcurso,@RequestParam(name="nombre", required=false)
		  String nombre,@RequestParam(name="idsocio", required=false) Long idsocio,
		  Model modelo) { modelo.addAttribute("idsocio",idsocio);
		  modelo.addAttribute("nombre", nombre); modelo.addAttribute("idcurso",
		  idcurso); return "solicitarLibros"; }	 
*/
	// Paso 1, tengo la lista de cursos y libros cargada en la página
	@GetMapping({ "/verLibros" })
	public String solicitarLibros(@RequestParam(name = "idcurso", required = false) Long idcurso, Model modelo) {

		modelo.addAttribute("cursos", cs.findAll());

		if (idcurso == null) {
			modelo.addAttribute("libros", ls.findAll());
		} else {
			modelo.addAttribute("libros", ls.librosDeUnCurso(idcurso));
		}
		return "solicitarLibros2";
	}
	// Paso 2 el socio se verifica:

	List<EjemplarVO> misejemplares = new ArrayList<EjemplarVO>();

	// Paso 3: Escoge al alumno, el curso y se muestran los libros necesarios para
	// el curso.
	// Paso 4: cada vez que pulsa el botón de sí, el préstamo se sealiza :
	@RequestMapping("/añadirEjemplar")
	public String prestamosAñadirEjemplar(@RequestParam(name = "idlibro") Long idlibro, Model modelo) {

		misejemplares.add((EjemplarVO) ls.EjemplaresSinPrestar(idlibro));
		System.out.println(misejemplares.size());
		modelo.addAttribute("misejemplares", misejemplares);
		return "solicitarLibros";
	}

	@PostMapping("/insertarPrestamo")

	public String prestamosIinsertarPrestamo(@ModelAttribute @Validated PrestamoVO prestamo, @RequestParam (name="idcurso") Long idcurso,Model modelo) {

		ps.save(prestamo);
		modelo.addAttribute("prestamo",prestamo);
		if (idcurso == null) {
			modelo.addAttribute("libros", ls.findAll());
		} else {
			modelo.addAttribute("libros", ls.librosDeUnCurso(idcurso));
		}
		
		return "solicitarLibros2";
	}

	@RequestMapping("/listaPrestamos")
	// Lista con todos los prestamos
	public String listaPrestamos(Model modelo) {
		modelo.addAttribute("listaPrestamos", ps.findAll());
		// Recurso que devuelvo
		return "/admin/prestamos/listaPrestamos";
	}

	@GetMapping("/prestamo/guardarPrestamo")
	public String prestamoGuardarPrestamo(@ModelAttribute @Validated PrestamoVO prestamo, Model modelo) {

		ps.save(prestamo);

		modelo.addAttribute("cursos", cs.findAll());

		return "index";
	}
	
}
