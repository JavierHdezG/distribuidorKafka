package com.seguros.azteca.distribuidorKafka.model;

import java.util.List;

public class RegistrosSie {

	private Integer idRegistroSie;
	private Integer fitiporeg;
	
	private List<Integer> listFitipoReg;
	
	public Integer getIdRegistroSie() {
		return idRegistroSie;
	}
	public void setIdRegistroSie(Integer idRegistroSie) {
		this.idRegistroSie = idRegistroSie;
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
