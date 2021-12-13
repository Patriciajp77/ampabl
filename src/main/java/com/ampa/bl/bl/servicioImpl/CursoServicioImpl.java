package com.ampa.bl.bl.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.repositorio.CursoRepositorio;
import com.ampa.bl.bl.servicio.CursoServicio;
@Service
public class CursoServicioImpl implements CursoServicio {

	@Autowired
	CursoRepositorio cr;
	
	@Override
	public CursoRepositorio getCr() {		
		return cr;
	}

	@Override
	public void setC(CursoRepositorio cr) {
		this.cr = cr;
	}

	@Override
	public CursoVO findByIdcurso(Long idcurso) {		
		return cr.findByIdcurso(idcurso);
	}

	@Override
	public Iterable<CursoVO> findAll() {		
		return cr.findAll();
	}

	@Override
	public <S extends CursoVO> S save(S entity) {		
		return cr.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		cr.deleteById(id);
	}

	@Override
	public void delete(CursoVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}

	@Override
	public Optional<CursoVO> findById(Long idcurso) {
		return cr.findById(idcurso);
	}

	@Override
	public CursoVO findByNombrecurso(String nombrecurso) {
		return cr.findByNombrecurso(nombrecurso);
	}	

}
