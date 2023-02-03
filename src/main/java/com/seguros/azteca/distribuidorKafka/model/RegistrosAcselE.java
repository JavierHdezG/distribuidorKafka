package com.seguros.azteca.distribuidorKafka.model;

import java.util.List;

public class RegistrosAcselE {

	private Integer idRegistroAcselE;
	private Integer fitiporeg;
	
	private List<Integer> listFitipoReg;
	
	public Integer getIdRegistroAcselE() {
		return idRegistroAcselE;
	}
	public void setIdRegistroAcselE(Integer idRegistroAcselE) {
		this.idRegistroAcselE = idRegistroAcselE;
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
