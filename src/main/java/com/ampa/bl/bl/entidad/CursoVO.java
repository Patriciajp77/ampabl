package com.ampa.bl.bl.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name="cursos")
public class CursoVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcurso;
	private String nombrecurso;
	
	//Relación con asiganturas:
	@OneToMany(mappedBy="curso",  fetch=FetchType.EAGER)
	//Asignaturas de un curso:
	List<AsignaturaVO> asignaturas = new ArrayList<AsignaturaVO>();	
	//Relación con Alumnos:
	@OneToMany(mappedBy = "curso")
	//Alumnos de un curso:
	List<AlumnoVO> alumnos = new ArrayList<AlumnoVO>();	
	
	
	public void addalumno(AlumnoVO a) {
		this.alumnos.add(a);
	}
	public void addasignatura(AsignaturaVO as) {
		this.asignaturas.add(as);
	}

	
	
	
	public CursoVO(long idcurso, String nombrecurso) {
		super();
		this.idcurso = idcurso;
		this.nombrecurso = nombrecurso;
	}


	public CursoVO(String nombrecurso) {
		super();
		this.nombrecurso = nombrecurso;
	}
	public CursoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
