package com.springbooot.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/views-url")
public class ViewController{


	//@ResponseBody
	@GetMapping("/home")
	public String home(Model model){
	
		List name = new ArrayList();
		name.add("Arbaz");
		name.add("sarfaraz");
		
		boolean isAllowed = true;
		int age = 22;
		
		model.addAttribute("names", name);
		model.addAttribute("age", age);
		model.addAttribute("isAllow", isAllowed);
		
		return "home";
	}
	
	@GetMapping("/thymtest")
	public String thymeleaf(){
	
		System.out.println("thymeleaf..................");
		return "thymeleafTest";
	}
	
	@ResponseBody
	@GetMapping("/name")
	public String getName(){
	
		//int i = 10/0;
		return "hellooooooooooooo Arbaz Khan";
	}
	
	
	//Local Exception Handling.....
	//This exception will run for all method of this class when /0 happen.
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> throwLocalException(ArithmeticException e){
		
		return new ResponseEntity<String>("Exeption is coming  due to : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	
}
