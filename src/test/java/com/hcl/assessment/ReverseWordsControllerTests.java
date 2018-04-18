package com.hcl.assessment;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

import com.hcl.assessment.controller.ReverseWordsController;
import com.hcl.assessment.controller.utils.ReverseWordsUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ReverseWordsControllerTests {
	@LocalServerPort
    private int port;
	
@Autowired private MockMvc mockMvc;
	
	private String sentence = "how are you?";
	private String mockResponse = "woh era uoy?";
	
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
      public void testSpecialCharacters() throws Exception {
          mockMvc
               .perform(get("/api/ReverseWords").param("sentence", "Hello! Is all well?"))
               .andExpect(status().isOk())
               .andExpect(content().string("olleH! sI lla llew?"));  
	}
	
	@Test
    public void testInvalidInput() throws Exception {
       mockMvc
       .perform(get("/api/ReverseWords").param("sentence", ""))
            .andExpect(status().is(400));

	}
	
	@Test
	public//
	void privateConstructorTest()  {
	    final Constructor<?>[] constructors = ReverseWordsUtils.class.getDeclaredConstructors();
	    // check that all constructors are 'private':
	    for (final Constructor<?> constructor : constructors) {
	        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
	    }        
	    // call the private constructor:
	    constructors[0].setAccessible(true);
	    try {
			constructors[0].newInstance((Object[]) null);
		} catch (InstantiationException e) {
			
		} catch (IllegalAccessException e) {
			
		} catch (IllegalArgumentException e) {
			
		} catch (InvocationTargetException e) {
			
		} catch(UnsupportedOperationException e){
		
		}
	    
	}

}
