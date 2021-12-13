package com.ampa.bl.bl.dto;

import java.io.Serializable;

import com.ampa.bl.bl.entidad.EstadoSocio;

public class SocioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idsocio;
	
	private String nombrepadre;
	private String apellido1padre;
	private String apellido2padre;	
	private String dnipadre;
	
	private String nombremadre;
	private String apellido1madre;
	private String apellido2madre;	
	private String dnimadre;
	
	private String telefono;	
	
	private String nombre;

	private int numhijos;	
	
	private int alta;
	
	private EstadoSocio cuota;	
	
	private EstadoSocio estado;
	
	

	public SocioDTO(Long idsocio, String nombrepadre, String apellido1padre, String apellido2padre, String dnipadre,
			String nombremadre, String apellido1madre, String apellido2madre, String dnimadre, String telefono,
			String nombre, int numhijos, int alta, EstadoSocio cuota, EstadoSocio estado) {
		super();
		this.idsocio = idsocio;
		this.nombrepadre = nombrepadre;
		this.apellido1padre = apellido1padre;
		this.apellido2padre = apellido2padre;
		this.dnipadre = dnipadre;
		this.nombremadre = nombremadre;
		this.apellido1madre = apellido1madre;
		this.apellido2madre = apellido2madre;
		this.dnimadre = dnimadre;
		this.telefono = telefono;
		this.nombre = nombre;
		this.numhijos = numhijos;
		this.alta = alta;
		this.cuota = cuota;
		this.estado = estado;
	}

	public SocioDTO(String nombrepadre, String apellido1padre, String apellido2padre, String dnipadre,
			String nombremadre, String apellido1madre, String apellido2madre, String dnimadre, String telefono,
			String nombre, int numhijos, int alta, EstadoSocio cuota, EstadoSocio estado) {
		super();
		this.nombrepadre = nombrepadre;
		this.apellido1padre = apellido1padre;
		this.apellido2padre = apellido2padre;
		this.dnipadre = dnipadre;
		this.nombremadre = nombremadre;
		this.apellido1madre = apellido1madre;
		this.apellido2madre = apellido2madre;
		this.dnimadre = dnimadre;
		this.telefono = telefono;
		this.nombre = nombre;
		this.numhijos = numhijos;
		this.alta = alta;
		this.cuota = cuota;
		this.estado = estado;
	}

	public Long getIdsocio() {
		return idsocio;
	}

	public void setIdsocio(Long idsocio) {
		this.idsocio = idsocio;
	}

	public String getNombrepadre() {
		return nombrepadre;
	}

	public void setNombrepadre(String nombrepadre) {
		this.nombrepadre = nombrepadre;
	}

	public String getApellido1padre() {
		return apellido1padre;
	}

	public void setApellido1padre(String apellido1padre) {
		this.apellido1padre = apellido1padre;
	}

	public String getApellido2padre() {
		return apellido2padre;
	}

	public void setApellido2padre(String apellido2padre) {
		this.apellido2padre = apellido2padre;
	}

	public String getDnipadre() {
		return dnipadre;
	}

	public void setDnipadre(String dnipadre) {
		this.dnipadre = dnipadre;
	}

	public String getNombremadre() {
		return nombremadre;
	}

	public void setNombremadre(String nombremadre) {
		this.nombremadre = nombremadre;
	}

	public String getApellido1madre() {
		return apellido1madre;
	}

	public void setApellido1madre(String apellido1madre) {
		this.apellido1madre = apellido1madre;
	}

	public String getApellido2madre() {
		return apellido2madre;
	}

	public void setApellido2madre(String apellido2madre) {
		this.apellido2madre = apellido2madre;
	}

	public String getDnimadre() {
		return dnimadre;
	}

	public void setDnimadre(String dnimadre) {
		this.dnimadre = dnimadre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumhijos() {
		return numhijos;
	}

	public void setNumhijos(int numhijos) {
		this.numhijos = numhijos;
	}

	public int getAlta() {
		return alta;
	}

	public void setAlta(int alta) {
		this.alta = alta;
	}

	public EstadoSocio getCuota() {
		return cuota;
	}

	public void setCuota(EstadoSocio cuota) {
		this.cuota = cuota;
	}

	public EstadoSocio getEstado() {
		return estado;
	}

	public void setEstado(EstadoSocio estado) {
		this.estado = estado;
	}
	

}
