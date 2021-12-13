package com.ampa.bl.bl.dto;

import java.io.Serializable;

public class CursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idcurso;
	private String nombrecurso;
	
	
	public CursoDTO(Long idcurso, String nombrecurso) {
		super();
		this.idcurso = idcurso;
		this.nombrecurso = nombrecurso;
	}

	public Long getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Long idcurso) {
		this.idcurso = idcurso;
	}

	public String getNombrecurso() {
		return nombrecurso;
	}

	public void setNombreCurso(String nombrecurso) {
		this.nombrecurso = nombrecurso;
	}
	
	
}
