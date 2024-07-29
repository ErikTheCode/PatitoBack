package com.tiendaPatito.caomioneta.OrdenCamioneta.dto;


import java.util.List;


import lombok.Data;

@Data
public class OrdenDTO {

    private Long clienteId;
    private List<Long> camionetasIds;
    private Integer isDecuento;
    private Integer vendedorId;
    
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<Long> getCamionetasIds() {
		return camionetasIds;
	}
	public void setCamionetasIds(List<Long> camionetasIds) {
		this.camionetasIds = camionetasIds;
	}
	public Integer getIsDecuento() {
		return isDecuento;
	}
	public void setIsDecuento(Integer isDecuento) {
		this.isDecuento = isDecuento;
	}
	public Integer getVendedorId() {
		return vendedorId;
	}
	public void setVendedorId(Integer vendedorId) {
		this.vendedorId = vendedorId;
	}
    
    
    
    
    
}
