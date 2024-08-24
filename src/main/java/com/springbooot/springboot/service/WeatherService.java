package com.springbooot.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
@Service
public class WeatherService{

	//Before Using it we have to configure its bean in class or main class.
	@Autowired
	private RestTemplate restTemp;
	
	@Autowired
	private Weather weather;
	
	@Value("${weather.api.key}")
	private static String key;
	
	private static String url = "https://api.tomorrow.io/v4/weather/forecast?location=42.3478,-71.0466&apikey=odeAVDwUaWvmVsULhdyHIff2JJ5aJ6nD";

	public ResponseEntity<Weather> getW(){
		
		System.out.println(url);
		System.out.println("hyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		
		// Create headers (if needed)
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        // Create an HttpEntity object with headers (if needed)
        HttpEntity<String> entity = new HttpEntity<>(headers);
        HttpEntity<Weather> body = new HttpEntity<>(weather);

        
		ResponseEntity<Weather> response = restTemp.exchange(
                url,
                HttpMethod.GET,   // HTTP method
                body,           // Request entity(headers/body)
                Weather.class      // Response type
        );
		
		return response;
	}

}
*/