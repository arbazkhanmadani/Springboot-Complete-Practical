package com.springboot.springboot.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler{

	
	//404 Handler
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String noHandlerFoundExceptionHandler(NoHandlerFoundException e){
	
		return "STATUS_COD=404 / ERROR=NOT_FOUNT";
	}
	
	//Rate Limiter Handler
	@ExceptionHandler(RateLimitExceededException.class)
	@ResponseBody
	public ResponseEntity<String> handleRateLimitExceeded(RateLimitExceededException ex) {
	     
		return new ResponseEntity<>("Rate limit exceeded. Please try again later.", HttpStatus.TOO_MANY_REQUESTS);
	}
}
