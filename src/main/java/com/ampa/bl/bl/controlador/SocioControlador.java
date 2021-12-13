package com.ampa.bl.bl.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.EstadoSocio;
import com.ampa.bl.bl.entidad.SocioVO;
import com.ampa.bl.bl.servicio.AlumnoServicio;
import com.ampa.bl.bl.servicio.SocioServicio;

@Controller
@RequestMapping("/socio")
public class SocioControlador {
	
		// Inyecto Servicios para que interactuar con la bbdd
			@Autowired
			private SocioServicio ss;
			@Autowired
			private AlumnoServicio as;
			
			
			
		/** Cada vez que se pida el recurso sa mostrará una lista con los socios actuales de la base de datos*/
			
			@RequestMapping("/listaSocio")
			//Lista con todos los socios
			public String listaSocio(Model modelo) {
				modelo.addAttribute("listaSocio", ss.findAll());
				//Recurso que devuelvo
				return "/admin/socios/listaSocio";
			}
			//Hijos de un socio
			@RequestMapping("/verHijos")			
			public String verHijos(@RequestParam Long idsocio, Model modelo) {
				modelo.addAttribute("socio", ss.findByIdsocio(idsocio));
				modelo.addAttribute("listaAlumnos", as.findHijos(ss.findByIdsocio(idsocio)));
				//Recurso que devuelvo
				return "/admin/socios/listaHijos";
			}
			/** Crear un nuevo socio */
			@RequestMapping("/formInsertaSocio")			
			public String formInsertaSocio(Model modelo) {
				modelo.addAttribute("estados", EstadoSocio.values().toString());
				modelo.addAttribute("socio", new SocioVO());
				return "/admin/socios/formInsertaSocio";
			}
			
			@RequestMapping("/insertaSocio") 
			//Acción de insertar 
			public String insertaSocio(@ModelAttribute SocioVO socio, Model modelo) {	
				socio.setNombre((socio.getApellido1padre() +" - "+socio.getApellido1madre()));
				ss.save(socio);
				modelo.addAttribute("listaSocio", ss.findAll());
				return "/admin/socios/listaSocio";
			}
			
			/** Eliminar un socio */
			
			@RequestMapping("/eliminaSocio")
			
			public String eliminaSocio(@RequestParam Long idsocio, Model modelo) {
				
				List<AlumnoVO> hijos = as.findHijos(ss.findByIdsocio(idsocio));
				for (AlumnoVO alumnoVO : hijos) {					
					as.delete(alumnoVO);
				}
				ss.delete(ss.findByIdsocio(idsocio));
				modelo.addAttribute("listaSocio", ss.findAll());
				return "/admin/socios/listaSocio";
			}
			
			/**Modificar un socio */
			
			@RequestMapping("/modificaSocio")
			
			public String modificarSocio(@RequestParam (name = "idsocio", required = true) Long idsocio, Model modelo) {
				modelo.addAttribute("socio", ss.findByIdsocio(idsocio));
				return "/admin/socios/formModificaSocio";
			}
			
			/** Guardar Socio */
			@RequestMapping("/guardaSocio")
			public String guardaSocio(@ModelAttribute SocioVO socio, Model modelo) {				
				ss.save(socio);
				for (int i = 0; i < socio.getNumhijos(); i++) {
					AlumnoVO a = new AlumnoVO();
					a.setNumsocio(socio);
					a.setApellido1(socio.getApellido1padre());
					a.setApellido2(socio.getApellido1madre());
					as.save(a);
				}
				modelo.addAttribute("listaSocio", ss.findAll());
				return "/admin/socios/listaSocio";
			}
			
			
			
			
			
}
