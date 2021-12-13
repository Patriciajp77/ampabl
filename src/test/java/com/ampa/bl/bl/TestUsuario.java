package com.ampa.bl.bl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.ampa.bl.bl.entidad.Rol;
import com.ampa.bl.bl.entidad.UsuarioVO;
import com.ampa.bl.bl.repositorio.UsuarioRepositorio;
import com.ampa.bl.bl.servicio.UsuarioServicio;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Sql({ "/schema.sql", "/data.sql" })
class TestUsuario {
	
	@Autowired
	UsuarioServicio us;
	@Autowired
	UsuarioRepositorio ur;
	
	@Test
	@Order(1)
	public void crearUsuarioAdmin() {
		UsuarioVO u = new UsuarioVO("Isa","Colaboradora","admin","123",Rol.ROLE_ADMIN);
		us.save(u);
		assertEquals("ROLE_ADMIN",us.findById(u.getIdusuario()).get().getRol().toString());
	}
	@Test
	@Order(2)
	public void crearUsuarioUser() {
		UsuarioVO u = new UsuarioVO("Chube","Subdirector","user","321",Rol.ROLE_USER);
		us.save(u);		
		assertEquals("Chube",us.findById(u.getIdusuario()).get().getNombre());
	}
	@Test
	@Order(3)
	public void modificarUsuario() {
		UsuarioVO u = new UsuarioVO("Patri","Tesorera","user","user",Rol.ROLE_ADMIN);
		us.save(u);
		UsuarioVO uu = us.findById(u.getIdusuario()).get();
		uu.setUsername("LolaMento");
		us.save(uu);		
		assertEquals("Chube",us.findById(uu.getIdusuario()).get().getNombre());
	}
	@Test
	@Order(4)
	public void borrarUsuario() {
		UsuarioVO u = new UsuarioVO("Roberto","Subdirector","robert","321",Rol.ROLE_USER);	
		us.save(u);
		us.delete(u);		
		assertNull(us.findById((long) 7));
	}
	
}
