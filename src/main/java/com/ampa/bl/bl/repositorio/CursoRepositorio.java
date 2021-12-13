package com.ampa.bl.bl.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ampa.bl.bl.entidad.CursoVO;
@Repository
public interface CursoRepositorio extends JpaRepository<CursoVO, Long> {
	CursoVO findByIdcurso(Long idcurso);
	
	//Hago una query combinada para obtener las asignaturas de un curso por su id
	//	@Query("SELECT c FROM CursoVO c left outer join c.asignaturas a where c.idcurso=:idcurso")
	//	CursoVO buscarAsignaturasDeCurso(Long idcurso);

		CursoVO findByNombrecurso(String nombrecurso);

	

}
