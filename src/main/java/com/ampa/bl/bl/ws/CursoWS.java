package com.ampa.bl.bl.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ampa.bl.bl.dto.CursoDTO;
import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.servicio.CursoServicio;

@RestController
public class CursoWS {
	
	
	@Autowired
	CursoServicio cs;
	
	@GetMapping("/cursos")
	public Iterable<CursoDTO> mostrarCursos() {
		//Construyo una lista vacía que va a almacenar los CursosDTO
		List<CursoDTO> lista = new ArrayList<>();
		//Relleno la lista a de CursosDTO a partir de los CursosVO
		for(CursoVO c:cs.findAll())
			lista.add(new CursoDTO(c.getIdcurso(),c.getNombrecurso()));
		return lista;		
	}

	@GetMapping("/curso/{idcurso}")
	public CursoDTO buscarUnCurso(@PathVariable Long idcurso) {
		CursoVO cvo = cs.findById(idcurso).get();
		CursoDTO c = new CursoDTO(cvo.getIdcurso(),cvo.getNombrecurso());
		return c;
	}
	@PostMapping("/insertarCurso")
	public String insertarCurso(@RequestBody CursoDTO cdto) {
		cs.save(new CursoVO(cdto.getNombrecurso()));
		return "Curso insertado";
	}
	@DeleteMapping("/eliminarCurso/{idcurso}")
	public String eliminarCurso(@PathVariable Long idcurso) {
		cs.delete(cs.findById(idcurso).get());
		return "Curso eliminado";
	}
	@PutMapping("/modificarCurso/{idcurso}")
	public String modificarCurso(@PathVariable Long idcurso, @RequestBody CursoDTO curso) {
		//Construyo un objeto CursoVO, y establezco sus valores a través de DTO
		CursoVO c = cs.findById(idcurso).get();
		c.setNombrecurso(curso.getNombrecurso());		
		//Guardo el objeto
		cs.save(c);
		return "Curso modificado";
	}

}
