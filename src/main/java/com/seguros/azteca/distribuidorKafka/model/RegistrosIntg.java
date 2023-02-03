package com.seguros.azteca.distribuidorKafka.model;

import java.util.List;

public class RegistrosIntg {
	
	private Integer idRegistroIntg;
	private Integer fitiporeg;
	
	private List<Integer> listFitipoReg;
	
	public Integer getIdRegistroIntg() {
		return idRegistroIntg;
	}
	public void setIdRegistroIntg(Integer idRegistroIntg) {
		this.idRegistroIntg = idRegistroIntg;
	}
	public Integer getFitiporeg() {
		return fitiporeg;
	}
	public void setFitiporeg(Integer fitiporeg) {
		this.fitiporeg = fitiporeg;
	}
	public List<Integer> getListFitipoReg() {
		return listFitipoReg;
	}
	public void setListFitipoReg(List<Integer> listFitipoReg) {
		this.listFitipoReg = listFitipoReg;
	}
	
	
}
