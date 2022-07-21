package com.loylty.camel.workshop;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.loylty.camel.CamelConstants;
@Component
public class TextDownloadRoute extends RouteBuilder{
	@Override
	public void configure() throws Exception {
		from(CamelConstants.ACTIVE_MQ + "TEXT-FILES")
		.routeId("Text file Route")
		.log("${file:name}")
		.to(CamelConstants.FILE + "{{workshop.destination.text.directory}}");
		
	}
}
