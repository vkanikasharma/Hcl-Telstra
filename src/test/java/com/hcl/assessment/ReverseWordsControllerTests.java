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

import com.hcl.assessment.controller.ReverseWordsController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ReverseWordsControllerTests {
	@LocalServerPort
    private int port;
	
@Autowired private MockMvc mockMvc;
	
	private String sentence = "how are you";
	private String mockResponse = "woh era uoy";
	
	@Autowired
	private ReverseWordsController controller;
	
	
	@Test
    public void testReverseWordsAPI() throws Exception {
       
		controller.getReversedWords(sentence)
		.getStatusCode().compareTo(HttpStatus.OK);
		
	}
	
	
	@Test
    public void testOutput() throws Exception {
       mockMvc
            .perform(get("/api/ReverseWords").param("sentence", sentence))
            .andExpect(status().isOk())
            .andExpect(content().string(mockResponse));

	}
	
	@Test
    public void testInvalidInput() throws Exception {
       mockMvc
       .perform(get("/api/ReverseWords").param("sentence", ""))
            .andExpect(status().is(400));

	}
	

}
