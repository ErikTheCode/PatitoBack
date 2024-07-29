package com.tiendaPatito.caomioneta.OrdenCamioneta.service.impl;


import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.CamionetaDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Camioneta;
import com.tiendaPatito.caomioneta.OrdenCamioneta.exceptions.ResourceNotFoundException;
import com.tiendaPatito.caomioneta.OrdenCamioneta.repository.CamionetaRepository;
import com.tiendaPatito.caomioneta.OrdenCamioneta.service.CamionetaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CamionetaServiceImpl implements CamionetaService {

	@Autowired
    private CamionetaRepository truckRepository;

    private ModelMapper modelMapper;

    @Override
    public List<Camioneta> getAllTrucks() {
        return truckRepository.findAll();
    }

    @Override
    public Camioneta getTruckById(CamionetaDTO truckDTO) {
        return truckRepository.findById(Long.valueOf(truckDTO.getId()))
                .orElseThrow(() -> new ResourceNotFoundException("Truck not found"));
    }

    @Override
    public Camioneta createTruck(CamionetaDTO truckDTO) {

    	Camioneta truck = new Camioneta();
    	truck.setModelo(truckDTO.getModelo());
    	truck.setDescuento(truckDTO.getDescuento());
    	truck.setDisponibilidad(truckDTO.getDisponibilidad());
    	truck.setMarca(truckDTO.getMarca());
    	truck.setPrecio(truckDTO.getPrecio());
    	

        return truckRepository.save(truck);

    }

    @Override
    public Camioneta updateTruck(CamionetaDTO truckDTO) {

    	Camioneta truck = truckRepository.findById( Long.valueOf(truckDTO.getId()))
                .orElseThrow(() -> new ResourceNotFoundException("Truck not found"));

     //   modelMapper.map(truckDTO, truck);
    	
    	
    	truck.setModelo(truckDTO.getModelo());
    	truck.setDescuento(truckDTO.getDescuento());
    	truck.setDisponibilidad(truckDTO.getDisponibilidad());
    	truck.setMarca(truckDTO.getMarca());
    	truck.setPrecio(truckDTO.getPrecio());

        return truckRepository.save(truck);
    }

    @Override
    public void deleteTruck(Long id) {
    	Camioneta truck = truckRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Truck not found"));
        truckRepository.delete(truck);
    }


}
