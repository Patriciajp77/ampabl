package com.ampa.bl.bl.dto;

import java.io.Serializable;

import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.entidad.SocioVO;



public class AlumnoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idalumno;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private SocioVO socio;
	private CursoVO curso;	
	
	public AlumnoDTO(Long idalumno, String nombre, String apellido1, String apellido2, SocioVO socio, CursoVO curso) {
		super();
		this.idalumno = idalumno;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.socio = socio;
		this.curso = curso;
	}
	
	public Long getIdalumno() {
		return idalumno;
	}
	public void setIdalumno(Long idalumno) {
		this.idalumno = idalumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public SocioVO getSocio() {
		return socio;
	}
	public void setSocio(SocioVO socio) {
		this.socio = socio;
	}
	public CursoVO getCurso() {
		return curso;
	}
	public void setCurso(CursoVO curso) {
		this.curso = curso;
	}
	
	
	

}
