package com.loylty.camel.beans;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class GetTimeBean {
	
	public String getTime() {
		return "Invoked at: "+LocalDateTime.now();
	}

}
