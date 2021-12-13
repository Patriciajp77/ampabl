package com.ampa.bl.bl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ampa.bl.bl.entidad.EstadoSocio;
import com.ampa.bl.bl.entidad.SocioVO;
import com.ampa.bl.bl.servicio.SocioServicio;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestSocios {
	
	@Autowired
	SocioServicio ss;
	
	
	@Test
	@Order(1)
	public void crearSocio() {
		SocioVO s = new SocioVO("Alejandro","Diez","García","09375254V","Purificación","Mariño","Iglesias","09369096T","619572047",1,2017, EstadoSocio.PAGADA,EstadoSocio.ALTA);		
		s.setNombre(s.getApellido1padre()+" - "+s.getApellido1madre());
		ss.save(s);		
		assertEquals("619572047",ss.findByTelefono(s.getTelefono()).getTelefono());
	}
	
	@Test
	@Order(2)
	public void modificarSocio() {
		SocioVO s = ss.findByTelefono("619572047");			
		s.setApellido1padre("Díez");
		ss.save(s);
		assertEquals("Díez",ss.buscarSocioPorDni("09375254V").getApellido1padre());
	}
	@Test
	@Order(4)
	public void borrarSocio() {		
		SocioVO s = ss.findByIdsocio((long) 6);
		ss.delete(s);			
		assertNull(ss.findByIdsocio((long) 6));
		System.out.println("Este test debe dar una excepción de seguridad.");
	}
	
}
