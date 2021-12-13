package com.ampa.bl.bl.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ampa.bl.bl.entidad.SocioVO;
@Repository
public interface SocioRepositorio extends JpaRepository<SocioVO, Long> {
	
	SocioVO findByIdsocio(Long idsocio);

	SocioVO findByTelefono(String telefono);

	// Buscar Socios por DNI
	@Query(value = "select s from SocioVO s where dnipadre =?1 or dnimadre=?1")
	SocioVO buscarSocioPorDni(String dni);

	// Buscar los socios que se dieron de alta este año:
	@Query(value = "select s from SocioVO s where anioalta = ?1")
	List<SocioVO> buscarNuevosSocios(int anio);
	
	
	//Buscar socios de alta con cuota pagada:
	@Query(value = "select s from SocioVO s where estado = 'ALTA' and cuota = 'PAGADA'")
	List<SocioVO> buscarPagadoOk();

	// Buscar socios de alta pero que no tengan hecho el pago:
	@Query(value = "select s from SocioVO s where estado = 'ALTA' and cuota = 'PENDIENTE'")
	List<SocioVO> buscarPagadoNo();
	
	//Buscar todos los socios que estén de alta:
	
	@Query(value = "select s from SocioVO s where estado = 'ALTA' and alta>=?1")
	List<SocioVO> buscarTodosAlta(int anio);
	

}
