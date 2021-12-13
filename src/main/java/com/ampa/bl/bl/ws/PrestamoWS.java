package com.ampa.bl.bl.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ampa.bl.bl.dto.PrestamoDTO;
import com.ampa.bl.bl.entidad.PrestamoVO;
import com.ampa.bl.bl.servicio.AlumnoServicio;
import com.ampa.bl.bl.servicio.AsignaturaServicio;
import com.ampa.bl.bl.servicio.CursoServicio;
import com.ampa.bl.bl.servicio.EjemplarServicio;
import com.ampa.bl.bl.servicio.LibroServicio;
import com.ampa.bl.bl.servicio.PrestamoServicio;
@RestController
public class PrestamoWS {
	@Autowired
	PrestamoServicio ps;
	EjemplarServicio es;
	@Autowired
	LibroServicio ls;
	@Autowired
	AlumnoServicio as;
	@Autowired
	CursoServicio cs;
	@Autowired
	AsignaturaServicio asigs;
		
	
	
	
	
	
	@GetMapping("/prestamos")
	public Iterable <PrestamoDTO> mostrarPrestamos() {
		List<PrestamoDTO> lista=new ArrayList<>();
		for(PrestamoVO p:ps.findAll())
			lista.add(new PrestamoDTO(p.getIdprestamo(),p.getFecha(),p.getAlumno()));
		return lista;
	}

	
	@PostMapping("/insertarPrestamo")
	public String insertarPrestamo(@RequestBody PrestamoDTO pdto) {		
		ps.save(new PrestamoVO(pdto.getIdprestamo(),pdto.getFecha(),pdto.getAlumno()));		
		return "Préstamo insertado";
	}
	
}
