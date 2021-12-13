package com.ampa.bl.bl.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ampa.bl.bl.dto.UsuarioDTO;
import com.ampa.bl.bl.entidad.UsuarioVO;
import com.ampa.bl.bl.servicio.UsuarioServicio;
@RestController
public class UsuarioWS {
	
	
	@Autowired
	UsuarioServicio us;
	
	@GetMapping("/usuarios")
	public Iterable<UsuarioDTO> mostrarUsuarios() {
		//Construyo una lista vacía que va a almacenar los UsuariosDTO
		List<UsuarioDTO> lista = new ArrayList<>();
		//Relleno la lista a de UsuariosDTO a partir de los UsuariosVO
		for(UsuarioVO u:us.findAll())
			lista.add(new UsuarioDTO(u.getIdusuario(),u.getNombre(), u.getCargo(),u.getUsername(),u.getPassword(),u.getRol()));
		return lista;
		
	}

	@GetMapping("/usuario/{idusuario}")
	public UsuarioDTO buscarUnUsuario(@PathVariable Long idusuario) {
		UsuarioVO uvo = us.findById(idusuario).get();
		UsuarioDTO u = new UsuarioDTO(uvo.getIdusuario(),uvo.getNombre(),uvo.getCargo(),uvo.getUsername(),uvo.getPassword(),uvo.getRol());
		return u;
	}
	@PostMapping("/insertarUsuario")
	public String insertarUsuario(@RequestBody UsuarioDTO udto,BindingResult result) {
		
		//Si hay un error en la implementaión del formulario:
				if(result.hasErrors()) {
					return "Error en campo";
				}else {
					//Guardar nos encriptará la contraseña
					us.registrar(new UsuarioVO(udto.getNombre(),udto.getCargo(),udto.getUsername(),udto.getPassword(),udto.getRol()));
				}
			
		return "Usuario insertado";
	}
	@DeleteMapping("/eliminarUsuario/{idusuario}")
	public String eliminarUsuario(@PathVariable Long idusuario) {
		us.delete(us.findById(idusuario).get());
		return "Usuario eliminado";
	}
	@PutMapping("/modificarUsuario/{idusuario}")
	public String modificarUsuario(@PathVariable Long idusuario, @RequestBody UsuarioDTO usuario) {
		//Construyo un objeto UsuarioVO, y establezco sus valores a través de DTO
		UsuarioVO u = us.findById(idusuario).get();
		u.setNombre(usuario.getNombre());
		u.setCargo(usuario.getCargo());
		u.setUsername(usuario.getUsername());	
		u.setPassword(usuario.getPassword());
		u.setRol(usuario.getRol());
		
		//Guardo el objeto
		us.save(u);
		return "Usuario modificado";
	}
	
}
