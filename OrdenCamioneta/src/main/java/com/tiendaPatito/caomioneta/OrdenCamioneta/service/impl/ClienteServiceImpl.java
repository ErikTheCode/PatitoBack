package com.tiendaPatito.caomioneta.OrdenCamioneta.service.impl;

import com.tiendaPatito.caomioneta.OrdenCamioneta.exceptions.ResourceNotFoundException;
import com.tiendaPatito.caomioneta.OrdenCamioneta.repository.ClienteRepository;
import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.ClienteDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Cliente;
import com.tiendaPatito.caomioneta.OrdenCamioneta.service.ClienteService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

	@Autowired
    private ClienteRepository customerRepository;

    private ModelMapper modelMapper;

    @Override
    public List<Cliente> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Cliente getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    @Override
    public Cliente createCustomer(ClienteDTO customerDTO) {
    	//Cliente customer = modelMapper.map(customerDTO, Cliente.class);
    	
    	Cliente customer = new Cliente();
    	customer.setNombreCompleto(customerDTO.getNombreCompleto());
    	customer.setTelefono(customerDTO.getTel());
    	customer.setEmail(customerDTO.getEmail());
    	
    		
        return customerRepository.save(customer);
    }

    @Override
    public Cliente updateCustomer(Long id, ClienteDTO customerDTO) {

    	Cliente customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        modelMapper.map(customerDTO, customer);

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {

    	Cliente customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        customerRepository.delete(customer);
    }
}
