package com.ampa.bl.bl.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alumnos")
public class AlumnoVO  {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idalumno;
	private String nombre;
	private String apellido1;
	private String apellido2;

	// Relación con cursos:
	@ManyToOne
	@JoinColumn(name = "idcurso")
	private CursoVO curso;

	// Relación con socios;
	@ManyToOne	
	@JoinColumn(name = "idsocio")
	private SocioVO numsocio;
	@OneToOne
	@JoinColumn(name = "idprestamo")
	private PrestamoVO prestamo;
	
	
	public AlumnoVO(String nombre, String apellido1, String apellido2, CursoVO curso, SocioVO numsocio) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.curso = curso;
		this.numsocio = numsocio;
	}
	

	
}
