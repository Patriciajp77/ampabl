package com.ampa.bl.bl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ampa.bl.bl.entidad.EjemplarVO;
import com.ampa.bl.bl.entidad.LibroVO;
import com.ampa.bl.bl.servicio.EjemplarServicio;
import com.ampa.bl.bl.servicio.LibroServicio;
import com.ampa.bl.bl.servicio.SocioServicio;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestEjemplar {
	@Autowired
	SocioServicio ss;
	@Autowired
	LibroServicio ls;
	@Autowired
	EjemplarServicio es;
	
	
	/*
	@Test
	@Order(1)
	public void crearEjemplar() {
		LibroVO l = new LibroVO("La gran Mamá hace el mundo",cas.findByIdca((long) 7),12,false);		
		ls.save(l);			
		List<EjemplarVO> copias = new ArrayList<EjemplarVO>();
		l.setCopias(copias);
		for (int i = 0; i < l.getNumejemplares(); i++) {
			EjemplarVO e= new EjemplarVO(l,EstadoEjemplar.SIN_PRESTAR);			
			es.save(e);			
			System.out.println("Creado ejemplar id  "+e.getIdejemplar());			
			l.getCopias().add(e);
			ls.save(l);
			System.out.println("Creado copia  "+l.getCopias().size()+" del libro "+l.getTitulo()+" de "+l.getCa().getCurso().getNombrecurso()+" "+e.getLibro().getCa().getAsignatura().getNombreasignatura());
			
		} 
		System.out.println("****************************************");
		
		assertEquals(12,l.getCopias().size());
	}
	*/
	@Test
	@Order(2)
	public void modificarEjemplar() {
		EjemplarVO e= es.findByIdejemplar((long) 1);
		//e.setDonante(ss.findByIdsocio((long) 1));	
		es.save(e);	
		//System.out.println("El ejemplar  "+e.getIdejemplar()+" fue donado por el socio "+e.getDonante().getNombre());
		//assertEquals("Jerez",e.getDonante().getApellido1madre());
		System.out.println("****************************************");
	}
	
	@Test
	@Order(4)
	public void borrarEjemplar() {
		LibroVO l = ls.findByIdlibro((long) 86);
		
		EjemplarVO e= es.findByIdejemplar((long) 12);
		l.setNumejemplares(l.getNumejemplares()-1);				
		ls.save(l);
		System.out.println("Ahora los ejemplares de este libro son "+l.getNumejemplares());
		es.delete(e);
		System.out.println("Ejemplar borrado");	
			
		assertEquals(11, ls.findByIdlibro((long) 86).getNumejemplares());
	}
	
}
