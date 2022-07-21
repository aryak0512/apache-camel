package com.loylty.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loylty.camel.CamelConstants;


public class KafkaProducerRoute extends RouteBuilder {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerRoute.class);

	@Override
	public void configure() throws Exception {
		
		logger.info("configure method of KafkaProducerRoute called");
		from(CamelConstants.FILE + "C:\\Users\\Aryak\\OneDrive\\Desktop\\Camel\\data")
		.log("Producing body: ${body}")
		// publishing on kafka endpoint. Here json-topic is the topic name
		.to(CamelConstants.KAFKA + "json-topic")
		.end();
	}
}
