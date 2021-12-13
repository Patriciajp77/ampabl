package com.ampa.bl.bl.dto;

import java.io.Serializable;

import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.entidad.EstadoEjemplar;

public class LibroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idlibro;
	private String titulo;
	
	private AsignaturaVO asignatura;
	private int numejemplares;
	private EstadoEjemplar estado;
	public LibroDTO(Long idlibro, String titulo, AsignaturaVO asignatura, int numejemplares, EstadoEjemplar estado) {
		super();
		this.idlibro = idlibro;
		this.titulo = titulo;
		this.asignatura = asignatura;
		this.numejemplares = numejemplares;
		this.estado = estado;
	}
	public Long getIdlibro() {
		return idlibro;
	}
	public void setIdlibro(Long idlibro) {
		this.idlibro = idlibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public AsignaturaVO getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(AsignaturaVO asignatura) {
		this.asignatura = asignatura;
	}
	public int getNumejemplares() {
		return numejemplares;
	}
	public void setNumejemplares(int numejemplares) {
		this.numejemplares = numejemplares;
	}
	public EstadoEjemplar getEstado() {
		return estado;
	}
	public void setEstado(EstadoEjemplar estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
