package com.loylty.camel.beans;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SplitterBean {
	
	public List<String> splitMessage(String body){
		return Arrays.asList(body.split(","));
	}

}
