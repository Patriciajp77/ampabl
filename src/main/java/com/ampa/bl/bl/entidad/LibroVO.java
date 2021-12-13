package com.ampa.bl.bl.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="libros")
public class LibroVO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idlibro;
	@NotNull
	@Column(length = 250)
	private String titulo;
	@Column(name="idasignatura")
	private AsignaturaVO asignatura;
		
	private int numejemplares;
	@Enumerated(EnumType.STRING)
	private EstadoEjemplar estado;
	
	@OneToMany(mappedBy = "libro", fetch=FetchType.EAGER)
	private List<EjemplarVO> copias;
	
	public void addejemplar(EjemplarVO e) {
		this.copias.add(e);
	}

	public LibroVO(String titulo, AsignaturaVO asignatura, int numejemplares, EstadoEjemplar estado) {
		super();
		this.titulo = titulo;
		this.asignatura = asignatura;
		this.numejemplares = numejemplares;
		this.estado = estado;
	}

	public LibroVO(String titulo, int numejemplares, EstadoEjemplar estado) {
		super();
		this.titulo = titulo;
		this.numejemplares = numejemplares;
		this.estado = estado;
	}

	

}
