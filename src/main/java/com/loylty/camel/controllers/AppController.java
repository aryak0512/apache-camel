package com.loylty.camel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable String name) {
		return "Hello! "+name;
	}

}
