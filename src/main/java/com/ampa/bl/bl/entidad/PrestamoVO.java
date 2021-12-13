package com.ampa.bl.bl.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prestamos")

public class PrestamoVO implements Serializable{
	
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprestamo;
	
	private LocalDate fecha  = LocalDate.now();
	
	@OneToOne
	@JoinColumn(name = "idalumno")
	private AlumnoVO alumno;
	
	@OneToMany(mappedBy = "idejemplar")
	private List<EjemplarVO> mislibros;

	public void addejemplar(EjemplarVO e) {
		this.mislibros.add(e);
	}
	
	public PrestamoVO(LocalDate fecha, AlumnoVO alumno, List<EjemplarVO> mislibros) {
		super();
		this.fecha = fecha;
		this.alumno = alumno;
		this.mislibros = mislibros;
	}

	public PrestamoVO(Long idprestamo, LocalDate fecha, AlumnoVO alumno) {
		super();
		this.idprestamo = idprestamo;
		this.fecha = fecha;
		this.alumno = alumno;
	}

	

}
