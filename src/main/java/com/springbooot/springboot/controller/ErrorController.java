package com.springbooot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/**")
public class ErrorController{


	//404 - ResouceNotFound Error Mapping.
	public String getError404Page(){
	
		return "404";
	}
	
}
