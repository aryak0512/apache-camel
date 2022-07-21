package com.loylty.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loylty.camel.beans.GetTimeBean;
//@Component
public class MyFirstTimerRoute extends RouteBuilder{
	
	@Autowired
	private GetTimeBean getTimeBean;
	
	private static final Logger logger = LoggerFactory.getLogger(MyFirstTimerRoute.class);

	@Override
	public void configure() throws Exception {
		logger.info("configure method of MyFirstTimerRoute called");
		// here timer is a component
		from("timer:my-first-timer")
		.log("${body}")
		.transform().constant("My constant message")
		.log("${body}")
		//bean name followed by name of method
		.bean(getTimeBean, "getTime")       
		.log("${body}")
		.to("log:my-first-timer");	
	}

}
