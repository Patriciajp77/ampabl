package com.ampa.bl.bl.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.LibroVO;
import com.ampa.bl.bl.entidad.PrestamoVO;
import com.ampa.bl.bl.repositorio.EjemplarRepositorio;
import com.ampa.bl.bl.servicio.EjemplarServicio;

@Service
public class EjemplarServicioImpl implements EjemplarServicio {

	@Autowired
	EjemplarRepositorio er;

	@Override
	public EjemplarRepositorio getEr() {		
		return er;
	}

	@Override
	public void setEr(EjemplarRepositorio er) {
		this.er = er;
	}

	@Override
	public EjemplarVO findByIdejemplar(Long idejemplar) {		
		return er.findByIdejemplar(idejemplar);
	}

	@Override
	public List<EjemplarVO> findByEstadoejemplar(Long idlibro,String estado) {		
		return er.buscarEjemplaresPorEstado(idlibro, estado);
	}



	@Override
	public List<EjemplarVO> findByLibro(LibroVO libro) {		
		return er.findByLibro(libro);
	}

	@Override
	public Iterable<EjemplarVO> findAll() {		
		return er.findAll();
	}

	@Override
	public <S extends EjemplarVO> S save(S entity) {		
		return er.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		er.deleteById(id);
	}

	@Override
	public void delete(EjemplarVO entity) {
		er.delete(entity);

	}

	@Override
	public void deleteAll() {
		er.deleteAll();
	}

	@Override
	public List<EjemplarVO> findByPrestamo(PrestamoVO prestamo) {
		
		return er.findByPrestamo(prestamo);
	}

	@Override
	public List<EjemplarVO> findByPrestamoIsNull() {
		
		return er.findByPrestamoIsNull();
	}

	@Override
	public List<EjemplarVO> buscarEjemplaresSinPrestar() {
		
		return er.buscarEjemplaresSinPrestar();
	}

	@Override
	public List<EjemplarVO> buscarEjemplaresSinPrestarDeUnLibro(Long idlibro) {
	
		return er.buscarEjemplaresSinPrestarDeUnLibro(idlibro);
	}

	
	
}
