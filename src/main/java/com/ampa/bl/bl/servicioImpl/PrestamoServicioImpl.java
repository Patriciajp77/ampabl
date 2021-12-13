package com.ampa.bl.bl.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.PrestamoVO;
import com.ampa.bl.bl.repositorio.PrestamoRepositorio;
import com.ampa.bl.bl.servicio.EjemplarServicio;
import com.ampa.bl.bl.servicio.PrestamoServicio;
@Service
public class PrestamoServicioImpl implements PrestamoServicio {

	@Autowired
	PrestamoRepositorio pr;
	@Autowired
	EjemplarServicio es;

	@Override
	public PrestamoRepositorio getPr() {		
		return pr;
	}

	@Override
	public void setPr(PrestamoRepositorio pr) {
		this.pr = pr;		
	}

	@Override
	public PrestamoVO findByIdprestamo(Long idprestamo) {		
		return pr.findByIdprestamo(idprestamo);
	}

	@Override
	public List<PrestamoVO> findByAlumno(AlumnoVO alumno) {		
		return pr.findByAlumno(alumno);
	}

	
	@Override
	public Iterable<PrestamoVO> findAll() {		
		return pr.findAll();
	}

	@Override
	public <S extends PrestamoVO> S save(S entity) {		
		return pr.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		pr.deleteById(id);		
	}

	@Override
	public void delete(PrestamoVO entity) {
		pr.delete(entity);		
	}

	@Override
	public void deleteAll() {
		pr.deleteAll();		
	}
	//Insertar un Alumno a un préstamo
	public PrestamoVO insertar(PrestamoVO p, AlumnoVO a) {
		p.setAlumno(a);
		return pr.save(p);
	}

	@Override
	public PrestamoVO insertar(PrestamoVO p, EjemplarVO e) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
