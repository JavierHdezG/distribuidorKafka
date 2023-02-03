package com.seguros.azteca.distribuidorKafka.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seguros.azteca.distribuidorKafka.model.Cabecero;
import com.seguros.azteca.distribuidorKafka.model.Detalle;
import com.seguros.azteca.distribuidorKafka.model.Transaccion;
import com.seguros.azteca.distribuidorKafka.service.DistribuyeRegistrosService;

@Service
public class DistribuyeRegistrosServiceImpl implements DistribuyeRegistrosService{

	public DistribuyeRegistrosServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Transaccion distribuyeRegOfTransac(Transaccion transaccion) {
		transaccion.getCabecero();
		List<Detalle> detalleTransac = transaccion.getDetalle();
		for(Detalle detalle :detalleTransac) {
			Integer fitiporeg = detalle.getFITIPOREG();
			
		}
		return null;
	}

}
