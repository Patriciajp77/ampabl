package com.ampa.bl.bl.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.entidad.CursoVO;
@Repository
public interface AsignaturaRepositorio extends JpaRepository<AsignaturaVO, Long> {
	AsignaturaVO findByIdasignatura(Long idasignatura);
	AsignaturaVO findByNombreasignatura(String nombreasignatura);
	List<AsignaturaVO> findByCurso(CursoVO curso);
	
	
	
	
	
	
	
	

}
