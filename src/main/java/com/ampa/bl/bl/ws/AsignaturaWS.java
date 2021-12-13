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

import com.ampa.bl.bl.dto.AsignaturaDTO;
import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.servicio.AsignaturaServicio;

@RestController
public class AsignaturaWS {
	@Autowired
	AsignaturaServicio as;
	
	@GetMapping("/asignaturas")
	public Iterable<AsignaturaDTO> mostrarAsignaturas() {
		//Construyo una lista vacía que va a almacenar los DTO
		List<AsignaturaDTO> lista = new ArrayList<>();
		//Relleno la lista  de DTO a partir de los VO
		for(AsignaturaVO a:as.findAll())
			lista.add(new AsignaturaDTO(a.getIdasignatura(),a.getNombreasignatura(),a.getCurso(),a.getLibro()));
		return lista;
		
	}

	@GetMapping("/asignatura/{idasignatura}")
	public AsignaturaDTO buscarUnaAsignatura(@PathVariable Long idasignatura) {
		AsignaturaVO avo = as.findByIdasignatura(idasignatura);
		AsignaturaDTO a = new AsignaturaDTO(avo.getIdasignatura(),avo.getNombreasignatura(),avo.getCurso(),avo.getLibro());
		return a;
	}
	@PostMapping("/insertarAsignatura")
	public String insertarAsignatura(@RequestBody AsignaturaDTO adto,BindingResult result) {
		
		//Si hay un error en la implementaión del formulario:
				if(result.hasErrors()) {
					return "Error en campo";
				}else {
					//Guardar nos encriptará la contraseña
					as.save(new AsignaturaVO(adto.getNombreasignatura(),adto.getCurso(),adto.getLibro()));
				}
			
		return "Asignatura insertada";
	}
	@DeleteMapping("/eliminarAsignatura/{idasignatura}")
	public String eliminarAsignatura(@PathVariable Long idasignatura) {
		as.delete(as.findByIdasignatura(idasignatura));
		return "Asignatura eliminada";
	}
	@PutMapping("/modificarAsignatura/{idasignatura}")
	public String modificarAsignatura(@PathVariable Long idasignatura, @RequestBody AsignaturaDTO asignatura) {
		//Construyo un objeto UsuarioVO, y establezco sus valores a través de DTO
		AsignaturaVO a = as.findByIdasignatura(idasignatura);
		a.setNombreasignatura(asignatura.getNombreasignatura());
		a.setCurso(asignatura.getCurso());
		a.setLibro(asignatura.getLibro());	
		
		//Guardo el objeto
		as.save(a);
		return "Asignatura modificada";
	}
	

}
