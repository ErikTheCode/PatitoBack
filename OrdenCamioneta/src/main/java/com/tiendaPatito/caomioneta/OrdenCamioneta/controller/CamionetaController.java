package com.tiendaPatito.caomioneta.OrdenCamioneta.controller;

import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.CamionetaDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Camioneta;
import com.tiendaPatito.caomioneta.OrdenCamioneta.service.CamionetaService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/trucks")
@AllArgsConstructor
public class CamionetaController {

	
	@Autowired
    private CamionetaService truckService;

    @GetMapping
    public List<Camioneta> getAllTrucks() {
        return truckService.getAllTrucks();
    }

    @GetMapping("/devolver-camioneta")
    public Camioneta getTruckById(@RequestBody CamionetaDTO truckDTO) {
        return truckService.getTruckById(truckDTO);
    }

    @PostMapping
    public Camioneta createTruck(@RequestBody CamionetaDTO truckDTO) {
         truckService.createTruck(truckDTO);
         
         return null;
    }

    @PutMapping
    public ResponseEntity<?> updateTruck(@RequestBody CamionetaDTO truckDTO) {
         truckService.updateTruck( truckDTO);
        return ResponseEntity.ok().build();
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTruck(@PathVariable Long id) {
        truckService.deleteTruck(id);
        return ResponseEntity.ok().build();
    }*/
}
