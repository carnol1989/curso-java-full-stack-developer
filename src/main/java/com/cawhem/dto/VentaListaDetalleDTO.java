package com.cawhem.dto;

import java.util.List;

import com.cawhem.model.DetalleVenta;
import com.cawhem.model.Venta;

public class VentaListaDetalleDTO {

	private Venta venta;
	private List<DetalleVenta> lstDetalleVenta;

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public List<DetalleVenta> getLstDetalleVenta() {
		return lstDetalleVenta;
	}

	public void setLstDetalleVenta(List<DetalleVenta> lstDetalleVenta) {
		this.lstDetalleVenta = lstDetalleVenta;
	}

}
