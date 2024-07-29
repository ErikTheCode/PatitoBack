package com.tiendaPatito.caomioneta.OrdenCamioneta.dto;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class CamionetaDTO {

    private String marca;
    private String modelo;
    private BigDecimal precio;
    private int disponibilidad;
    private BigDecimal descuento;
    
    private int id;
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public int getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public BigDecimal getDescuento() {
		return descuento;
	}
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    
    
}
