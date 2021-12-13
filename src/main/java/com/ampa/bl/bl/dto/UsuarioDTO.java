package com.ampa.bl.bl.dto;

import java.io.Serializable;

import com.ampa.bl.bl.entidad.Rol;

public class UsuarioDTO implements Serializable{

	
	/*Las Clases DTO se usan como "Repartidores", es decir, 
	 * llevan la información de la vista a otra capa inferior
	 * se pueden construir con atributos de la entidad de la 
	 * que provienen o combinarse con otras.
	 * 
	 * REGLAS:
	 * Sus atributos deben ser serializables.
	 * Son sólo de lectura.
	 * Sólo sirven para pasar información entre el servidor y la bb de datos.
	 * Sólo tienen Getter y Setter.
	 *   
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idusuario;
	private String nombre;	
	private String cargo;	
	private String username;
	private String password;
	private Rol rol;
	
	public UsuarioDTO(Long idusuario, String nombre, String cargo, String username, String password, Rol rol) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.cargo = cargo;
		this.username = username;
		this.password = password;
		this.rol = rol;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	


	


}
