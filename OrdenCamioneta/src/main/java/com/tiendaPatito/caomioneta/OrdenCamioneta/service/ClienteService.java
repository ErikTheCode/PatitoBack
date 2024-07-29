package com.tiendaPatito.caomioneta.OrdenCamioneta.service;

import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.ClienteDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> getAllCustomers();
    Cliente getCustomerById(Long id);
    Cliente createCustomer(ClienteDTO customerDTO);
    Cliente updateCustomer(Long id, ClienteDTO customerDTO);
    void deleteCustomer(Long id);
}
