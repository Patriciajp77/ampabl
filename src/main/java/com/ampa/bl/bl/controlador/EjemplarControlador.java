package com.ampa.bl.bl.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.servicio.EjemplarServicio;

@Controller
@RequestMapping("/ejemplar")
public class EjemplarControlador {
	// Inyecto Servicios para que interactuar con la bbdd
	@Autowired
	private EjemplarServicio es;

	@ModelAttribute
	public List<EjemplarVO> ejemplaresNoPrestados(){
		return es.buscarEjemplaresSinPrestar();
	}
	
	//Lista ejemplares no prestados para consulta
	@GetMapping("/ejemplaresSinPrestar")
	public String consultaEjemplaresSinPrestar(Model modelo) {
		modelo.addAttribute("listaEjemplares", es.buscarEjemplaresSinPrestar());
		return "/usarios/ejemplaresSinPrestar";
	}
	
/** Cada vez que se pida el recurso sa mostrará un campo de búsqueda por el título del libro ???? */
	
	@RequestMapping("/gestionEjemplares")
	//Lista con todos los socios
	public String gestionEjemplares(Model modelo) {
		modelo.addAttribute("gestionEjemplares", es.findAll());
		//Recurso que devuelvo
		return "/admin/ejemplares/gestionEjemplares";
	}
	/** Crear un nuevo libro */
	@RequestMapping("/admin/ejemplares/formInsertarEjemplar")
	
	public String formInsertarEjemplar(Model modelo) {
		modelo.addAttribute("ejemplar", new EjemplarVO());
		return "/admin/ejemplares/formInsertarLibro";
	}
	
	@RequestMapping("/admin/ejemplares/insertarEjemplar") 
	//Acción de insertar 
	public String insertarEjemplar(@ModelAttribute EjemplarVO ejemplar, Model modelo) {
		es.save(ejemplar);					
		modelo.addAttribute("gestionEjemplares", es.findAll());
		return "/admin/ejemplares/gestionEjemplares";
	}
	
	/** Eliminar un ejemplar */
	
	@RequestMapping("/admin/ejemplares/eliminarEjemplar")
	
	public String eliminarEjemplar(@RequestParam Long idejemplar, Model modelo) {
		es.delete(es.findByIdejemplar(idejemplar));
		modelo.addAttribute("gestionEjemplares", es.findAll());
		return "/admin/ejemplares/gestionEjemplares";
	}
	
	/**Modificar un ejemplar */
	
	@RequestMapping("/admin/ejemplares/modificarEjemplar")
	
	public String modificarEjemplar(@RequestParam Long idejemplar, Model modelo) {
		modelo.addAttribute("ejemplar", es.findByIdejemplar(idejemplar));
		return "/admin/ejemplares/formModificarEjemplar";
	}
	
	/** Guardar ejemplar */
	@RequestMapping("/admin/ejemplares/guardarEjemplar")
	public String guardarEjemplar(@ModelAttribute EjemplarVO ejemplar, Model modelo) {
		es.save(ejemplar);
		modelo.addAttribute("gestionEjemplares", es.findAll());
		return "/admin/ejemplares/gestionEjemplares";
	}	

}
