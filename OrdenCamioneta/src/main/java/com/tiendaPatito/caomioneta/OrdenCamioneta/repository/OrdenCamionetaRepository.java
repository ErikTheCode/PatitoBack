package com.tiendaPatito.caomioneta.OrdenCamioneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.OrdenCamioneta;

public interface OrdenCamionetaRepository extends JpaRepository<OrdenCamioneta, Long> {
}
