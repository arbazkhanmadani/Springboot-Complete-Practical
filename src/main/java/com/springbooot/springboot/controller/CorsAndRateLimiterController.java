package com.springbooot.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbooot.springboot.service.CustomRateLimiterService;


@RestController
@RequestMapping("/cors-rate")
public class CorsAndRateLimiterController{


    @Autowired
    private CustomRateLimiterService customRateLimiterService;

    
	 //Controller Level CORS...........................
	 @CrossOrigin(origins = {"http://localhost:8080/"})
	 @GetMapping("/cors-local")
	 public ResponseEntity<String> corsLocal(){
	        
		 return new ResponseEntity<String>("Cors data..........",HttpStatus.OK);
	 }
	
	 //Global Level CORS...........................
	 @GetMapping("/cors-global")
	 public  ResponseEntity<String> getGlobal(){
	        
		 return new ResponseEntity<String>("Cors data..........",HttpStatus.OK);
	 }


	 //Rate Limiter...........................
	 @GetMapping("/rate-limit")
	 public ResponseEntity<String> rateLimit(){
	        
		 String key = "rate-limit-key"; // Use a dynamic key if needed
	     int limit = 5; // Number of allowed requests
	     int durationInMillis = 60000; // Duration of rate limit in milliseconds (e.g., 1 minute)

	     if(customRateLimiterService.isRateLimitExceeded(key, limit, durationInMillis)) 
	      	 return new ResponseEntity<String>("Rate limit exceeded. Please try again later.",HttpStatus.TOO_MANY_REQUESTS);
	     
	    return new ResponseEntity<String>("Request successful!", HttpStatus.OK);
	    
	 }

}
