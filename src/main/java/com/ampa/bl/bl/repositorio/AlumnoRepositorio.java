package com.ampa.bl.bl.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.entidad.SocioVO;
@Repository
public interface AlumnoRepositorio extends JpaRepository<AlumnoVO, Long> {
	AlumnoVO findByIdalumno(Long idalumno);
	AlumnoVO findByNombre(String nombre);	
	List<AlumnoVO> findByApellido1(String apellido1);
	List<AlumnoVO> findByApellido2(String apellido2);
	
	//Buscar todos los alumnos de un curso:
	@Query(value="select a from AlumnoVO a where curso=?1")
	List<AlumnoVO> findAlumnosDeUnCurso(CursoVO curso);
	
	//Buscar todos los hijos de un socio:
	@Query(value="select a from AlumnoVO a where numsocio=?1")
	List<AlumnoVO> findHijos(SocioVO socio);
	

}
