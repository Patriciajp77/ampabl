package com.ampa.bl.bl.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ampa.bl.bl.entidad.UsuarioVO;
@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioVO, Long> {
			//Hacer la búsqueda por el nombre de usuario
			public Optional<UsuarioVO> findByUsername(String username);
}
