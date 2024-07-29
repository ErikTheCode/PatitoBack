package com.tiendaPatito.caomioneta.OrdenCamioneta.service;

import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.SignupFormDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.dto.PerfilUsuarioDTO;
import com.tiendaPatito.caomioneta.OrdenCamioneta.entities.Usuario;
import com.tiendaPatito.caomioneta.OrdenCamioneta.exceptions.BadRequestException;
import com.tiendaPatito.caomioneta.OrdenCamioneta.exceptions.ResourceNotFoundException;
import com.tiendaPatito.caomioneta.OrdenCamioneta.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CuentaService {

    private UsuarioRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    public PerfilUsuarioDTO signup(SignupFormDTO signupFormDTO) {
        boolean emailAlreadyExists = userRepository.existsByEmail(signupFormDTO.getEmail());

        if (emailAlreadyExists) {
            throw new BadRequestException("El email ya está siendo usado por otro usuario.");
        }

        Usuario user = modelMapper.map(signupFormDTO, Usuario.class);
        user.setPassword(passwordEncoder.encode(signupFormDTO.getPassword()));
        user.setRole(signupFormDTO.getRol());
       

        userRepository.save(user);

        return modelMapper.map(user, PerfilUsuarioDTO.class);
    }

    public PerfilUsuarioDTO findByEmail(String email) {
        Usuario user = userRepository
                .findOneByEmail(email)
                .orElseThrow(ResourceNotFoundException::new);

        return modelMapper.map(user, PerfilUsuarioDTO.class);
    }

}

