package com.loylty.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.loylty.camel.processors.MyProcessor;
//@Component
public class TestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:test")
		.log("${body}")
		// adding a processing block
		.process(new MyProcessor())
		.to("direct:greeting")
		.end();
	}

}
