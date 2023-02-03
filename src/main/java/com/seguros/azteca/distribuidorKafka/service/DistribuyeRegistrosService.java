package com.seguros.azteca.distribuidorKafka.service;

import com.seguros.azteca.distribuidorKafka.model.Transaccion;

public interface DistribuyeRegistrosService {
	
	Transaccion distribuyeRegOfTransac(Transaccion transaccion);

}
