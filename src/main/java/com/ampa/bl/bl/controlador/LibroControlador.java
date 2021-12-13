package com.ampa.bl.bl.controlador;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.EstadoEjemplar;
import com.ampa.bl.bl.entidad.LibroVO;
import com.ampa.bl.bl.servicio.AsignaturaServicio;
import com.ampa.bl.bl.servicio.EjemplarServicio;
import com.ampa.bl.bl.servicio.LibroServicio;
import com.ampa.bl.bl.servicio.PrestamoServicio;

@Controller

public class LibroControlador {
	
	// Inyecto Servicios para que interactuar con la bbdd
				@Autowired
				 LibroServicio ls;
				@Autowired
				 EjemplarServicio es;
				@Autowired
				 PrestamoServicio ps;
				@Autowired
				 AsignaturaServicio as;
			
			/** Cada vez que se pida el recurso sa mostrará una lista con los libros actuales de la base de datos*/				
				@RequestMapping("/listaLibros")
				//Lista con todos los libros
				public String listaLibros(Model modelo) {					
					modelo.addAttribute("listaLibros", ls.findAll());
					//Recurso que devuelvo
					//return "redirect:/admin/libros/listaLibros";
					return "redirect:listaLibros";
				}				
				//Ejemplares de un libro
				@RequestMapping("/verEjemplares")			
				public String verEjemplares(@RequestParam Long idlibro, Model modelo) {
					modelo.addAttribute("libro", ls.findByIdlibro(idlibro));
					modelo.addAttribute("listaEjemplares", es.findByLibro(ls.findByIdlibro(idlibro)));
							
					//Recurso que devuelvo
					return "redirect:/admin/libros/listalibros";
				}			
				
				/** Crear un nuevo libro */				
				@GetMapping("/insertaLibro")				
				public String insertaLibro(@ModelAttribute LibroVO libro, Model modelo) {
					ls.save(libro);
					modelo.addAttribute("listaLibros", ls.findAll());
					return "redirect:/admin/libros/listalibros";
				}				
				@PostMapping("/guardaLibro") 
				//Acción de insertar 
				public String guardaLibro(@ModelAttribute LibroVO libro, Model modelo) {				
					
					if(libro.getNumejemplares()> es.findByLibro(libro).size()) {
						int cuantos = libro.getNumejemplares() - libro.getNumejemplares();
						for (int i = 0; i < cuantos; i++) {
							EjemplarVO e = new EjemplarVO(libro,EstadoEjemplar.SIN_PRESTAR);
							es.save(e);
						}
						
					}else {
						//Guardo el libro
						ls.save(libro);	
					}				
					
					//Con este método creo los n ejemplares que voy a usar.
					ls.crearMisejemplares(libro);
					//Añado el libro a la vista que los muestra todos
					modelo.addAttribute("listaLibros", ls.findAll());
					return "redirect:/admin/libros/listalibros";
				}
					// Eliminar un libro 				
				@RequestMapping("/eliminaLibro")				
				public String eliminaLibro(@RequestParam Long idlibro, Model modelo) {
					//Busco el objeto
					LibroVO l = ls.findByIdlibro(idlibro);
					//¿Tiene ejemplares?
					List<EjemplarVO> copias = es.findByLibro(l);
					//Recorro y borro
					for (EjemplarVO e : copias) {
						if (e.getEstado().equals(EstadoEjemplar.DESCATALOGADO) || (e.getEstado().equals(EstadoEjemplar.SIN_PRESTAR))){
							es.delete(e);}											
					}
					ls.delete(l);				
					modelo.addAttribute("listaLibros", ls.findAll());
					return "redirect:/admin/libros/listalibros";
				}
				
				/**Modificar un libro */				
				@GetMapping("/modificaLibro")				
				public String modificaLibro(@RequestParam Long idlibro, Model modelo) {
					List<AsignaturaVO> asignaturas = (List<AsignaturaVO>) as.findAll();
					modelo.addAttribute("libro", ls.findByIdlibro(idlibro));
					modelo.addAttribute("asignaturas", asignaturas);
					return "/admin/libros/formModificarLibro";
				}			
				@RequestMapping("/formInsertaLibro")
				public String formInsertaLibro(Model modelo){
					
					modelo.addAttribute("asignaturas", as.findAll());
					
					modelo.addAttribute("libro",new LibroVO());
					return "redirect:/admin/libros/formInsertaLibro";
				}

}
