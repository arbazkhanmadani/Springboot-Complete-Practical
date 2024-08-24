package com.springbooot.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbooot.springboot.model.UserRepository;

/**
 	JUnit-5 -> Architecture
 	Plateform -> where testcases runs.
 	Vintage -> gives compatibility with previous versions.
 	Jupitor -> gives new api and fetures.
 	Api -> gives support of test apis.
 */
//For starting application context
@SpringBootTest
public class UserServiceTests{

	@Autowired
	private UserRepository userRepository;
	
	/**
	 *1.BeforeEach()    -> Runs before all test case no. of tc = no. times run
	 *2.BeforeAll()     -> Runs before all test case only once. method should be STATIC
	 *3.AfterEach()     -> Runs after all test case.
	 *4.AfterAll()      -> Runs after all test case only once. method should be STATIC
	 *5.DisplayName()   -> Custom TestCase name
	 *6.RepeatedTest(5) -> number of times repeat.
	 *7.Timeout()       -> value=2,unit=TimeUnit.SECONDS, stops after 2 second. 
	 *8.TestMethodOrderer(MethodOrderer.OrderAnnotaion.clss) -> Used at class level
	 *  order(1) -> used with all methods by no. 1,2,3(priorities).
	 **/
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"1,2,4",
		"5,4,9",
	})
	public void testAdd(int a, int b , int expected){
		
		assertEquals(expected, a+b);
		assertEquals(expected, a+b);
		
	}
	
	@Disabled //-> if not want to run.
	@Test
	@ValueSource(strings={"arbaz","null"})
	public void testTetUserByName(){
		
		//boolean
		//assertTrue(2>8);
		//equality
		//assertEquals(2,4);
		//NotNull checking - assertNotNull
		//Null Checking
		assertNull(userRepository.getUserByUname("ron"));
	}

	
}
