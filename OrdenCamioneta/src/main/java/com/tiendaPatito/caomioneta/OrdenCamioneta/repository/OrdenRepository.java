package com.tiendaPatito.caomioneta.OrdenCamioneta.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
	
	

    @Query(value = "SELECT \r\n"
    		+ "    		    o.id, \r\n"
    		+ "    		    c.nombre_completo, \r\n"
    		+ "    		    o.fecha_creacion, \r\n"
    		+ "				v.nombre_completo as vendedor,\r\n"
    		+ "				t.cuidad,\r\n"
    		+ "    		    o.estatus,\r\n"
    		+ "    		   FORMAT( o.total, 'N2') as total, \r\n"
    		+ "    		    COUNT(oc.orden_id) AS numero_de_camionetas\r\n"
    		+ "    		FROM \r\n"
    		+ "    		    orden AS o\r\n"
    		+ "    		INNER JOIN \r\n"
    		+ "    		    cliente AS c ON o.cliente_id = c.id\r\n"
    		+ "    		INNER JOIN \r\n"
    		+ "    		    orden_camioneta AS oc ON oc.orden_id = o.id\r\n"
    		+ "			inner join vendedor as v  on o.vendedor_id = v.id\r\n"
    		+ "			inner join tienda as t on t.id = v.id_tienda\r\n"
    		+ "    		GROUP BY \r\n"
    		+ "    		    o.id, \r\n"
    		+ "    		    c.nombre_completo, \r\n"
    		+ "    		    o.fecha_creacion,\r\n"
    		+ "				v.nombre_completo,\r\n"
    		+ "				t.cuidad,\r\n"
    		+ "    		    o.estatus, \r\n"
    		+ "    		    o.total;", nativeQuery = true)
	List<Map<String, Object>> obtenerOrdenes();
    
    
    @Query(value = "select \r\n"
    		+ "c.marca, \r\n"
    		+ "c.modelo, \r\n"
    		+ "FORMAT(c.precio ,'N2') as bruto, \r\n"
    		+ "CASE o.is_descuento\r\n"
    		+ "    WHEN 1 THEN \r\n"
    		+ "	CONCAT( c.descuento,'%') \r\n"
    		+ "	WHEN 0 THEN \r\n"
    		+ "	'No aplico descuento'\r\n"
    		+ "    ELSE 'Inconsistencia de dato'\r\n"
    		+ "END as descuento ,	\r\n"
    		+ "CASE o.is_descuento\r\n"
    		+ "    WHEN 1 THEN \r\n"
    		+ "	FORMAT(ISNULL (c.precio - ROUND(c.precio * c.descuento / 100.0, 2), 0.00), 'N2')\r\n"
    		+ "	WHEN 0 THEN \r\n"
    		+ "	FORMAT(o.total, 'N2')\r\n"
    		+ "     ELSE 'Inconsistencia de dato'\r\n"
    		+ "END as precio_final ,	\r\n"
    		+ "CASE o.is_descuento\r\n"
    		+ "    WHEN 1 THEN \r\n"
    		+ "	FORMAT(ISNULL (ROUND(c.precio * c.descuento / 100.0, 2), 0.00), 'N2')\r\n"
    		+ "	when 0 then\r\n"
    		+ "	'No aplico descuento'\r\n"
    		+ "    ELSE 'Inconsistencia de dato'\r\n"
    		+ "END as descuento_aplicado \r\n"
    		+ "from \r\n"
    		+ "	orden_camioneta as oc\r\n"
    		+ "	inner join camioneta as c on c.id = oc.camioneta_id\r\n"
    		+ "	inner join orden o on o.id= oc.orden_id\r\n"
    		+ "where\r\n"
    		+ "oc.orden_id= :idOrden", nativeQuery = true)
    List<Map<String, Object>> detalleOrden(@Param("idOrden") Integer idOrden);
}
