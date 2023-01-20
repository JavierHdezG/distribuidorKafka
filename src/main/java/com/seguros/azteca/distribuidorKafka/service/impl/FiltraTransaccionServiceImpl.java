package com.seguros.azteca.distribuidorKafka.service.impl;


import java.io.StringReader;

import javax.xml.bind.JAXB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.seguros.azteca.distribuidorKafka.model.Transaccion;
import com.seguros.azteca.distribuidorKafka.service.FiltraTransaccionService;

@Service
public class FiltraTransaccionServiceImpl implements FiltraTransaccionService {
	
	private static final Logger log = LoggerFactory.getLogger(FiltraTransaccionServiceImpl.class);

	public FiltraTransaccionServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String filtraTransacciones(String transaccionBusCentral) {
		try {
			Transaccion transac = (Transaccion) JAXB.unmarshal(new StringReader(transaccionBusCentral), Transaccion.class);
				System.out.println(transac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Error {}", e.getMessage());
		}
		
		return null;
	}

	

}
