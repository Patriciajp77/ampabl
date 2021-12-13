package com.ampa.bl.bl.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ampa.bl.bl.entidad.Rol;
import com.ampa.bl.bl.entidad.UsuarioVO;
import com.ampa.bl.bl.servicio.AlumnoServicio;
import com.ampa.bl.bl.servicio.CursoServicio;
import com.ampa.bl.bl.servicio.EjemplarServicio;
import com.ampa.bl.bl.servicio.LibroServicio;
import com.ampa.bl.bl.servicio.SocioServicio;
import com.ampa.bl.bl.servicio.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {
	
	// Inyecto Servicios para que interactuar con la bbdd
	
			@Autowired
			private UsuarioServicio us;
			
			@Autowired
			AlumnoServicio as;
			@Autowired
			private CursoServicio cs;
			@Autowired
			private LibroServicio ls;
			@Autowired
			private SocioServicio ss;
			@Autowired
			private EjemplarServicio es;
		
			
		
			
			@RequestMapping("/listaUsuarios")			
			public String listaUsuarios(Model modelo) {
				modelo.addAttribute("listaUsuarios", us.findAll());		
				return "/admin/usuarios/listaUsuarios";
			}
			
			
			@RequestMapping("/formInsertaUsuario")			
			public String formUsuario(Model modelo) {
				modelo.addAttribute("rol",Rol.values());
				modelo.addAttribute("usuario", new UsuarioVO());
				return "/admin/usuarios/formInsertaUsuario";
			}
			
			@RequestMapping("/insertaUsuario") 		
			public String insertaUsuario(@ModelAttribute UsuarioVO usuario, Model modelo) {
				modelo.addAttribute("rol",Rol.values());
				us.registrar(usuario);
				modelo.addAttribute("listaUsuarios", us.findAll());
				return "/admin/usuarios/listaUsuarios";
			}
			
			
			
			@RequestMapping("/eliminaUsuario")			
			public String eliminaUsuario(@RequestParam Long idusuario, Model modelo) {
				us.delete(us.findById(idusuario).get());
				modelo.addAttribute("listaUsuarios", us.findAll());
				return "/admin/usuarios/listaUsuarios";
			}
			
			
			
			@RequestMapping("/modificaUsuario")			
			public String modificaUsuario(@RequestParam Long idusuario, Model modelo) {
				modelo.addAttribute("usuario", us.findById(idusuario).get());
				return "/admin/usuarios/formModificaUsuario";
			}
			
			
			
			@RequestMapping("/guardaUsuario")
			public String guardarUsuario(@ModelAttribute UsuarioVO usuario, Model modelo) {
				us.save(usuario);
				modelo.addAttribute("listaUsuarios", us.findAll());
				return "/admin/usuarios/listaUsuarios";
			}

			
			@RequestMapping("/consultas")
			public String consultas(@RequestParam(name="idcurso", required=false) Long idcurso, Model modelo) {
				modelo.addAttribute("cursos",cs.findAll());			
				
				if(idcurso==null) {
					modelo.addAttribute("libros", ls.findAll());
					//modelo.addAttribute("libros", ls.findAllPaginated(pageable));
					//Si lo activo tengo que incluirlo en el método Pageable pageable.
				}else {		
					modelo.addAttribute("libros", es.buscarEjemplaresSinPrestar());				}	
				
				return "/user/consultas";
			}	
			/*
			@RequestMapping("/ejemplaresSinPrestar")
			public String ejemplaresSinPrestar(@RequestParam(name="idcurso", required=false) Long idcurso, Model modelo) {
				modelo.addAttribute("cursos",cs.findAll());		
				/*
				if(idcurso==null) {
					modelo.addAttribute("libros", ls.librosDeUnCurso(idcurso));
				
				}else {	
					List<LibroVO> todos = ls.librosDeUnCurso(idcurso);
					List<LibroVO> todosSinPrestar = new ArrayList<LibroVO>();
					int cuantos= 0;
					
					for (LibroVO libro : todos) {
						List<EjemplarVO> copias=es.buscarEjemplaresSinPrestarDeUnLibro(libro.getIdlibro());
						cuantos =copias.size();
						libro.setNumejemplares(cuantos);
						todosSinPrestar.add(libro);
					}
					modelo.addAttribute("libros", todosSinPrestar);					
				}		
				return "/user/ejemplaresSinPrestar";
					modelo.addAttribute("libros", ls.librosDeUnCurso(idcurso));
			
					modelo.addAttribute("libros", ls.librosDeUnCurso(idcurso));
					return "/user/ejemplaresSinPrestar";
			}
*/
			@RequestMapping("/sociosNuevos")
			public String sociosNuevos(@RequestParam(name="idcurso", required=false) Long idcurso, Model modelo) {
				modelo.addAttribute("cursos",cs.findAll());		
				
				if(idcurso==null) {
					modelo.addAttribute("socios", ss.buscarTodosAlta(2021));
					//modelo.addAttribute("libros", ls.findAllPaginated(pageable));
					//Si lo activo tengo que incluirlo en el método Pageable pageable.
				}else {				
					modelo.addAttribute("libros", ss.buscarTodosAlta(2021));	
				}					
				return "/user/sociosNuevos";
			}
			
			
}
