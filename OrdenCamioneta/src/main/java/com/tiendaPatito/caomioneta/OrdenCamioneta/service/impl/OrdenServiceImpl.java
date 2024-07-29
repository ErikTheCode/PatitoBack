package com.tiendaPatito.caomioneta.OrdenCamioneta.service.impl;

import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.GenericoDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.OrdenDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.ResponseDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Orden;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.OrdenCamioneta;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Camioneta;
import com.tiendaPatito.caomioneta.OrdenCamioneta.exceptions.BadRequestException;
import com.tiendaPatito.caomioneta.OrdenCamioneta.exceptions.ResourceNotFoundException;
import com.tiendaPatito.caomioneta.OrdenCamioneta.service.OrdenService;
import com.tiendaPatito.caomioneta.OrdenCamioneta.repository.*;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Service
@AllArgsConstructor
public class OrdenServiceImpl implements OrdenService {

	@Autowired
    private OrdenRepository orderRepository;

	@Autowired
    private CamionetaRepository truckRepository;

	@Autowired
    private ClienteRepository customerRepository;

	@Autowired 
	private  OrdenCamionetaRepository ordenCamionetaRepository;

    @Override
    public List<Orden> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orden getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    public Orden createOrder(OrdenDTO orderDTO) {

        List<Camioneta> trucks = new ArrayList<>();

        for (Long truckId : orderDTO.getCamionetasIds()) {
        	Camioneta truck = truckRepository.findById(truckId)
                    .orElseThrow(() -> new ResourceNotFoundException("Truck not found with id: " + truckId));
            if (truck.getDisponibilidad() <= 0) {
                throw new BadRequestException("Truck " + truck.getModelo() + " is not available in stock");
            }
            trucks.add(truck);
            
        }
        

        Orden order = new Orden();
        order.setEstatus("PENDIENTE");
        order.setIsDescuento(orderDTO.getIsDecuento());
        order.setVendedorId(orderDTO.getVendedorId());
        order.setFechaCreacion(LocalDateTime.now());
        order.setCliente(customerRepository.findById(orderDTO.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + orderDTO.getClienteId())));
        
      

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Camioneta camioneta : trucks) {

            totalPrice = orderDTO.getIsDecuento() == 1 ?
                    totalPrice.add(camioneta.getPrecio().multiply(camioneta.getDescuento()).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP))
                    : camioneta.getPrecio();
            camioneta.setDisponibilidad(camioneta.getDisponibilidad() - 1);
            truckRepository.save(camioneta);
        }
        order.setTotal(totalPrice);
        
        orderRepository.save(order);
        for (Camioneta camioneta : trucks) {
        	OrdenCamioneta m = new OrdenCamioneta ();
        	m.setCamionetaId(camioneta.getId());
        	m.setOrdenId(order.getId());
        	ordenCamionetaRepository.save(m);
        	
        	//camioneta
        }
        
        
        //guardamos la tabla de muchos a muchos entre camioneta y orden
        
        return order;

    }

    @Override
	public ResponseDTO updateOrderStatus(GenericoDTO dto) {
    	
    	ResponseDTO response = new ResponseDTO (null);
        Orden order = orderRepository.findById(  Long.valueOf(dto.getId()))
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        
        LocalDateTime dateOrder = order.getFechaCreacion();
        
        LocalDateTime now = LocalDateTime.now();
        
        long minutosDiferencia = ChronoUnit.MINUTES.between(dateOrder, now);
        

        
        if (minutosDiferencia > 10) {
        	response.setEstatus("false");
        	return response;
        } else {
        	
        	 if (order.getEstatus().equals("PENDIENTE") && (dto.getEstatus().equals("ENTREGADO") || dto.getEstatus().equals("CANCELADO"))) {
                 order.setEstatus(dto.getEstatus());
             } else {
                 throw new BadRequestException("Invalid status change");
             }

             List<Camioneta> listaCamioneta = truckRepository.obtenerOrdenes(dto.getId());

             if (dto.getEstatus().equals("CANCELADO")) {
                 for (Camioneta truck : listaCamioneta) {
                     truck.setDisponibilidad(truck.getDisponibilidad() + 1);

                     truckRepository.save(truck);
                 }
             }
             response.setEstatus("true");
             return response;
            
        }

       


        

    }

	@Override
	public List<Map<String, Object>> obtenerOrdenes() {
		return orderRepository.obtenerOrdenes();
	}

	@Override
	public List<Map<String, Object>> detalleOrden(Integer idOrden) {
		// TODO Auto-generated method stub
		return orderRepository.detalleOrden(idOrden);
	}

}
