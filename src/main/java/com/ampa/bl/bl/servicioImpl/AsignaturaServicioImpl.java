package com.ampa.bl.bl.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.repositorio.AsignaturaRepositorio;
import com.ampa.bl.bl.servicio.AsignaturaServicio;
@Service
public class AsignaturaServicioImpl implements AsignaturaServicio {

	@Autowired
	AsignaturaRepositorio asr;
	
	@Override
	public AsignaturaRepositorio getAsr() {		
		return asr;
	}

	@Override
	public void setAsr(AsignaturaRepositorio asr) {
		this.asr = asr;
	}

	@Override
	public AsignaturaVO findByIdasignatura(Long idasignatura) {		
		return asr.findByIdasignatura(idasignatura);
	}

	@Override
	public Iterable<AsignaturaVO> findAll() {
		return asr.findAll();
	}

	@Override
	public <S extends AsignaturaVO> S save(S entity) {		
		return asr.save(entity);	}

	@Override
	public void deleteById(Long id) {
		asr.deleteById(id);
	}

	@Override
	public void delete(AsignaturaVO entity) {
		asr.delete(entity);
	}

	@Override
	public void deleteAll() {
		asr.deleteAll();
	}

	@Override
	public Page<AsignaturaVO> findAllPaginated(Pageable pageable) {
		
		return asr.findAll(pageable);
	}

	@Override
	public List<AsignaturaVO> findByCurso(CursoVO curso) {
		
		return asr.findByCurso(curso);
	}


}
