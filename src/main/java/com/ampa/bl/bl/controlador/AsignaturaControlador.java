package com.ampa.bl.bl.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.servicio.AsignaturaServicio;
import com.ampa.bl.bl.servicio.CursoServicio;
import com.ampa.bl.bl.servicio.LibroServicio;

@Controller
@RequestMapping("/asignatura")
public class AsignaturaControlador {
	
	
	// Inyecto Servicios para que interactuar con la bbdd
	@Autowired
	private AsignaturaServicio as;
	@Autowired
	private LibroServicio ls;
	@Autowired
	private CursoServicio cs;
	
	@RequestMapping("/listaAsignaturas")	
	public String listaAsignaturas(Model modelo) {
		modelo.addAttribute("listaAsignaturas", as.findAll());		
		return "/admin/asignaturas/listaAsignaturas";
	}

	@RequestMapping("/formAsignatura")	
	public String formAsignatura(Model modelo) {
		//Necesito añadir el listado de libros y el de cursos para hacer la asignación
		modelo.addAttribute("listaLibros", ls.findAll());
		modelo.addAttribute("listaCursos", cs.findAll());
		modelo.addAttribute("asignatura", new AsignaturaVO());
		return "/admin/asignaturas/formAsignatura";
	}
	
	@RequestMapping("/insertaAsignatura")
	//Acción de insertar 
	public String insertaAsignatura(@ModelAttribute AsignaturaVO asignatura, Model modelo) {		
		as.save(asignatura);
		modelo.addAttribute("listaAsignaturas", as.findAll());
		return "/admin/asignaturas/listaAsignaturas";
	}
	
	/** Eliminar una asignatura */
	
	@RequestMapping("/eliminaAsignatura")	
	public String eliminaAsignatura(@RequestParam Long idasignatura, Model modelo) {
		as.delete(as.findByIdasignatura(idasignatura));
		modelo.addAttribute("listaAsignaturas", as.findAll());
		return "/admin/asignaturas/listaAsignaturas";
	}
	
	/**Modificar una asignatura */
	
	@RequestMapping("/modificaAsignatura")	
	public String modificaAsignatura(@RequestParam Long idasignatura, Model modelo) {
		modelo.addAttribute("asignatura", as.findByIdasignatura(idasignatura));
		return "/admin/asignaturas/formAsignatura";
	}
	
	/** Guardar Asignatura */
	@RequestMapping("/guardaAsignatura")
	public String gurdaAsignatura(@ModelAttribute AsignaturaVO asignatura, Model modelo) {
		CursoVO c = cs.findByIdcurso(asignatura.getCurso().getIdcurso());
		c.addasignatura(asignatura);
		as.save(asignatura);
		modelo.addAttribute("listaAsignaturas", as.findAll());
		return "/admin/asignaturas/listaAsignaturas";
	}	
	
	
	
	
	
	
}
