package com.hcl.assessment;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Constructor;
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

import com.hcl.assessment.model.MultipleListArray;
import com.jayway.jsonpath.internal.Utils;



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
	private String oneNullArray = "{" + "\"array1\":[1,2,3,4]," + "\"array3\":[6,1,3,11]" +"}";
	
	private String allArrays = "{" + "\"array1\":[1,2,3,4]," + "\"array2\":[3,4,5,6]," + "\"array3\":[6,1,3,11]," 
			+ "\"array4\":[9,8,7]," + "\"array5\":[11,10]," + "\"array6\":[50,35]," +  "\"array7\":[100,98]," + "\"array8\":[12]," +
			"\"array9\":[15,14]," + "\"array10\":[3,4,5,3,5,6]" +
			"}";
	
	private String jsonResponse = "{" + "\"array\":[1,2,3,4,5,6,11]" +"}";
	private String oneEmptyArrayResponse = "{" + "\"array\":[1,2,3,4,6,11]" +"}";
	
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
	public void testMultipleListArray(){
		MultipleListArray multiArray = new MultipleListArray();
		multiArray.setArray1(new Integer[]{1,2,3,4});
		multiArray.setArray2(new Integer[]{5,6,7});
		multiArray.setArray3(new Integer[]{9,10,11});
		
		assertNotNull(multiArray.getArray1());
		assertNotNull(multiArray.getArray2());
		assertNotNull(multiArray.getArray3());
		
		
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
