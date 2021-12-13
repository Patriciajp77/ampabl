package com.ampa.bl.bl.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ampa.bl.bl.entidad.EstadoSocio;
import com.ampa.bl.bl.entidad.PrestamoVO;
import com.ampa.bl.bl.entidad.SocioVO;
import com.ampa.bl.bl.servicio.AlumnoServicio;
import com.ampa.bl.bl.servicio.AsignaturaServicio;
import com.ampa.bl.bl.servicio.CursoServicio;
import com.ampa.bl.bl.servicio.EjemplarServicio;
import com.ampa.bl.bl.servicio.LibroServicio;
import com.ampa.bl.bl.servicio.PrestamoServicio;
import com.ampa.bl.bl.servicio.SocioServicio;
import com.ampa.bl.bl.servicio.UsuarioServicio;
import com.ampa.bl.bl.util.ValidacionDNI;

@Controller

public class InicioControlador {
	@Autowired
	UsuarioServicio us;
	@Autowired
	CursoServicio cs;
	@Autowired
	LibroServicio ls;
	
	@Autowired
	EjemplarServicio es;
	@Autowired
	SocioServicio ss;
	@Autowired
	AsignaturaServicio asi;
	@Autowired
	AlumnoServicio as;
	@Autowired
	PrestamoServicio ps;

	// Método que me devuelve una vista, en este caso index
	
	@RequestMapping({"/","/index"})
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("/zonaprivada")
	public String zonaprivada() {
		return "/user/zonaprivada";
	}
	@RequestMapping("/admin")
	public String admin() {
		return "/admin/gestion";
	}
	
	@RequestMapping("/403")
	public String error() {
		return "403";
	}
	@RequestMapping("/user")
	public String user() {
		return "/user/consultas";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
	/** Verificación del DNI del socio */
	@RequestMapping("/solicitar")
	public String solicitar(@RequestParam String cadena, @RequestParam(name="idcurso", required=false) Long idcurso,Model modelo) {	
		ValidacionDNI dni = new ValidacionDNI(cadena);
		if (dni.validar()) {
			// Busco al socio
			try {
				SocioVO socio = ss.buscarSocioPorDni(cadena);
				if (socio.getEstado() == EstadoSocio.ALTA) {
					modelo.addAttribute("socio", socio);
					modelo.addAttribute("nombre",socio.getNombre());
					modelo.addAttribute("alumnos", as.findHijos(socio));
					modelo.addAttribute("cursos", cs.findAll());
					if(idcurso==null) {
						modelo.addAttribute("asignaturas", asi.findAll());						
					}else {		
						modelo.addAttribute("asignaturas", asi.findByCurso(cs.findByIdcurso(idcurso)));
					}
					PrestamoVO prestamo = new PrestamoVO();
					prestamo.setFecha(LocalDate.now());
					ps.save(prestamo);
					modelo.addAttribute("prestamo", prestamo);
					return "solicitarLibros";
					
				} else {
					String mensaje = "No puedes acceder al servicio.";
					modelo.addAttribute("mensaje", mensaje);
					return "index/#solicitar";
				}
			} catch (Exception e) {

				// Envío mensaje de error usuario no existe.
				String mensaje = "Solo los soci@s pueden acceder a este servicio";
				modelo.addAttribute("mensaje", mensaje);
				return "index";
			}
		} else {
			String mensaje = "El DNI no es válido.";
			modelo.addAttribute("mensaje", mensaje);
			return "index";
		}
	}
	
	
}
