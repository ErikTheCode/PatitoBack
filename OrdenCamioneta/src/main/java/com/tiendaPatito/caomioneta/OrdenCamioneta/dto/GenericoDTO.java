package com.tiendaPatito.caomioneta.OrdenCamioneta.dto;

import lombok.Data;

@Data
public class GenericoDTO {
	
	private  Integer id;
	
	private String estatus;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	

}
