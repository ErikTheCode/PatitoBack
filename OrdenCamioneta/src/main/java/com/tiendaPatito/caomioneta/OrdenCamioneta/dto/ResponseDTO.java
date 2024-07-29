package com.tiendaPatito.caomioneta.OrdenCamioneta.dto;

public class ResponseDTO {

	private String estatus;

	public ResponseDTO(String estatus) {
		this.estatus = estatus;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}
