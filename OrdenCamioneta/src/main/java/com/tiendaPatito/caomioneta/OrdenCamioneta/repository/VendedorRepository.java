package com.tiendaPatito.caomioneta.OrdenCamioneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}