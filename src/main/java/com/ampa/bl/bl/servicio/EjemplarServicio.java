package com.ampa.bl.bl.servicio;

import java.util.List;

import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.LibroVO;
import com.ampa.bl.bl.entidad.PrestamoVO;
import com.ampa.bl.bl.repositorio.EjemplarRepositorio;

public interface EjemplarServicio {
	EjemplarRepositorio getEr();

	void setEr(EjemplarRepositorio er);
	
	//Buscar
	EjemplarVO findByIdejemplar(Long idejemplar);
	List<EjemplarVO> findByEstadoejemplar (Long idlibro,String estado);

	List<EjemplarVO> findByLibro (LibroVO libro);
 	Iterable<EjemplarVO> findAll();	
 	List<EjemplarVO> findByPrestamo(PrestamoVO prestamo);
 	List<EjemplarVO> findByPrestamoIsNull();
 	List<EjemplarVO> buscarEjemplaresSinPrestar();
 	List<EjemplarVO> buscarEjemplaresSinPrestarDeUnLibro(Long idlibro);
 	
	//Guardar
	<S extends EjemplarVO> S save(S entity);
	
	//Borrar
	void deleteById(Long id);
	void delete(EjemplarVO entity);
	void deleteAll();
	
}
