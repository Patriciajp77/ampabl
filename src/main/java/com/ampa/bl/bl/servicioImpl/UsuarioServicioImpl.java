package com.ampa.bl.bl.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ampa.bl.bl.entidad.UsuarioVO;
import com.ampa.bl.bl.repositorio.UsuarioRepositorio;
import com.ampa.bl.bl.servicio.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements  UsuarioServicio {

	//Inyecto el repositorio (Capa de acceso a datos)
		@Autowired
		private UsuarioRepositorio ur;
		
		
		//Inyecto passwordencode para que me encripte la contraseña del usuario
		@Autowired
		private BCryptPasswordEncoder encriptado;


		@Override
		public UsuarioVO findByUsername(String username) {
			
			return ur.findByUsername(username).get();
		}


		@Override
		public UsuarioVO registrar(UsuarioVO u) {
			
			u.setPassword(encriptado.encode(u.getPassword()));
			//Guardo el usuario en la bbdd con la contraseña encriptada
			return ur.save(u);
		}


		@Override
		public Optional<UsuarioVO> findById(Long id) {
			
			return ur.findById(id);
		}


		@Override
		public Iterable<UsuarioVO> findAll() {
		
			return ur.findAll();
		}


		@Override
		public <S extends UsuarioVO> S save(S entity) {
			
			return ur.save(entity);
		}


		@Override
		public void deleteById(Long id) {
			ur.deleteById(id);
			
		}


		@Override
		public void delete(UsuarioVO entity) {
			ur.delete(entity);
			
		}


		@Override
		public void deleteAll() {
			ur.deleteAll();
			
		}


		

}
