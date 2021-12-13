package com.ampa.bl.bl.entidad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")

public class UsuarioVO implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	private String nombre;
	private String cargo;

	// Para usar Spring Security
	private String username;
	private String password;

	
	// Un usuario tiene un rol
		@Enumerated(EnumType.STRING)
		private Rol rol;
		
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles= new ArrayList<>();	
		roles.add(new SimpleGrantedAuthority(rol.toString()));
		return roles;	
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public UsuarioVO(String nombre, String cargo, String username, String password, Rol rol) {
		super();
		this.nombre = nombre;
		this.cargo = cargo;
		this.username = username;
		this.password = password;
		this.rol = rol;
	}


	

	
}
