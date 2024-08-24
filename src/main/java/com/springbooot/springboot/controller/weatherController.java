/*package com.springbooot.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbooot.springboot.entity.Weather;
import com.springbooot.springboot.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class weatherController{

	@Autowired
	private WeatherService wService;
	
	@GetMapping("/get-w")
	public ResponseEntity<ResponseEntity<Weather>> getWeather(){
		
		ResponseEntity res = wService.getW();
		System.out.println(res.getBody());
		
		return new ResponseEntity<ResponseEntity<Weather>>(res, HttpStatus.OK);
	}
	
}
*/