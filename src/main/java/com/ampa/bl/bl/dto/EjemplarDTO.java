package com.ampa.bl.bl.dto;

import java.io.Serializable;

import com.ampa.bl.bl.entidad.EstadoEjemplar;

public class EjemplarDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long idejemplar;
	private LibroDTO idlibro;
	private AsignaturaDTO idasignatura;
	private CursoDTO idcurso;
	private EstadoEjemplar estado;
	public EjemplarDTO() {
		super();
		
	}
	public EjemplarDTO(long idejemplar, LibroDTO idlibro, AsignaturaDTO idasignatura, CursoDTO idcurso,
			EstadoEjemplar estado) {
		super();
		this.idejemplar = idejemplar;
		this.idlibro = idlibro;
		this.idasignatura = idasignatura;
		this.idcurso = idcurso;
		this.estado = estado;
	}
	public EjemplarDTO(LibroDTO idlibro, AsignaturaDTO idasignatura, CursoDTO idcurso, EstadoEjemplar estado) {
		super();
		this.idlibro = idlibro;
		this.idasignatura = idasignatura;
		this.idcurso = idcurso;
		this.estado = estado;
	}
	public long getIdejemplar() {
		return idejemplar;
	}
	public void setIdejemplar(long idejemplar) {
		this.idejemplar = idejemplar;
	}
	public LibroDTO getIdlibro() {
		return idlibro;
	}
	public void setIdlibro(LibroDTO idlibro) {
		this.idlibro = idlibro;
	}
	public AsignaturaDTO getIdasignatura() {
		return idasignatura;
	}
	public void setIdasignatura(AsignaturaDTO idasignatura) {
		this.idasignatura = idasignatura;
	}
	public CursoDTO getIdcurso() {
		return idcurso;
	}
	public void setIdcurso(CursoDTO idcurso) {
		this.idcurso = idcurso;
	}
	public EstadoEjemplar getEstado() {
		return estado;
	}
	public void setEstado(EstadoEjemplar estado) {
		this.estado = estado;
	}
	
	

}
