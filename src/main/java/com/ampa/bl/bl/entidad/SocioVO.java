package com.ampa.bl.bl.entidad;

import java.io.Serializable;
import java.util.ArrayList;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="socios")

public class SocioVO implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsocio;
	
	private String nombrepadre;
	private String apellido1padre;
	private String apellido2padre;
	@Column (name="dnipadre", unique = true, length=9)
	private String dnipadre;
	private String nombremadre;
	private String apellido1madre;
	private String apellido2madre;
	@Column (name="dnimadre", unique = true, length=9)
	private String dnimadre;
	private String telefono;	
	//Esta Columna se rellenará desde el servicio
	private String nombre;
	//Número de hijos en el centro
	private int numhijos;	
	
	//Año de alta como socio
	private int alta;
	//Estado del pago
	@Enumerated(EnumType.STRING)
	private EstadoSocio  cuota;	
	
	@Enumerated(EnumType.STRING)
	private EstadoSocio estado;
	
	/*Relación con alumnos, si un alumno queda huérfano se borrará automáticamente*/
	@OneToMany(mappedBy = "numsocio", fetch=FetchType.EAGER)
	List<AlumnoVO> hijos = new ArrayList<AlumnoVO>();
	
	public void addalumno(AlumnoVO a) {
		this.hijos.add(a);
	}


	public SocioVO(String nombrepadre, String apellido1padre, String apellido2padre, String dnipadre,
			String nombremadre, String apellido1madre, String apellido2madre, String dnimadre, String telefono,
			 int numhijos, int anioalta, EstadoSocio cuota, EstadoSocio estado) {
		super();
		
		this.nombrepadre = nombrepadre;
		this.apellido1padre = apellido1padre;
		this.apellido2padre = apellido2padre;
		this.dnipadre = dnipadre;
		this.nombremadre = nombremadre;
		this.apellido1madre = apellido1madre;
		this.apellido2madre = apellido2madre;
		this.dnimadre = dnimadre;
		this.telefono = telefono;		
		this.numhijos = numhijos;
		this.alta = anioalta;
		this.cuota = cuota;
		this.estado = estado;
	}

}
