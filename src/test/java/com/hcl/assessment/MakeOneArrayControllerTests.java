package com.hcl.assessment;


import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.assessment.controller.utils.MakeOneArrayUtils;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MakeOneArrayControllerTests {
	@LocalServerPort
    private int port;
	
@Autowired private MockMvc mockMvc;

public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
        MediaType.APPLICATION_JSON.getSubtype(),                        
        Charset.forName("utf8")                     
        );

	private String jsonRequest = "{" + "\"Array1\":[1,2,3,4]," + "\"Array2\":[3,4,5,6]," + "\"Array3\":[6,1,3,11]" +"}";
	private String oneEmptyArray = "{" + "\"Array1\":[1,2,3,4]," + "\"Array2\":[]," + "\"Array3\":[6,1,3,11]" +"}";
	private String oneNullArray = "{" + "\"Array1\":[1,2,3,4]," + "\"Array3\":[6,1,3,11]" +"}";
	
	private String allArrays = "{" + "\"Array1\":[1,2,3,4]," + "\"Array2\":[3,4,5,6]," + "\"Array3\":[6,1,3,11]," 
			+ "\"Array4\":[9,8,7]," + "\"Array5\":[11,10]," + "\"Array6\":[50,35]," +  "\"Array7\":[100,98]," + "\"Array8\":[12]," +
			"\"Array9\":[15,14]," + "\"Array10\":[3,4,5,3,5,6]" +
			"}";
	
	private String jsonResponse = "{" + "\"Array\": [1,2,3,4,5,6,11]" +"}";
	private String oneEmptyArrayResponse = "{" + "\"Array\": [1,2,3,4,6,11]" +"}";
	
	@Test
    public void testMakeOneArrayApi() throws Exception {
       mockMvc
            .perform(post("/api/makeonearray").contentType(APPLICATION_JSON_UTF8).content(jsonRequest))
            .andExpect(status().is(200)).andExpect(content().json(jsonResponse));

	}
	
	@Test
    public void testWithAllArrays() throws Exception {
       mockMvc
            .perform(post("/api/makeonearray").contentType(APPLICATION_JSON_UTF8).content(allArrays))
            .andExpect(status().is(200));

	}
	
	@Test
    public void testWithOneEmptyArray() throws Exception {
       mockMvc
            .perform(post("/api/makeonearray").contentType(APPLICATION_JSON_UTF8).content(oneEmptyArray))
            .andExpect(status().is(200)).andExpect(content().json(oneEmptyArrayResponse));

	}
	
	@Test
    public void testWithOneNullArray() throws Exception {
       mockMvc
            .perform(post("/api/makeonearray").contentType(APPLICATION_JSON_UTF8).content(oneNullArray))
            .andExpect(status().is(200));

	}
	
	@Test
    public void testWithNullArray() throws Exception {
       mockMvc
            .perform(post("/api/makeonearray").contentType(APPLICATION_JSON_UTF8).content(""))
            .andExpect(status().is(400));

	}
	
	@Test
    public void testInvalidInput() throws Exception {
       mockMvc
            .perform(post("/api/makeonearray").contentType(APPLICATION_JSON_UTF8).content("abc"))
            .andExpect(status().is(400));

	}
	
	
	@Test
	public//
	void privateConstructorTest() {
	    final Constructor<?>[] constructors = MakeOneArrayUtils.class.getDeclaredConstructors();
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
