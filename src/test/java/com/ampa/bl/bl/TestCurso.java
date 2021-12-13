package com.ampa.bl.bl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ampa.bl.bl.entidad.CursoVO;
import com.ampa.bl.bl.servicio.CursoServicio;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestCurso {
	
	@Autowired
	CursoServicio cs;
	
	
	@Test
	@Order(1)
	public void crearCurso() {
		CursoVO c = new CursoVO(0,"1º ESO");		
		cs.save(c);
		assertEquals("1º ESO",cs.findByIdcurso(c.getIdcurso()));
	}
	
	@Test
	@Order(2)
	public void modificarCurso() {
		CursoVO c1 = new CursoVO(0,"2º ESO");
		CursoVO c2 = new CursoVO(0,"3º ESO");	
		CursoVO c3 = new CursoVO(0,"14º ESO");	
		
		cs.save(c1);
		cs.save(c2);
		cs.save(c3);
		
		CursoVO cc = cs.findByIdcurso((long) 4);
		cc.setNombrecurso("4º ESO");
		cs.save(cc);		
		assertEquals("4º ESO",cs.findByIdcurso(cc.getIdcurso()).getNombrecurso());
	}
	@Test
	@Order(4)
	public void borrarCurso() {		
		cs.delete(cs.findByIdcurso((long) 4));		
		assertNull(cs.findByIdcurso((long) 4));
	}
	
}
