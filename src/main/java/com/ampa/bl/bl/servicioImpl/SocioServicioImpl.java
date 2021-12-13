package com.ampa.bl.bl.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.SocioVO;
import com.ampa.bl.bl.repositorio.SocioRepositorio;
import com.ampa.bl.bl.servicio.AlumnoServicio;
import com.ampa.bl.bl.servicio.SocioServicio;
@Service
public class SocioServicioImpl implements SocioServicio {

	
	@Autowired
	SocioRepositorio sr;
	@Autowired
	AlumnoServicio as;
	
	@Override
	public SocioRepositorio getSr() {		
		return sr;
	}

	@Override
	public void setSr(SocioRepositorio sr) {
		this.sr = sr;
	}

	@Override
	public SocioVO findByIdsocio(Long idsocio) {
		return sr.findByIdsocio(idsocio);
	}

	@Override
	public SocioVO buscarSocioPorDni(String dni) {		
		return sr.buscarSocioPorDni(dni);
	}

	@Override
	public SocioVO findByTelefono(String telefono) {		
		return sr.findByTelefono(telefono);
	}

	@Override
	public List<SocioVO> buscarNuevosSocios(int anio) {		
		return sr.buscarNuevosSocios(anio);
	}

	@Override
	public List<SocioVO> buscarPagadoOk() {		
		return sr.buscarPagadoOk();
	}

	@Override
	public List<SocioVO> buscarPagadoNo() {		
		return sr.buscarPagadoNo();
	}

	

	@Override
	public List<SocioVO> buscarTodosAlta(int anio) {
		
		return sr.buscarTodosAlta(anio);
	}

	@Override
	public Iterable<SocioVO> findAll() {		
		return sr.findAll();
	}

	@Override
	public <S extends SocioVO> S save(S entity) {
		entity.setNombre(entity.getApellido1padre()+" - "+entity.getApellido1madre());
		return sr.save(entity);
	}

	@Override
	public void deleteById(Long id) {		
			sr.deleteById(id);			
	}

	@Override
	public void delete(SocioVO entity) {
		sr.delete(entity);
	}

	@Override
	public void deleteAll() {
		sr.deleteAll();
	}
			
	public void crearMisHijos(SocioVO s) {
		
		for (int i = 0; i < s.getNumhijos(); i++) {
			
			AlumnoVO a = new AlumnoVO("",s.getApellido2padre(),s.getApellido1madre(),null,s);
			as.save(a);			
		}
		
	}

	@Override
	public Page<SocioVO> findAllPaginated(Pageable pageable) {		
		return sr.findAll(pageable);
	}
	
	
}
