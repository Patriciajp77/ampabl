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

import com.ampa.bl.bl.dto.AlumnoDTO;
import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.servicio.AlumnoServicio;
import com.ampa.bl.bl.servicio.AsignaturaServicio;

@RestController
public class AlumnoWS {
	@Autowired
	AlumnoServicio as;
	@Autowired
	AsignaturaServicio ass;
	
	@GetMapping("/alumnos")
	public Iterable<AlumnoDTO> mostrarAlumnos() {
		//Construyo una lista vacía que va a almacenar los DTO
		List<AlumnoDTO> lista = new ArrayList<>();
		//Relleno la lista  de DTO a partir de los VO
		for(AlumnoVO a:as.findAll())
			lista.add(new AlumnoDTO(a.getIdalumno(),a.getNombre(),a.getApellido1(),a.getApellido2(),a.getNumsocio(),a.getCurso()));
		return lista;
		
	}

	@GetMapping("/alumno/{idalumno}")
	public AlumnoDTO buscarUnAlumno(@PathVariable Long idalumno) {
		AlumnoVO avo = as.findByIdalumno(idalumno);
		AlumnoDTO a = new AlumnoDTO(avo.getIdalumno(),avo.getNombre(),avo.getApellido1(),avo.getApellido2(),avo.getNumsocio(),avo.getCurso());
		return a;
	}
	@PostMapping("/insertarAlumno")
	public String insertarAlumno(@RequestBody AlumnoDTO adto) {	
		as.save(new AlumnoVO(adto.getNombre(),adto.getApellido1(),adto.getApellido2(),adto.getCurso(),adto.getSocio()));
		return "Alumno insertado";
	}
	@DeleteMapping("/eliminarAlumno/{idalumno}")
	public String eliminarAlumno(@PathVariable Long idalumno) {
		as.delete(as.findByIdalumno(idalumno));
		return "Alumno eliminado";
	}
	@PutMapping("/modificarAlumno/{idalumno}")
	public String modificarAlumno(@PathVariable Long idalumno, @RequestBody AlumnoDTO alumno) {
		//Construyo un objeto VO, y establezco sus valores a través de DTO
		AlumnoVO a = as.findByIdalumno(idalumno);
		a.setNombre(alumno.getNombre());
		a.setApellido1(alumno.getApellido1());
		a.setApellido2(alumno.getApellido2());	
		a.setCurso(alumno.getCurso());
		a.setNumsocio(alumno.getSocio());
		
		//Guardo el objeto
		as.save(a);
		return "Alumno modificado";
	}
}
