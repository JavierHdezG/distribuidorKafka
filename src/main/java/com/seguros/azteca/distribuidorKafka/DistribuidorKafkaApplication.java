package com.seguros.azteca.distribuidorKafka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import com.seguros.azteca.distribuidorKafka.service.FiltraTransaccionService;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
public class DistribuidorKafkaApplication {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	/*
	 * @Autowired private MeterRegistry meterRegistry;
	 */
	
	@Autowired
	private FiltraTransaccionService filtraTransaccionService;
	
	private static final Logger log = LoggerFactory.getLogger(DistribuidorKafkaApplication.class);

	@KafkaListener(id= "idSeguros", autoStartup= "true", topics="seguros-topic", containerFactory="listenerContainerFactory", groupId= "seguros-group", properties = {"max.poll.interval.ms:4000", "max.poll.records:50"})
	public void Listen(List<ConsumerRecord<String, String>> messages) {
		// ciclo para escuchar las transacciones en el topico y procesarla.
		for (ConsumerRecord<String, String> message: messages) {
			// log.info("Partition = {}, Offset={}, Key={}, Value={}", message.partition(), message.offset(), message.key(), message.value());
			filtraTransaccionService.filtraTransacciones(message.value());
					
		}
		log.info("Batch complete");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DistribuidorKafkaApplication.class, args);
	}

	// @Scheduled(fixedDelay=100000, initialDelay = 100000)
	public void sendKafkaMessages() {
		/*
		 * for(int i= 0; i < 200; i++) { kafkaTemplate.send("seguros-topic",
		 * String.valueOf(i) ,String.format("Transaccion Seguros %d", i)); }
		 */
		String fileName= "";
		fileName= "/home/javierhdezg/Descargas/Pruebas_flujo.txt";
		ArrayList<String> transaccionesArchivo = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String transaccionLectura;
			while((transaccionLectura = br.readLine()) != null) {
				transaccionesArchivo.add(transaccionLectura);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 if(!transaccionesArchivo.isEmpty()) {
			 for(String transaccion : transaccionesArchivo) { 
				 Integer counter = transaccionesArchivo.indexOf(transaccion);
				 kafkaTemplate.send("seguros-topic",counter.toString(),transaccion);
				 log.info("counter {}", counter);
			 }
		 }
	}
	
	/*
	 * @Scheduled(fixedDelay = 2000, initialDelay = 500) public void printMetrics()
	 * { double count =
	 * meterRegistry.get("kafka.producer.record.send.total").functionCounter().count
	 * (); log.info("Count {}", count); }
	 */
	
}
