package com.tiendaPatito.caomioneta.OrdenCamioneta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Camioneta;

@Repository
public interface CamionetaRepository extends JpaRepository<Camioneta, Long> {
	
    @Query(value = "SELECT ca.* \r\n"
    		+ "FROM orden_camioneta oc \r\n"
    		+ "INNER JOIN camioneta AS ca ON oc.camioneta_id = ca.id \r\n"
    		+ "WHERE oc.orden_id = :idOrden", nativeQuery = true)
	List <Camioneta> obtenerOrdenes(@Param("idOrden") Integer idOrden);
}