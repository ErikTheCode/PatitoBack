package com.tiendaPatito.caomioneta.OrdenCamioneta.service;

import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.CamionetaDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Camioneta;

import java.util.List;

public interface CamionetaService {

    List<Camioneta> getAllTrucks();
    Camioneta getTruckById(CamionetaDTO truckDTO);
    Camioneta createTruck(CamionetaDTO truckDTO);
    Camioneta updateTruck(CamionetaDTO truckDTO);
    void deleteTruck(Long id);
}
