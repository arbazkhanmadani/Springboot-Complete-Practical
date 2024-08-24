package com.springbooot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
public class SpringbootApplication{

	public static void main(String[] args) {
		
		ConfigurableApplicationContext app =  SpringApplication.run(SpringbootApplication.class, args);
		Environment env = app.getEnvironment();
		System.out.println(env.getActiveProfiles()[0]);
		//for calling destroy method
		//app.close();
	}
	
	
	
	

}
