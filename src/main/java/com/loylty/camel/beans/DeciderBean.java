package com.loylty.camel.beans;

import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeciderBean {
	
	private static final Logger logger = LoggerFactory.getLogger(DeciderBean.class);
	
	public boolean isValid(@Body String body, @ExchangeProperties Map<String, String> exchangeProps, @Headers Map<String, String> headers) {
		
		// complex business logic goes here
		logger.info("Decider bean: {} | {} | {}",body,exchangeProps,headers);
		return true;
	}

}
