package com.loylty.camel.routes;

import org.apache.camel.builder.RouteBuilder;

import com.loylty.camel.CamelConstants;

public class HelloWorldRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from(CamelConstants.DIRECT + "greeting")
		.log("${body}")
		.end();	
	}

}
