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

import com.ampa.bl.bl.dto.LibroDTO;
import com.ampa.bl.bl.entidad.LibroVO;
import com.ampa.bl.bl.servicio.LibroServicio;

@RestController
public class LibroWS {
	
	@Autowired
	LibroServicio ls;
	
	
	
	
	@GetMapping("/libros")
	public Iterable<LibroDTO> mostrarLibros() {
		//Construyo una lista vacía que va a almacenar los DTO
		List<LibroDTO> lista = new ArrayList<>();
		//Relleno la lista a de DTO a partir de los VO
		for(LibroVO l:ls.findAll())
			lista.add(new LibroDTO(l.getIdlibro(),l.getTitulo(),l.getAsignatura(),l.getNumejemplares(),l.getEstado()));
		return lista;
		
	}

	@GetMapping("/libro/{idlibro}")
	public LibroDTO buscarUnLibro(@PathVariable Long idlibro) {
		LibroVO lvo = ls.findByIdlibro(idlibro);
		LibroDTO l = new LibroDTO(lvo.getIdlibro(),lvo.getTitulo(),lvo.getAsignatura(),lvo.getNumejemplares(),lvo.getEstado());
		return l;
	}
	@PostMapping("/insertarLibro")
	public String insertarLibro(@RequestBody LibroDTO ldto,BindingResult result) {
		
		//Si hay un error en la implementaión del formulario:
				if(result.hasErrors()) {
					return "Error en campo";
				}else {
					//Guardar nos encriptará la contraseña
					ls.save(new LibroVO(ldto.getTitulo(),ldto.getAsignatura(),ldto.getNumejemplares(),ldto.getEstado()));
				}
			
		return "Libro insertado";
	}
	@DeleteMapping("/eliminarLibro/{idlibro}")
	public String eliminarUsuario(@PathVariable Long idlibro) {
		ls.delete(ls.findByIdlibro(idlibro));
		return "Libro eliminado";
	}
	@PutMapping("/modificarLibro/{idlibro}")
	public String modificarLibro(@PathVariable Long idlibro, @RequestBody LibroDTO libro) {
		//Construyo un objeto VO, y establezco sus valores a través de DTO
		LibroVO l = ls.findByIdlibro(idlibro);
		l.setIdlibro(libro.getIdlibro());
		l.setTitulo(libro.getTitulo());
		l.setAsignatura(libro.getAsignatura());
		l.setNumejemplares(libro.getNumejemplares());
		l.setEstado(libro.getEstado());
		
		//Guardo el objeto
		ls.save(l);
		return "Usuario modificado";
	}
	
}
