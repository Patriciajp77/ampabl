package com.ampa.bl.bl.servicio;

import java.util.Optional;

import com.ampa.bl.bl.entidad.UsuarioVO;

public interface UsuarioServicio {

	public UsuarioVO findByUsername(String username);

	public UsuarioVO registrar(UsuarioVO u);

	public Optional<UsuarioVO> findById(Long id);

	Iterable<UsuarioVO> findAll();

	// Guardar
	<S extends UsuarioVO> S save(S entity);
	

	// Borrar
	void deleteById(Long id);

	void delete(UsuarioVO entity);

	void deleteAll();


}