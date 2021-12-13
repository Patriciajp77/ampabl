package com.ampa.bl.bl.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ejemplares")
public class EjemplarVO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idejemplar;
	
	@ManyToOne
	@JoinColumn(name="idlibro")
	private LibroVO libro;

	@Enumerated(EnumType.STRING)
	private EstadoEjemplar estado;	
	//Para la solicitud
	@ManyToOne	
	@JoinColumn(name = "idalumno")
	private AlumnoVO alumno;
	@ManyToOne	
	@JoinColumn(name = "idprestamo")
	private PrestamoVO prestamo;

	public EjemplarVO(LibroVO libro, EstadoEjemplar estado) {
		super();
		this.libro = libro;
		this.estado = estado;
		
	}
	
	

}
