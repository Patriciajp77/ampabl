package com.ampa.bl.bl.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.LibroVO;
import com.ampa.bl.bl.entidad.PrestamoVO;

@Repository
public interface EjemplarRepositorio extends JpaRepository<EjemplarVO, Long> {

	EjemplarVO findByIdejemplar(Long idejemplar);

	// Buscar ejemplares no asignados ordenados por de todos libros.

	@Query(value = "Select e from EjemplarVO e where estado = 'SIN_PRESTAR' order by libro")
	List<EjemplarVO> buscarEjemplaresSinPrestar();

	// Buscar ejemplares no prestados de un libro concreto

	@Query(value = "Select e from EjemplarVO e where estado = 'SIN_PRESTAR' and libro = ?1 order by libro")
	List<EjemplarVO> buscarEjemplaresSinPrestarDeUnLibro(Long idlibro);

	// Buscar ejemplares no prestados de un libro concreto y un estado concreto
	@Query(value = "select e from EjemplarVO e where libro = ?1 and estado=?2")

	List<EjemplarVO> buscarEjemplaresPorEstado(Long idlibro, String estado);

	List<EjemplarVO> findByLibro(LibroVO libro);

	List<EjemplarVO> findByPrestamo(PrestamoVO prestamo);

	// Buscar ejemplares que el préstamo sea nulo, es decir esté sin prestar.
	List<EjemplarVO> findByPrestamoIsNull();
	
	
}
