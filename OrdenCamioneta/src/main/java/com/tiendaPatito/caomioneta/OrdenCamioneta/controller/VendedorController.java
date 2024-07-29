package com.tiendaPatito.caomioneta.OrdenCamioneta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Vendedor;
import com.tiendaPatito.caomioneta.OrdenCamioneta.service.VendedorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/salesperson")
@AllArgsConstructor
public class VendedorController {
	
	@Autowired
    private VendedorService SalesPersonService;
	
	@GetMapping
    public List<Vendedor> getAllCustomers() {
        return SalesPersonService.getAllSalesPerson();
    }


}
