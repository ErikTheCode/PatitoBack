package com.tiendaPatito.caomioneta.OrdenCamioneta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Vendedor;
import com.tiendaPatito.caomioneta.OrdenCamioneta.repository.VendedorRepository;
import com.tiendaPatito.caomioneta.OrdenCamioneta.service.VendedorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VendedorServiceImpl implements VendedorService{

	@Autowired
    private VendedorRepository salesPersonRepository;
	
	@Override
	public List<Vendedor> getAllSalesPerson() {
		return salesPersonRepository.findAll();
	}

}
