package com.ampa.bl.bl.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.LibroVO;
@Repository
public interface LibroRepositorio extends JpaRepository<LibroVO, Long> {

	Optional<LibroVO> findByTitulo(String titulo);	
	LibroVO findByIdlibro(Long idlibro);
	List<LibroVO> findByAsignatura (AsignaturaVO asignatura);	
	List<LibroVO> findByTituloContainsIgnoreCase(String titulo);
	
	@Query(value="SELECT l.idlibro,l.titulo,l.estado,l.numejemplares,l.idasignatura FROM ampabl.libros l,ampabl.cursos c, ampabl.asignaturas a where l.idasignatura and a.idcurso = c.idcurso and c.idcurso=? ", nativeQuery = true)
	List<LibroVO> librosDeUnCurso(Long idcurso);
	
	
	@Query(value="SELECT * FROM  ampabl.ejemplares e  where e.estado='SIN_Prestar' and e.idlibro=?", nativeQuery = true)
	List<EjemplarVO> EjemplaresSinPrestar(Long idlibro);
	
	Optional <LibroVO> findById(Long idlibro);
	

}
