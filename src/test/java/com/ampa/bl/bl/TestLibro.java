package com.ampa.bl.bl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.EstadoEjemplar;
import com.ampa.bl.bl.entidad.LibroVO;
import com.ampa.bl.bl.servicio.AsignaturaServicio;
import com.ampa.bl.bl.servicio.EjemplarServicio;
import com.ampa.bl.bl.servicio.LibroServicio;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestLibro {
	
	
	@Autowired
	LibroServicio ls;
	@Autowired
	EjemplarServicio es;
	@Autowired
	AsignaturaServicio as;
	
	
	@Test
	@Order(1)
	public void crearLibro() {
		LibroVO l = new LibroVO("Pulse 1",as.findByIdasignatura((long) 2),10,EstadoEjemplar.EN_USO);
		ls.save(l);
		
		for (int i = 0; i < l.getNumejemplares(); i++) {			
			EjemplarVO e = new EjemplarVO(l,EstadoEjemplar.SIN_PRESTAR);
			es.save(e);
		}		
	
		assertEquals("Pulse 1",ls.findByIdlibro(l.getIdlibro()).getTitulo());
	}
	
	
	/*
	@Test
	@Order(3)
	public void modificarLibro() {
		LibroVO l = ls.findByIdlibro((long) 76);
		l.setDescatalogado(false);
		ls.save(l);		
		assertFalse(ls.findByIdlibro((long) 76).isDescatalogado());
	}
	
	@Test
	@Order(4)
	public void borrarLibro() {		
		LibroVO l = ls.findByIdlibro((long) 77);
		ls.delete(l);
		assertNull(ls.findByIdlibro((long) 77));
		
	}
	/*@Test
	@Order(1)
	public void crearLibro() {
		LibroVO l = new LibroVO("La abuela ganster",cas.findByIdca((long) 21),15,false);
		ls.save(l);
		
		for (int i = 0; i < l.getNumejemplares(); i++) {			
			EjemplarVO e = new EjemplarVO(l,EstadoEjemplar.SIN_PRESTAR);
			es.save(e);
		}		
	
		assertEquals("La abuela ganster",ls.findByIdlibro(l.getIdlibro()).getTitulo());
	}
	*/
	/*
	@Test
	@Order(3)
	public void modificarLibro() {
		LibroVO l = ls.findByIdlibro((long) 76);
		l.setDescatalogado(false);
		ls.save(l);		
		assertFalse(ls.findByIdlibro((long) 76).isDescatalogado());
	}
	
	@Test
	@Order(4)
	public void borrarLibro() {		
		LibroVO l = ls.findByIdlibro((long) 77);
		ls.delete(l);
		assertNull(ls.findByIdlibro((long) 77));
		
	}
	*/
}
