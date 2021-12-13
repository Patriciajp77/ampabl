package com.ampa.bl.bl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ampa.bl.bl.servicio.AsignaturaServicio;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestAsignaturas {
	
	@Autowired
	AsignaturaServicio as;
	/*
	
	@Test
	@Order(1)
	public void crearAsignatura() {
		AsignaturaVO a = new AsignaturaVO("Volumennnnnnnn");		
		as.save(a);
		System.out.println("Asignatura creada y persistida.");
		System.out.println("*********************************************************");
		assertEquals("Volumennnnnnnn",as.findByIdasignatura((long) 37).getNombreasignatura());
	}
	
	@Test
	@Order(2)
	public void modificarAsignatura() {
		AsignaturaVO a = as.findByIdasignatura((long) 37);
		a.setNombreasignatura("Volumen");
		as.save(a);
		System.out.println("Asignatura modificada y persistida.");
		System.out.println("*********************************************************");
		assertEquals("Volumen",as.findByIdasignatura((long) 37).getNombreasignatura());
	}
	@Test
	@Order(4)
	public void borrarCurso() {		
		as.delete(as.findByIdasignatura((long) 37));
		System.out.println("Asignatura eliminada de la bbdd.");
		System.out.println("*********************************************************");
		assertNull(as.findByIdasignatura((long) 37));
	}
	*/
}
