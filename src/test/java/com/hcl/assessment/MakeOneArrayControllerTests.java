package com.hcl.assessment;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

	private String jsonRequest = "{" + "\"array1\":[1,2,3,4]," + "\"array2\":[3,4,5,6]," + "\"array3\":[6,1,3,11]" +"}";
	private String oneEmptyArray = "{" + "\"array1\":[1,2,3,4]," + "\"array2\":[]," + "\"array3\":[6,1,3,11]" +"}";
	
	private String jsonResponse = "{" + "\"array\":[1,2,3,4,5,6,11]" +"}";
	private String oneEmptyArrayResponse = "{" + "\"array\":[1,2,3,4,6,11]" +"}";
	
	@Test
    public void testMakeOneArrayApi() throws Exception {
       mockMvc
            .perform(post("/api/makeonearray").contentType(APPLICATION_JSON_UTF8).content(jsonRequest))
            .andExpect(status().is(200)).andExpect(content().json(jsonResponse));

	}
	
	@Test
    public void testWithOneEmptyArray() throws Exception {
       mockMvc
            .perform(post("/api/makeonearray").contentType(APPLICATION_JSON_UTF8).content(oneEmptyArray))
            .andExpect(status().is(200)).andExpect(content().json(oneEmptyArrayResponse));

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
	
	
}
