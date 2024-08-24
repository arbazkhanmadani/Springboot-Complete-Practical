package com.springbooot.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

//1st way..........
@PropertySource("classpath:auth.properties")
@Service
//It can also be used instead of creating Logger's object.It comes with Lombok.
//Its reference variable is used by the name "log".
@Slf4j
public class LifeCycleMethodsDemonstration{

	//2nd way.....
	@Autowired
	private Environment env;
	
	@Value("${auth.pass}")
	private String password;
	

	//LifeCycleMethodsDemonstration.class -> specifying that class in which we've to apply Logger.
	//Can be used anywhere but Its only used in Exceptional code.
	//debug() & trace() by default is disabled.
	private static final Logger log = LoggerFactory.getLogger(LifeCycleMethodsDemonstration.class);
	
	@PostConstruct
	public void getPass(){
		
		try{
			log.warn("This is a warnng ony........");
			
			//1st
			System.out.println("pass1 : "+password);
			//int a = 10/0;
			
			//2nd
			this.password = env.getProperty("auth.pass");
			System.out.println("pass2 : "+password);
		}catch(Exception e){
			log.warn("This is a warnng ony........");
			log.trace("traching the problem");
			log.info("Due to this reason error wcan come.");
			log.debug("debugging is disabled");
			log.error("We got an error {}", "Arbaz Khan", e.getMessage());
		}
		
	}
	
	
	@PreDestroy
	public void desMethod(){
		System.out.println("inside pre destroyed........");
	}
}
