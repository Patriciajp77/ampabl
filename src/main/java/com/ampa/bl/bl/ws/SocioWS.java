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

import com.ampa.bl.bl.dto.SocioDTO;
import com.ampa.bl.bl.entidad.SocioVO;
import com.ampa.bl.bl.servicio.SocioServicio;

@RestController
public class SocioWS {
	
	@Autowired
	SocioServicio ss;
	
	
	
	@GetMapping("/socios")
	public Iterable<SocioDTO> mostrarSocios() {
		//Construyo una lista vacía que va a almacenar los DTO
		List<SocioDTO> lista = new ArrayList<>();
		//Relleno la lista a de DTO a partir de los VO
		for(SocioVO s:ss.findAll())
			lista.add(new SocioDTO(s.getIdsocio(),s.getNombrepadre(),s.getApellido1padre(),s.getApellido2padre(),s.getDnipadre(),s.getNombremadre()
					,s.getApellido1madre(),s.getApellido2madre(),s.getDnimadre(),s.getTelefono(),s.getNombre(),s.getNumhijos(),s.getAlta(),s.getCuota(),s.getEstado()));
		return lista;
		
	}

	@GetMapping("/socio/{idsocio}")
	public SocioDTO buscarUnSocio(@PathVariable Long idsocio) {
		SocioVO svo = ss.findByIdsocio(idsocio);
		SocioDTO s = new SocioDTO(svo.getIdsocio(),svo.getNombrepadre(),svo.getApellido1padre(),svo.getApellido2padre(),svo.getDnipadre()
				,svo.getNombremadre(),svo.getApellido1madre(),svo.getApellido2madre(),svo.getDnimadre(),svo.getTelefono(),svo.getNombre(),svo.getNumhijos(),svo.getAlta(),svo.getCuota(),svo.getEstado());
		return s;
	}
	@PostMapping("/insertarSocio")
	public String insertarSocio(@RequestBody SocioDTO sdto,BindingResult result) {
		
		//Si hay un error en la implementaión del formulario:
				if(result.hasErrors()) {
					return "Error en campo";
				}else {
					//Guardar nos encriptará la contraseña
					ss.save(new SocioVO(sdto.getNombrepadre(),sdto.getApellido1padre(),sdto.getApellido2padre(),sdto.getDnipadre(),sdto.getNombremadre()
							,sdto.getApellido1madre(),sdto.getApellido2madre(),sdto.getDnimadre(),sdto.getTelefono(),sdto.getNumhijos(),sdto.getAlta(),sdto.getCuota(),sdto.getEstado()));
				}
			
		return "Socio insertado";
	}
	@DeleteMapping("/eliminarSocio/{idsocio}")
	public String eliminarSocio(@PathVariable Long idsocio) {
		ss.delete(ss.findByIdsocio(idsocio));
		return "Socio eliminado";
	}
	@PutMapping("/modificarSocio/{idsocio}")
	public String modificarSocio(@PathVariable Long idsocio, @RequestBody SocioDTO socio) {
		
		SocioVO s = ss.findByIdsocio(idsocio);
		s.setNombrepadre(socio.getNombrepadre());
		s.setApellido1padre(socio.getApellido1padre());
		s.setApellido2padre(socio.getApellido2padre());
		s.setDnipadre(socio.getDnipadre());
		s.setNombremadre(socio.getNombremadre());
		s.setApellido1madre(socio.getApellido1madre());
		s.setApellido2madre(socio.getApellido2madre());
		s.setDnimadre(socio.getDnimadre());
		s.setTelefono(socio.getTelefono());
		s.setNombre(socio.getNombre());
		s.setNumhijos(socio.getNumhijos());
		s.setAlta(socio.getAlta());
		s.setCuota(socio.getCuota());
		s.setEstado(socio.getEstado());
		
		
		//Guardo el objeto
		ss.save(s);
		return "Socio modificado";
	}
}
