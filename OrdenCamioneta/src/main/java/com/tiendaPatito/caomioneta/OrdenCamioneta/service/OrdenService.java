package com.tiendaPatito.caomioneta.OrdenCamioneta.service;

import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.GenericoDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.OrdenDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.ResponseDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Orden;
import java.util.List;
import java.util.Map;


public interface OrdenService {

    List<Orden> getAllOrders();
    Orden getOrderById(Long id);
    Orden createOrder(OrdenDTO orderDTO);
    ResponseDTO updateOrderStatus( GenericoDTO dto);

    List<Map<String, Object>> obtenerOrdenes();
    
    List<Map<String, Object>> detalleOrden( Integer idOrden);
}
