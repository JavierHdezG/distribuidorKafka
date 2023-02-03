package com.seguros.azteca.distribuidorKafka.service.impl;


import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.bind.JAXB;

import org.apache.kafka.common.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguros.azteca.distribuidorKafka.model.Detalle;
import com.seguros.azteca.distribuidorKafka.model.Transaccion;
import com.seguros.azteca.distribuidorKafka.service.DistribuyeRegistrosService;
import com.seguros.azteca.distribuidorKafka.service.FiltraTransaccionService;

@Service
public class FiltraTransaccionServiceImpl implements FiltraTransaccionService {
	
	private static final Logger log = LoggerFactory.getLogger(FiltraTransaccionServiceImpl.class);
	
	@Autowired
	private DistribuyeRegistrosService distribuyeRegistrosService;

	public FiltraTransaccionServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Integer> listRegistrosSeguros(){
		List<Integer> lista = new ArrayList<>();
			lista.add(1064);
			lista.add(1065);
			lista.add(1066);
			lista.add(1067);
			lista.add(1068);
			lista.add(1069);
			lista.add(2268);
			lista.add(2266);
			lista.add(2269);
			lista.add(2270);
			lista.add(2271);
			lista.add(2272);
			lista.add(5354);
			lista.add(5355);
			lista.add(5356);
			lista.add(5358);
			lista.add(7420);
			lista.add(5359);
			lista.add(5360);
			lista.add(5361);
			lista.add(5362);
			lista.add(5357);
			lista.add(7417);
			lista.add(5363);
			lista.add(5364);
			lista.add(5365);
			lista.add(5366);
			lista.add(5367);
			lista.add(5368);
			lista.add(5369);
			lista.add(5372);
			lista.add(5373);
			lista.add(5374);
			lista.add(5351);
			lista.add(5378);
			lista.add(5379);
			lista.add(5380);
			lista.add(3330);
			lista.add(3331);
			lista.add(3332);
			lista.add(3333);
			lista.add(5375);
			lista.add(5376);
			lista.add(5377);
			lista.add(5384);
			lista.add(5385);
			lista.add(5386);
			lista.add(5387);
			lista.add(5388);
			lista.add(5389);
			lista.add(1042);
			lista.add(1043);
			lista.add(2657);
			lista.add(2658);
			lista.add(5390);
			lista.add(5391);
			lista.add(4462);
			lista.add(10);
			lista.add(12);
			lista.add(70);
		   	lista.add(75);
		   	lista.add(2978);
		   	lista.add(215);
		   	lista.add(1057);
		   	lista.add(5392);
		   	lista.add(5393);
		   	lista.add(5394);
		   	lista.add(5400);
		   	lista.add(5401);
		   	lista.add(5402);
		   	lista.add(5403);
		   	lista.add(7439);
		   	lista.add(5404);
		   	lista.add(5405);
		   	lista.add(7429);
		   	lista.add(4732);
		   	lista.add(5406);
		   	lista.add(5407);
		   	lista.add(5408);
		   	lista.add(5409);
		   	lista.add(5410);
		   	lista.add(5411);
		   	lista.add(5412);
		   	lista.add(5413);
		   	lista.add(5415);
		   	lista.add(5416);
		   	lista.add(7442);
		   	lista.add(5418);
		   	lista.add(5421);
		   	lista.add(5422);
		   	lista.add(7403);
		   	lista.add(185);
		   	lista.add(110);
		   	lista.add(7412);
		   	lista.add(2320);
		   	lista.add(5425);
		   	lista.add(100);
		   	lista.add(210);
		   	lista.add(220);
		   	lista.add(5424);
		   	lista.add(5423);
		   	lista.add(5196);
		   	lista.add(5428);
		   	lista.add(5429);
		   	lista.add(5430);
		   	lista.add(5426);
		   	lista.add(5427);
		   	lista.add(5431);
		   	lista.add(5432);
		   	lista.add(2148);
		   	lista.add(5436);
		   	lista.add(5437);
		   	lista.add(5433);
		   	lista.add(5434);
		   	lista.add(5435);
		   	lista.add(5443);
		   	lista.add(5444);
		return lista;
	}

	@Override
	public String filtraTransacciones(String transaccionBusCentral) {
		try {
			Transaccion transac = (Transaccion) JAXB.unmarshal(new StringReader(transaccionBusCentral), Transaccion.class);	
			List<Detalle> detallesTransac = transac.getDetalle();
			List<Integer> fitipoReg = new ArrayList<>();
			for(Detalle detalleTransac : detallesTransac) {
				fitipoReg.add(detalleTransac.getFITIPOREG());
			}
			Set<Integer> validaTransac = this.listRegistrosSeguros().stream().distinct().filter(fitipoReg::contains).collect(Collectors.toSet());
			if(!validaTransac.isEmpty()) {
				log.info("Mandar Objeto Transaccion a topico principal");
				distribuyeRegistrosService.distribuyeRegOfTransac(transac);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Error {}", e.getMessage());
		}
		
		return null;
	}
	

	

}
