package com.hcl.assessment;

import static org.junit.Assert.assertTrue;
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

import com.hcl.assessment.controller.TriangleTypeController;
import com.hcl.assessment.controller.utils.TriangleTypesUtils;
import com.jayway.jsonpath.internal.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TriangleTypeControllerTests {
	@LocalServerPort
    private int port;
	
@Autowired private MockMvc mockMvc;
	
	private int a,b,c =1;
	
	@Autowired
	private TriangleTypeController controller;
	
	
	@Test
    public void testTriangleTypeApi() throws Exception {
       
		controller.getTriangleType(a, b, c)
		.getStatusCode().compareTo(HttpStatus.OK);
		
	}
	
	
	@Test
    public void testEquilateralTriangle() throws Exception {
       mockMvc
            .perform(get("/api/TriangleType").param("a", "1").param("b", "1").param("c", "1"))
            .andExpect(status().isOk())
            .andExpect(content().string(TriangleTypesUtils.EQUILATERAL));

	}
	
	@Test
    public void testIsoscelesTriangle() throws Exception {
       mockMvc
            .perform(get("/api/TriangleType").param("a", "2").param("b", "2").param("c", "1"))
            .andExpect(status().isOk())
            .andExpect(content().string(TriangleTypesUtils.ISOSCELES));

	}
	
	@Test
    public void testScaleneTriangle() throws Exception {
       mockMvc
            .perform(get("/api/TriangleType").param("a", "2").param("b", "3").param("c", "4"))
            .andExpect(status().isOk())
            .andExpect(content().string(TriangleTypesUtils.SCALENE));

	}
	
	@Test
    public void testNotATriangle() throws Exception {
       mockMvc
            .perform(get("/api/TriangleType").param("a", "7").param("b", "3").param("c", "3"))
            .andExpect(status().isOk())
            .andExpect(content().string(TriangleTypesUtils.NOT_A_TRIANGLE));

	}
	
	@Test
    public void testInvalidInput() throws Exception {
       mockMvc
            .perform(get("/api/TriangleType").param("a", "a").param("b", "b").param("c", "c"))
            .andExpect(status().is(400));

	}
	
	@Test
    public void testNegativeInputForA() throws Exception {
       mockMvc
            .perform(get("/api/TriangleType").param("a", "-1").param("b", "1").param("c", "2"))
            .andExpect(status().is(400));

	}
	
	@Test
    public void testNegativeInputForB() throws Exception {
       mockMvc
            .perform(get("/api/TriangleType").param("a", "2").param("b", "-1").param("c", "2"))
            .andExpect(status().is(400));

	}
	
	@Test
    public void testNegativeInputForC() throws Exception {
       mockMvc
            .perform(get("/api/TriangleType").param("a", "2").param("b", "1").param("c", "-2"))
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
