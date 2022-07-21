package com.loylty.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.loylty.camel.CamelConstants;
import com.loylty.camel.beans.DeciderBean;

//@Component
public class FileRoute extends RouteBuilder{

	@Autowired
	private DeciderBean deciderBean;
	private static final Logger logger = LoggerFactory.getLogger(FileRoute.class);
	
	@Override
	public void configure() throws Exception {
		
		logger.info("configure method of File Route called");
		from("file:C:\\Users\\Aryak\\OneDrive\\Desktop\\Camel\\input")
		.routeId("File-Route")
		// converting the message body into String
		.transform().body(String.class)
		// decision making block, similar to if - else block
		.choice()
			// using a bean for validation. The complex validation will be handled by the bean
			.when(method(deciderBean,"isValid"))
			// checking extensions of the file
			.when(simple("${file:ext} == 'xml'"))
				.log("Input is an XML file")
			.when(simple("${file:ext} == 'json'"))
				.log("Input is a JSON file")
			// checking body content
			.when(simple("${body} contains 'zookeeper'"))
				.log("Input is a docker compose file")
			.otherwise()
				.log("Input is an unknown file")
		.end()
		// using generic end point
		.to(CamelConstants.DIRECT + "generic-log")
		.to(CamelConstants.FILE + "C:\\Users\\Aryak\\OneDrive\\Desktop\\Camel\\output")
		.end();
		
		
		// this is a generic end point that is user-created
		from(CamelConstants.DIRECT + "generic-log")
		.routeId("Logging-Route")
		.log("The file ${file:name} of size ${file:size} has been picked for processing")
		.end();		
	}

}
