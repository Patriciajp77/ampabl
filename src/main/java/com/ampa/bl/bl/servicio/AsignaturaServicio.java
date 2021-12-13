package com.ampa.bl.bl.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.repositorio.AsignaturaRepositorio;

public interface AsignaturaServicio {
	
	AsignaturaRepositorio getAsr();
	
	void setAsr(AsignaturaRepositorio asr);
	
	//Buscar;
	AsignaturaVO findByIdasignatura(Long idasignatura);
	Page<AsignaturaVO> findAllPaginated(Pageable pageable);
	List<AsignaturaVO> findByCurso(CursoVO curso);
	Iterable<AsignaturaVO> findAll();
	
	//Guardar
	<S extends AsignaturaVO> S save(S entity);
	
	//Borrar
	void deleteById(Long id);
	void delete(AsignaturaVO entity);
	void deleteAll();


}
