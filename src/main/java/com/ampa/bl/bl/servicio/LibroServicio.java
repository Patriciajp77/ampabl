package com.ampa.bl.bl.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.LibroVO;
import com.ampa.bl.bl.repositorio.LibroRepositorio;

public interface LibroServicio {
	LibroRepositorio getLr();

	void setLr(LibroRepositorio lr);
	
	//Buscar
	LibroVO findByIdlibro(Long idlibro);
	Optional<LibroVO> findByTitulo(String titulo);	
	List<LibroVO> findByAsignatura (AsignaturaVO asignatura);
	Iterable<LibroVO> findAll();	
	List<LibroVO> findByTituloContainsIgnoreCase(String titulo);
	List<LibroVO> librosDeUnCurso(Long idcurso);
	Page<LibroVO> findAllPaginated(Pageable pageable);
	List<EjemplarVO> EjemplaresSinPrestar(Long idlibro);
	Optional<LibroVO> findById(Long idlibro);
	//Guardar
	<S extends LibroVO> S save(S entity);
	 LibroVO insertar(LibroVO l, AsignaturaVO a);
	 void crearMisejemplares(LibroVO l);
	
	//Borrar
	void deleteById(Long id);
	void delete(LibroVO entity);
	void deleteAll();

	
}
