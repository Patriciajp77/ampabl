package com.ampa.bl.bl.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ampa.bl.bl.entidad.UsuarioVO;
import com.ampa.bl.bl.repositorio.UsuarioRepositorio;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	// Crear un UserDetailsService para poder autenticar un usuario identificado por
		// el username de la bbdd

		// Inyecto el repositorio para rescatar al usuario de la base de datos
		@Autowired
		private UsuarioRepositorio ur;

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			// Declaro un objeto de tipo usuario para almacenar el usuario identificado por
			// su username
			UsuarioVO usuario = ur.findByUsername(username).get();

			// Ahora declaro un objeto UserBuilder
			UserBuilder builder = null;

			if (usuario != null) {

				// Si el usuario existe
				builder = User.withUsername(username);
				builder.disabled(false);
				builder.password(usuario.getPassword());

					//builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
					// Por defecto los usuarios van a tener el rol de User
				builder.authorities(new SimpleGrantedAuthority(usuario.getRol().toString()));

			} else {
				// Si el ususrio no existe que lance una excepción con el mensaje
				throw new UsernameNotFoundException("Usuario no encontrado");
			}

			return builder.build();
		}

}
