package com.nimro.N1ERP.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(value = "test")
public class TestController {
	
	@GetMapping(value = "Hello")
	public String helloWorld() {
		return "Hello world!";
	}

}
