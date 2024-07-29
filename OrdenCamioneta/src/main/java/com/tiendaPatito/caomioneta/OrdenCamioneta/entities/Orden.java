package com.tiendaPatito.caomioneta.OrdenCamioneta.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orden")
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name ="fecha_creacion")
	private LocalDateTime fechaCreacion;
	
	@Column (name ="total")
	private BigDecimal total;
	
	@Column (name ="estatus")
	private String estatus;
	
	@Column (name ="is_descuento")
	private Integer isDescuento;
	
	@Column (name ="vendedor_id")
	private Integer vendedorId;
	@ManyToOne
	private Cliente cliente;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getIsDescuento() {
		return isDescuento;
	}

	public void setIsDescuento(Integer isDescuento) {
		this.isDescuento = isDescuento;
	}

	public Integer getVendedorId() {
		return vendedorId;
	}

	public void setVendedorId(Integer vendedorId) {
		this.vendedorId = vendedorId;
	}

}
