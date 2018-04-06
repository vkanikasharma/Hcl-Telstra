package com.hcl.assessment;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.assessment.controller.FibonacciController;
import com.hcl.assessment.controller.exception.InvalidInputException;
import com.jayway.jsonpath.internal.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FibonacciControllerTests {
	@LocalServerPort
    private int port;
	
@Autowired private MockMvc mockMvc;
	
	private long num = 10;
	
	@Autowired
	private FibonacciController controller;
	
	
	@Test
    public void testFibonacciApi() throws Exception {
       
		controller.getNthFibonacciSequence(num)
		.getStatusCode().compareTo(HttpStatus.OK);
		
	}
	
	@Test
    public void testFibonacciApiInvalid() throws Exception {
       try{
		controller.getNthFibonacciSequence(new String("abc"));
       }catch(InvalidInputException e){
    	   
       }
		
	}
	
	
	@Test
    public void testNthSequence() throws Exception {
       mockMvc
            .perform(get("/api/Fibonacci").param("n", "10"))
            .andExpect(status().isOk())
            .andExpect(content().json("55"));

	}
	
	@Test
    public void testInvalidInput() throws Exception {
       mockMvc
            .perform(get("/api/Fibonacci").param("n", "abc"))
            .andExpect(status().is(400));

	}
	
	@Test
    public void testNegativeInput() throws Exception {
       mockMvc
            .perform(get("/api/Fibonacci").param("n", "-1"))
            .andExpect(status().is(400));

	}
	
	@Test
    public void testInvalidInputObject() throws Exception {
       mockMvc
            .perform(get("/api/Fibonacci").param("n", new String("abc")))
            .andExpect(status().is(400));

	}
		
	@Test
	public//
	void privateConstructorTest() throws Exception {
	    final Constructor<?>[] constructors = Utils.class.getDeclaredConstructors();
	    // check that all constructors are 'private':
	    for (final Constructor<?> constructor : constructors) {
	        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
	    }        
	    // call the private constructor:
	    constructors[0].setAccessible(true);
	    constructors[0].newInstance((Object[]) null);
	}	

	
}
