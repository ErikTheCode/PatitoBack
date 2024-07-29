package com.tiendaPatito.caomioneta.OrdenCamioneta.repository;

import  com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Optional<Usuario> findOneByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Integer idNot);
}