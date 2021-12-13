package com.ampa.bl.bl.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.servicio.AsignaturaServicio;
import com.ampa.bl.bl.servicio.CursoServicio;

@Controller
@RequestMapping("/curso")
public class CursoControlador {	
	
	
	//Inyecto Servicios para que interactuar con la bbdd
	@Autowired
	private CursoServicio cs;
	@Autowired
	private AsignaturaServicio as;
	
	@RequestMapping("/listaCursos")
	//Lista con todos los cursos
	public String listaCursos(Model modelo) {
		modelo.addAttribute("listaCursos", cs.findAll());
		//Recurso que devuelvo
		return "/admin/cursos/listaCursos";
	}
	
	//Asignaturas de un curso
	@RequestMapping("/admin/cursos/verAsignaturas")			
	public String verAsignaturas(@RequestParam Long idcurso, Model modelo) {
		modelo.addAttribute("curso", cs.findByIdcurso(idcurso));		
		modelo.addAttribute("listaAsignaturas", as.findByCurso(cs.findByIdcurso(idcurso)));	
		
		//Recurso que devuelvo
		return "/admin/cursos/listaMisAsignaturas";
	}
	
	
	/** Crear un nuevo curso */
	@RequestMapping("/formInsertaCurso")			
	public String formInsertaCurso(Model modelo) {		
		modelo.addAttribute("curso", new CursoVO());
		return "/admin/cursos/formInsertaCurso";
	}
	
	@RequestMapping("/insertaCurso") 	
	public String insertaCurso(@ModelAttribute CursoVO curso, Model modelo) {				
		cs.save(curso);
		modelo.addAttribute("listaCursos", cs.findAll());
		return "/admin/cursos/listaCursos";
	}
	
	/** Eliminar un curso */	
	@RequestMapping("/eliminaCurso")	
	public String eliminaCurso(@RequestParam Long idcurso, Model modelo) {
		
		cs.delete(cs.findByIdcurso(idcurso));
		modelo.addAttribute("listaCursos", cs.findAll());
		return "/admin/cursos/listaCursos";
	}
	
	/**Modificar un curso */	
	@RequestMapping("/modificaCurso")	
	public String modificaCurso(@RequestParam Long idcurso, Model modelo) {
		modelo.addAttribute("curso", cs.findById(idcurso).get());
		return "/admin/cursos/formModificaCurso";
	}
	
	/** Guardar curso */
	@RequestMapping("/guardaCurso")
	public String guardaCurso(@ModelAttribute CursoVO curso, Model modelo) {
		cs.save(curso);
		modelo.addAttribute("listaCursos", cs.findAll());
		return "/admin/cursos/listaCursos";
	}
			

}
