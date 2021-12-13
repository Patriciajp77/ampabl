package com.ampa.bl.bl.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.EstadoEjemplar;
import com.ampa.bl.bl.entidad.LibroVO;
import com.ampa.bl.bl.repositorio.LibroRepositorio;
import com.ampa.bl.bl.servicio.EjemplarServicio;
import com.ampa.bl.bl.servicio.LibroServicio;
@Service
public class LibroServicioImpl implements LibroServicio {
	
	

	@Autowired
	LibroRepositorio lr;
	@Autowired
	EjemplarServicio es;
	
	@Override
	public LibroRepositorio getLr() {	
		return lr;
	}

	@Override
	public void setLr(LibroRepositorio lr) {
		this.lr = lr;
	}

	@Override
	public LibroVO findByIdlibro(Long idlibro) {		
		return lr.findByIdlibro(idlibro);
	}

	@Override
	public Optional<LibroVO> findByTitulo(String titulo) {		
		return lr.findByTitulo(titulo);
	}



	@Override
	public List<LibroVO> findByAsignatura(AsignaturaVO asignatura) {
		
		return lr.findByAsignatura(asignatura);
	}

	@Override
	public Iterable<LibroVO> findAll() {		
		return lr.findAll();
	}

	@Override
	public <S extends LibroVO> S save(S entity) {		
		return lr.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		lr.deleteById(id);
	}

	@Override
	public void delete(LibroVO entity) {
		lr.delete(entity);
	}

	@Override
	public void deleteAll() {
		lr.deleteAll();
	}

	@Override
	public List<LibroVO> findByTituloContainsIgnoreCase(String titulo) {
		
		return lr.findByTituloContainsIgnoreCase(titulo);
	}
	public Optional<LibroVO> findById(Long idlibro) {		
		return lr.findById(idlibro);
	}
	public LibroVO insertar(LibroVO l, AsignaturaVO a) {
		l.setAsignatura(a);
		return lr.save(l);
	}
	public void crearMisejemplares(LibroVO l) {
		
		for (int i = 0; i < l.getNumejemplares(); i++) {
			EjemplarVO e = new EjemplarVO(l,EstadoEjemplar.SIN_PRESTAR);
			es.save(e);			
		}
	}

	@Override
	public List<LibroVO> librosDeUnCurso(Long idcurso) {
		
		return lr.librosDeUnCurso(idcurso);
	}
	//Para paginación de resultados:
	@Override
	public Page<LibroVO> findAllPaginated(Pageable pageable) {
		
		return  lr.findAll(pageable);
	}

	@Override
	public List<EjemplarVO> EjemplaresSinPrestar(Long idlibro) {
		
		return lr.EjemplaresSinPrestar(idlibro);
	}
	
}
