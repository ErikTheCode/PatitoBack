package com.tiendaPatito.caomioneta.OrdenCamioneta.controller;

import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.UsuarioFormDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Usuario;
import com.tiendaPatito.caomioneta.OrdenCamioneta.exceptions.ResourceNotFoundException;
import com.tiendaPatito.caomioneta.OrdenCamioneta.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin/users")
public class AdminUsuarioController {

    private UsuarioRepository userRepository;

    @GetMapping
    Page<Usuario> paginate(@PageableDefault(sort = "fullName", size = 5) Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @PostMapping
    Usuario create(@RequestBody @Validated UsuarioFormDTO dto) {
        return null;
    }

    @GetMapping("/{id}")
    Usuario get(@PathVariable Integer id) {
        return userRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @PutMapping("/{id}")
    Usuario update(
            @PathVariable Integer id,
            @RequestBody @Validated UsuarioFormDTO dto
    ) {
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
    	Usuario user = userRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        userRepository.delete(user);
    }

}
