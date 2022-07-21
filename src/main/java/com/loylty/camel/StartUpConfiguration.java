package com.loylty.camel;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StartUpConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(StartUpConfiguration.class);
	
	@PostConstruct
	public void onStartUp() throws Exception{
		/*
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new HelloWorldRoute());
		context.addRoutes(new TestRoute());
		context.addRoutes(new FileRoute());
		logger.info("=====================================");
		logger.info("Starting Camel context");
		logger.info("=====================================");
		context.start();
		ProducerTemplate template = context.createProducerTemplate();
		//template.sendBody("direct:greeting", "Hello World!!!");
		template.sendBody("direct:test?exchangePattern=InOut", "Apache Camel");
		logger.info("=====================================");
		logger.info("Closing Camel context");
		logger.info("=====================================");
		context.close();
		*/
	}

}
