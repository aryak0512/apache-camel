package com.loylty.camel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyProcessor implements Processor{
	
	private static final Logger logger = LoggerFactory.getLogger(MyProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		// process logic goes here
		logger.info("=====================================");
		logger.info("Inside process block for test route");
		logger.info("EXCHANGE: "+exchange);	
		logger.info("EXCHANGE: "+exchange.getMessage().getBody());	
		String payload = exchange.getIn().getBody(String.class);
		logger.info("Payload was: "+payload);
        // do something with the payload and/or exchange here
       exchange.getIn().setBody(payload+" says hello world!!");
		
	}

}
