package com.loylty.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.loylty.camel.CamelConstants;
import com.loylty.camel.beans.SplitterBean;
//@Component
public class SplitPatternRoute extends RouteBuilder{

	@Autowired
	private SplitterBean splitterBean;
	
	private static final Logger logger = LoggerFactory.getLogger(SplitPatternRoute.class);
	
	@Override
	public void configure() throws Exception {
		logger.info("configure method of SplitPatternRoute called");
		from(CamelConstants.FILE + CamelConstants.CSV_FILE_PATH)
		.routeId("SPLIT ROUTE")
		.unmarshal().csv()
		// by this the file gets split and each line is published as a message in the queue
		//.split(body())
		
		// by this the file gets split by custom logic and is published as a message in the queue
		.split(method(splitterBean,"splitMessage"))
		.log("${body}")
		.to("activemq:csv-queue");
		
	}

}
