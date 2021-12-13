package com.ampa.bl.bl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ampa.bl.bl.entidad.AlumnoVO;
import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.entidad.SocioVO;
import com.ampa.bl.bl.servicio.AlumnoServicio;
import com.ampa.bl.bl.servicio.CursoServicio;
import com.ampa.bl.bl.servicio.SocioServicio;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestAlumnos {
	
	@Autowired
	SocioServicio ss;	
	@Autowired
	CursoServicio cs;
	@Autowired
	AlumnoServicio as;
	
	
	
	@Test
	@Order(1)
	public void crearAlumno() {	
	
		
		SocioVO s = ss.findByIdsocio((long) 2);//Busco al socio
		CursoVO c = cs.findByIdcurso((long) 2);//Busco el curso
		
		AlumnoVO a = new AlumnoVO("Nicolás",s.getApellido2padre(),s.getApellido1madre(),c,s);//Creo el alumno
		as.save(a);//Guardo alumno
		
		List<AlumnoVO> paraAdjuntar = as.findHijos(s);//Almaceno en una lista a los hijos de un socio llamando al método del repositorio.
		for (AlumnoVO alumnoVO : paraAdjuntar) {
			s.setHijos(paraAdjuntar);//Añado al hijos del socio
			System.out.println(alumnoVO.getNombre()+","+alumnoVO.getCurso().getNombrecurso());
		}		
		
		System.out.println("*******************************************************************************");
		System.out.println("El socio "+s.getNombre()+" tiene " +s.getHijos().size()+" hijos.");
		System.out.println("*******************************************************************************");	
		
		assertEquals(2,as.findByIdalumno((long) 6).getCurso().getIdcurso());
	}
	/*
	@Test
	@Order(2)
	public void modificarAlumno() {
		AlumnoVO a = as.findByNombre("Ana");
		a.setApellido1(ss.findByIdsocio(a.getNumsocio().getIdsocio()).getApellido1padre());
		a.setApellido2(ss.findByIdsocio(a.getNumsocio().getIdsocio()).getApellido1madre());
		as.save(a);				
		assertEquals(as.findByNombre("Daniel").getApellido1(),ss.findByIdsocio(a.getNumsocio().getIdsocio()).getApellido1padre());
	}
	
	@Test
	@Order(3)
	public void borrarAlumno() {
		//Quiero borrar los hijos que vayan a 1º BACH - Ciencias, de un socio concreto
		
		SocioVO s = ss.findByIdsocio((long) 8);//Busco al socio
		List<AlumnoVO> paraBorrar = as.findHijos(s);
		
		for (AlumnoVO alumnoVO : paraBorrar) {
			if(alumnoVO.getCurso().getIdcurso()== 5) {
				System.out.println("Borrando hijo: ");
				System.out.println(alumnoVO.getNombre()+","+alumnoVO.getCurso().getNombrecurso());				
				as.delete(alumnoVO);//Borro al alumno de la bbdd	
			}				
		}
		
		assertEquals(0, as.findHijos(s).size());
		
	}
	*/
}
