package com.loylty.camel.routes;

import org.apache.camel.builder.RouteBuilder;

import com.loylty.camel.CamelConstants;

//@Component
public class ActiveMQRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("timer:my-timer?period=5000")
		.transform().constant("Message for Active MQ")
		.to("activemq:my-queue")
		.end();
	}

}
