package com.loylty.camel.workshop;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.loylty.camel.CamelConstants;

@Component
public class JSONDownloadRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from(CamelConstants.ACTIVE_MQ + "JSON-FILES")
		.routeId("JSON file Route")
		.log("${file:name}")
		.to(CamelConstants.FILE + "{{workshop.destination.json.directory}}");
		
	}

}
