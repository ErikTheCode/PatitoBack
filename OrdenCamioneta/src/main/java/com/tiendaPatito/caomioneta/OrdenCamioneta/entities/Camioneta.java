package com.tiendaPatito.caomioneta.OrdenCamioneta.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "camioneta")
public class Camioneta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "marca")
	private String marca;

	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "precio")
	private BigDecimal precio;
	
	@Column(name = "descuento")
	private BigDecimal descuento;
	
	@Column(name = "disponibilidad")
	private int disponibilidad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

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

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
	
}
