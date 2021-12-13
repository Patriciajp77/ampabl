package com.ampa.bl.bl.dto;

import java.io.Serializable;

import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.entidad.LibroVO;

public class AsignaturaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idasignatura;
	private String nombreasignatura;
	private CursoVO curso;
	private LibroVO libro;
	public AsignaturaDTO(Long idasignatura, String nombreasignatura, CursoVO curso, LibroVO libro) {
		super();
		this.idasignatura = idasignatura;
		this.nombreasignatura = nombreasignatura;
		this.curso = curso;
		this.libro = libro;
	}
	public Long getIdasignatura() {
		return idasignatura;
	}
	public void setIdasignatura(Long idasignatura) {
		this.idasignatura = idasignatura;
	}
	public String getNombreasignatura() {
		return nombreasignatura;
	}
	public void setNombreasignatura(String nombreasignatura) {
		this.nombreasignatura = nombreasignatura;
	}
	public CursoVO getCurso() {
		return curso;
	}
	public void setCurso(CursoVO curso) {
		this.curso = curso;
	}
	public LibroVO getLibro() {
		return libro;
	}
	public void setLibro(LibroVO libro) {
		this.libro = libro;
	}
	

}
