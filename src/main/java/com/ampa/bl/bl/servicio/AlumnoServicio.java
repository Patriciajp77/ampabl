package com.ampa.bl.bl.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.entidad.SocioVO;
import com.ampa.bl.bl.repositorio.AlumnoRepositorio;

public interface AlumnoServicio {
	AlumnoRepositorio getAr();

	void setAr(AlumnoRepositorio ar);
	
	//Buscar
	AlumnoVO findByIdalumno(Long idalumno);
	AlumnoVO findByNombre(String nombre);
	List<AlumnoVO> findAlumnosDeUnCurso(CursoVO curso);
	List<AlumnoVO> findHijos(SocioVO socio);
	Iterable<AlumnoVO> findAll();	
	Page<AlumnoVO> findAllPaginated(Pageable pageable);
	
	//Guardar
	<S extends AlumnoVO> S save(S entity);
	 AlumnoVO insertar(AlumnoVO a, CursoVO c);
	 AlumnoVO insertar(AlumnoVO a, SocioVO s);
	
	//Borrar
	void deleteById(Long id);
	void delete(AlumnoVO entity);
	void deleteAll();

}
