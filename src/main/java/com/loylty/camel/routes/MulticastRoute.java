package com.loylty.camel.routes;

import org.apache.camel.builder.RouteBuilder;

import com.loylty.camel.CamelConstants;

public class MulticastRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from(CamelConstants.TIMER + "multicast" +CamelConstants.TIMER_PERIOD + 5000)
		.multicast()
		// multiple endpoints can be defined here
		.to("log:logger1","log:logger2","kafka:my-topic","activemq:my-queue")
		.end();
		
	}

}
