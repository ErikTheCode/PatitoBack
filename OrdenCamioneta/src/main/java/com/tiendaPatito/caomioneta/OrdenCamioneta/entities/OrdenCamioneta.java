package com.tiendaPatito.caomioneta.OrdenCamioneta.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden_camioneta")
public class OrdenCamioneta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name ="orden_id")
	private int OrdenId ;
	
	@Column (name =" camioneta_id")
	private int camionetaId;

	public int getOrdenId() {
		return OrdenId;
	}

	public void setOrdenId(int ordenId) {
		OrdenId = ordenId;
	}

	public int getCamionetaId() {
		return camionetaId;
	}

	public void setCamionetaId(int camionetaId) {
		this.camionetaId = camionetaId;
	}
	
	

}
