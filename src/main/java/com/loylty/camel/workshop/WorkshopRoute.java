package com.loylty.camel.workshop;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.loylty.camel.CamelConstants;
//@Component
public class WorkshopRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
			
		from(CamelConstants.FILE + "{{workshop.source.directory}}")
		.routeId("Workshop Route")
		.choice()
		
			.when(simple("${file:ext} == 'json'"))
				.log("JSON file: ${file:name} of size: ${file:size} has been picked for processing.")
				.to(CamelConstants.ACTIVE_MQ + "JSON-FILES")
				
			.when(simple("${file:ext} == 'txt'"))
			.log("Text file: ${file:name} of size: ${file:size} has been picked for processing.")
				.to(CamelConstants.ACTIVE_MQ + "TEXT-FILES")
				
			.otherwise()
				.log("Input is an unknown file")
				
		.end();
	
	}

}
