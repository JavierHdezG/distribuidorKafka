package com.seguros.azteca.distribuidorKafka.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transaccion {
	
	@XmlElement
	private Cabecero Cabecero;
	
	@XmlElement
	private List<Detalle> Detalle;
	
	
	public Cabecero getCabecero() {
		return Cabecero;
	}
	public void setCabecero(Cabecero cabecero) {
		this.Cabecero = cabecero;
	}
	
	public List<Detalle> getDetalle() {
		return Detalle;
	}
	public void setDetalle(List<Detalle> detalle) {
		Detalle = detalle;
	}
	
}
