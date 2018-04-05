package com.hcl.assessment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void testNthSequence() throws Exception {
       mockMvc
            .perform(get("/api/Fibonacci").param("n", "10"))
            .andExpect(status().isOk())
            .andExpect(content().json("34"));

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
	

}
