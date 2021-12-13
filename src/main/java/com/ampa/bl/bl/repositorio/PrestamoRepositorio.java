package com.ampa.bl.bl.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.PrestamoVO;
@Repository
public interface PrestamoRepositorio extends JpaRepository<PrestamoVO, Long> {
	
	PrestamoVO findByIdprestamo(Long idprestamo);
	//Lista de prestamos de un alumno
	List<PrestamoVO> findByAlumno (AlumnoVO alumno);
	

}
