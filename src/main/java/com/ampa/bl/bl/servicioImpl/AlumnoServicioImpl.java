package com.ampa.bl.bl.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.entidad.SocioVO;
import com.ampa.bl.bl.repositorio.AlumnoRepositorio;
import com.ampa.bl.bl.servicio.AlumnoServicio;
@Service
public class AlumnoServicioImpl implements AlumnoServicio {

	@Autowired
	AlumnoRepositorio ar;
	
	
	@Override
	public AlumnoRepositorio getAr() {		
		return ar;
	}

	@Override
	public void setAr(AlumnoRepositorio ar) {
		this.ar = ar;

	}

	@Override
	public AlumnoVO findByIdalumno(Long idalumno) {		
		return ar.findByIdalumno(idalumno);
	}

	@Override
	public AlumnoVO findByNombre(String nombre) {		
		return  ar.findByNombre(nombre);
	}


	@Override
	public List<AlumnoVO> findAlumnosDeUnCurso(CursoVO curso) {		
		return ar.findAlumnosDeUnCurso(curso);
	}

	@Override
	public List<AlumnoVO> findHijos(SocioVO socio) {		
		return ar.findHijos(socio);
	}

	@Override
	public Iterable<AlumnoVO> findAll() {		
		return ar.findAll();
	}

	@Override
	public <S extends AlumnoVO> S save(S entity) {		
		return ar.save(entity);
	}

	

	@Override
	public void deleteById(Long id) {
		 ar.deleteById(id);
		
	}

	@Override
	public void delete(AlumnoVO entity) {
		ar.delete(entity);

	}

	@Override
	public void deleteAll() {
		ar.deleteAll();

	}
	public AlumnoVO insertar(AlumnoVO a, CursoVO c) {
		a.setCurso(c);
		return ar.save(a);
	}
	public AlumnoVO insertar(AlumnoVO a, SocioVO s) {
		a.setNumsocio(s);
		return ar.save(a);
	}

	@Override
	public Page<AlumnoVO> findAllPaginated(Pageable pageable) {
		
		return ar.findAll(pageable);
	}
	
}
