package com.ampa.bl.bl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ampa.bl.bl.servicio.AlumnoServicio;
import com.ampa.bl.bl.servicio.EjemplarServicio;
import com.ampa.bl.bl.servicio.PrestamoServicio;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestPrestamo {
	
	@Autowired
	AlumnoServicio as;
	@Autowired
	EjemplarServicio es;
	@Autowired
	PrestamoServicio ps;
	
	/*
	@Test
	@Order(1)
	public void crearPrestamo() {
		AlumnoVO a = as.findByIdalumno((long) 1);
		EjemplarVO e = es.findByIdejemplar((long) 1);
		PrestamoVO p = new PrestamoVO (a,e);
		
		e.setEstado(EstadoEjemplar.PRESTADO);
		es.save(e);	
				
		ps.save(p);
		assertEquals(EstadoEjemplar.PRESTADO,es.findByIdejemplar((long) 1).getEstado());
	}
	
	@Test
	@Order(2)
	public void modificarPrestamo() {
		
		PrestamoVO p = ps.findByIdprestamo((long) 1);				
		ps.save(p);		
		System.out.println(p.toString());
		assertEquals("Ana",ps.findByIdprestamo((long) 1).getAlumno().getNombre());
	}
	@Test
	@Order(3)
	public void borrarPrestamo() {		
		
		ps.delete(ps.findByIdprestamo((long) 1));	
		assertNull(ps.findByIdprestamo((long) 1));
	}
	*/
}
