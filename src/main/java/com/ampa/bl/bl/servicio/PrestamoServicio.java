package com.ampa.bl.bl.servicio;

import java.util.List;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.PrestamoVO;
import com.ampa.bl.bl.repositorio.PrestamoRepositorio;

public interface PrestamoServicio {
	PrestamoRepositorio getPr();

	void setPr(PrestamoRepositorio pr);
	
	//Buscar
	PrestamoVO findByIdprestamo(Long idprestamo);
	
	List<PrestamoVO> findByAlumno (AlumnoVO alumno);
	
	Iterable<PrestamoVO> findAll();	
	
	
	//Guardar
	<S extends PrestamoVO> S save(S entity);
	PrestamoVO insertar(PrestamoVO p, AlumnoVO a);
	PrestamoVO insertar(PrestamoVO p, EjemplarVO e);
	
	//Borrar
	void deleteById(Long id);
	void delete(PrestamoVO entity);
	void deleteAll();
}
