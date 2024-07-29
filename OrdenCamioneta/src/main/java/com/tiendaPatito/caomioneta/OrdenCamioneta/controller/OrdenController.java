package com.tiendaPatito.caomioneta.OrdenCamioneta.controller;

import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.GenericoDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.OrdenDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.ResponseDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Orden;
import com.tiendaPatito.caomioneta.OrdenCamioneta.service.OrdenService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrdenController {

	
	@Autowired
    private OrdenService orderService;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllOrders() {
    	 List<Map<String, Object>> results = orderService.obtenerOrdenes();
         return ResponseEntity.ok(results);
       // return orderService.getAllOrders();
    }
    
    @PostMapping("/orden-details")
    public ResponseEntity<List<Map<String, Object>>> getDetallesOrden(@RequestBody GenericoDTO dto) {
    	 List<Map<String, Object>> results = orderService.detalleOrden(dto.getId());
         return ResponseEntity.ok(results);
       // return orderService.getAllOrders();
    }
    

    @GetMapping("/{id}")
    public Orden getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Orden createOrder(@RequestBody OrdenDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @PostMapping("/order-update-status")
    public ResponseDTO updateOrderStatus(@RequestBody GenericoDTO dto) {
        return orderService.updateOrderStatus(dto);
    }
}
