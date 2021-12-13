package com.ampa.bl.bl.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data

@Entity
@Table(name="asignaturas")
public class AsignaturaVO implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idasignatura;
	private String nombreasignatura;
	@ManyToOne	
	@JoinColumn(name = "idcurso")
	private CursoVO curso;
	@OneToOne
	@JoinColumn(name = "idlibro")
	private LibroVO libro;
	
	
	public AsignaturaVO(String nombreasignatura, CursoVO curso, LibroVO libro) {
		super();
		this.nombreasignatura = nombreasignatura;
		this.curso = curso;
		this.libro = libro;
	}


	public AsignaturaVO() {
		super();
	
	}
	
	
	

}
