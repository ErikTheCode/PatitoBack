package com.tiendaPatito.caomioneta.OrdenCamioneta.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SignupFormDTO {
   

    @NotBlank
    private String nombreCompleto;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
    
    @NotBlank
    private String rol;

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
    
    

  
}
