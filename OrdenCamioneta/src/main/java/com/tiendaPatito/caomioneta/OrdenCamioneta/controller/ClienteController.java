package com.tiendaPatito.caomioneta.OrdenCamioneta.controller;

import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.ClienteDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Cliente;
import com.tiendaPatito.caomioneta.OrdenCamioneta.service.ClienteService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class ClienteController {

	@Autowired
    private ClienteService customerService;

    @GetMapping
    public List<Cliente> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Cliente getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Cliente createCustomer(@RequestBody ClienteDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public Cliente updateCustomer(@PathVariable Long id, @RequestBody ClienteDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
