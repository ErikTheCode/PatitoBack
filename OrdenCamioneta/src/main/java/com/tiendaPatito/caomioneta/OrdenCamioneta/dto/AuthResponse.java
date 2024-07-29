package com.tiendaPatito.caomioneta.OrdenCamioneta.dto;



public class AuthResponse {
    private String token;
    private PerfilUsuarioDTO user;
    
    
	public AuthResponse(String token, PerfilUsuarioDTO user) {
		super();
		this.token = token;
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public PerfilUsuarioDTO getUser() {
		return user;
	}
	public void setUser(PerfilUsuarioDTO user) {
		this.user = user;
	}
    
    
}
