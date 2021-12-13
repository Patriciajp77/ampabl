package com.ampa.bl.bl.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ampa.bl.bl.entidad.SocioVO;
import com.ampa.bl.bl.repositorio.SocioRepositorio;

public interface SocioServicio {
	
	SocioRepositorio getSr();

	void setSr(SocioRepositorio sr);
	
	//Buscar
	SocioVO findByIdsocio(Long idsocio);
	SocioVO buscarSocioPorDni(String dni);
	SocioVO findByTelefono (String telefono);
	List<SocioVO> buscarNuevosSocios(int anio);
	List<SocioVO> buscarPagadoOk();
	List<SocioVO> buscarPagadoNo();
	List<SocioVO> buscarTodosAlta(int anio);
	Iterable<SocioVO> findAll();	
	public Page<SocioVO> findAllPaginated(Pageable pageable);
	
	//Guardar
	<S extends SocioVO> S save(S entity);
	
	//Borrar
	void deleteById(Long id);
	void delete(SocioVO entity);
	void deleteAll();


}
