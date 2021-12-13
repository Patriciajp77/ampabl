package com.ampa.bl.bl.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.AsignaturaVO;
import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.LibroVO;
import com.ampa.bl.bl.entidad.SocioVO;

public class PrestamoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idprestamo;
	private LocalDate fecha;
	private SocioVO socio;
	private AlumnoVO alumno;
	private CursoVO curso;
	private AsignaturaVO asignatura;
	private LibroVO libro;
	private List<EjemplarVO> ejemplares;
	public PrestamoDTO(Long idprestamo, LocalDate fecha, SocioVO socio, AlumnoVO alumno, CursoVO curso,
			AsignaturaVO asignatura, LibroVO libro) {
		super();
		this.idprestamo = idprestamo;
		this.fecha = fecha;
		this.socio = socio;
		this.alumno = alumno;
		this.curso = curso;
		this.asignatura = asignatura;
		this.libro = libro;
		
	}
	
	
	public PrestamoDTO(Long idprestamo, LocalDate fecha, AlumnoVO alumno) {
		super();
		this.idprestamo = idprestamo;
		this.fecha = fecha;
		
		this.alumno = alumno;
	}


	public Long getIdprestamo() {
		return idprestamo;
	}
	public void setIdprestamo(Long idprestamo) {
		this.idprestamo = idprestamo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public SocioVO getSocio() {
		return socio;
	}
	public void setSocio(SocioVO socio) {
		this.socio = socio;
	}
	public AlumnoVO getAlumno() {
		return alumno;
	}
	public void setAlumno(AlumnoVO alumno) {
		this.alumno = alumno;
	}
	public CursoVO getCurso() {
		return curso;
	}
	public void setCurso(CursoVO curso) {
		this.curso = curso;
	}
	public AsignaturaVO getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(AsignaturaVO asignatura) {
		this.asignatura = asignatura;
	}
	public LibroVO getLibro() {
		return libro;
	}
	public void setLibro(LibroVO libro) {
		this.libro = libro;
	}
	public List<EjemplarVO> getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(List<EjemplarVO> ejemplares) {
		this.ejemplares = ejemplares;
	}

	
	
}
