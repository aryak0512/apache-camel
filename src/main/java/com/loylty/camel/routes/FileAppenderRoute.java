package com.loylty.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.loylty.camel.CamelConstants;
//@Component
public class FileAppenderRoute extends RouteBuilder {
	
	private static final Logger logger = LoggerFactory.getLogger(FileAppenderRoute.class);

	@Override
	public void configure() throws Exception {
		
		logger.info("configure method of FileAppenderRoute called");
		from(CamelConstants.FILE + CamelConstants.FILE_DIR + "fileName={{source.file}}")
		.routeId("File Appender Route")
		.log("Appending content of one file to another")
		.log("${headers}")
		.to(CamelConstants.FILE + CamelConstants.FILE_DIR + "fileName={{destination.file}}" + CamelConstants.APPEND)
		.end();		
	
	}

}
