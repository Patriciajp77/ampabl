package com.ampa.bl.bl.servicio;

import java.util.Optional;

import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.repositorio.CursoRepositorio;

public interface CursoServicio {
	CursoRepositorio getCr();

	void setC(CursoRepositorio Cr);
	
	//Buscar
	CursoVO findByIdcurso(Long idcurso);	
	Iterable<CursoVO> findAll();
	CursoVO findByNombrecurso(String nombrecurso);
	
	
	//Guardar
	<S extends CursoVO> S save(S entity);
	
	//Borrar
	void deleteById(Long id);
	void delete(CursoVO entity);
	void deleteAll();

	Optional<CursoVO> findById(Long idcurso);
}
