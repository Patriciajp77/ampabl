package com.ampa.bl.bl.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.SocioVO;
import com.ampa.bl.bl.servicio.AlumnoServicio;
import com.ampa.bl.bl.servicio.CursoServicio;
import com.ampa.bl.bl.servicio.SocioServicio;

@Controller
@RequestMapping("/alumno")
public class AlumnoControlador {

	// Inyecto Servicios para que interactuar con la bbdd
	@Autowired
	private AlumnoServicio as;
	@Autowired
	SocioServicio ss;
	@Autowired
	CursoServicio cs;
	
	
	

	/**
	 * Cada vez que se pida el recurso sa mostrará una lista con los alumnos
	 * actuales de la base de datos
	 */
	@RequestMapping("/listaAlumnos")
	public String listaAlumnos(Model modelo) {	
		modelo.addAttribute("listaAlumnos", as.findAll());	
		return "admin/alumnos/listaAlumnos";
	}

	@RequestMapping("/formInsertaAlumno")
	public String formInsertaAlumno(Model modelo){
		modelo.addAttribute("cursos", cs.findAll());
		modelo.addAttribute("socios", ss.findAll());
		
		modelo.addAttribute("alumno",new AlumnoVO());
		return "admin/alumnos/formInsertaAlumno";
	}
		
	
	@RequestMapping("/insertaAlumno")
	public String insertaAlumno(@ModelAttribute AlumnoVO alumno, Model modelo) {
		
		SocioVO s =ss.findByIdsocio(alumno.getNumsocio().getIdsocio());
		alumno.setApellido1(s.getApellido1padre());
		alumno.setApellido2(s.getApellido1madre());
		as.save(alumno);
		modelo.addAttribute("listaAlumno", as.findAll());
		return "admin/alumnos/listaAlumnos";
	}
		
	@RequestMapping("/eliminaAlumno")
	public String eliminaAlumno(@RequestParam Long idalumno, Model modelo) {
		as.delete(as.findByIdalumno(idalumno));
		modelo.addAttribute("listaAlumno", as.findAll());
		return "admin/alumnos/listaAlumnos";
	}
	
	@RequestMapping("/modificaAlumno")
	public String modificaAlumno(@RequestParam Long idalumno, Model modelo) {
		modelo.addAttribute("cursos", cs.findAll());		
		modelo.addAttribute("alumno", as.findByIdalumno(idalumno));	
		return "/admin/alumnos/formModificaAlumno";
	}
	
	
	@RequestMapping("/guardaAlumno")
	public String guardaAlumno(@ModelAttribute AlumnoVO alumno, Model modelo) {	
		
		SocioVO s =ss.findByIdsocio(alumno.getNumsocio().getIdsocio());
		alumno.setApellido1(s.getApellido1padre());
		alumno.setApellido2(s.getApellido1madre());
		as.save(alumno);
		modelo.addAttribute("listaAlumno", as.findAll());
		return "/admin/alumnos/listaAlumnos";
	}

	
}
