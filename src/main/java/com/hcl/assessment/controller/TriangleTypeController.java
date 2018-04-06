package com.hcl.assessment.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.assessment.controller.exception.InvalidInputException;
import com.hcl.assessment.controller.utils.TriangleTypesUtils;
/**
 * This class will expose a get api which will take sides of a triangle as input.
 * In response, based on the length of sides, type of triangle will be returned.
 * @author kanika.sharma
 *
 */
@RestController
public class TriangleTypeController {
	
	@GetMapping("/api/TriangleType")
	public ResponseEntity<Object> getTriangleType(@RequestParam Object a, @RequestParam Object b, @RequestParam Object c){
		
		try{
			//Casting Object into Long to check input
			Integer inputA = new Integer(a.toString());//side a
			Integer inputB = new Integer(b.toString());//side b
			Integer inputC = new Integer(c.toString());//side c
			
			if(inputA<0 ||
					inputB<0 ||
					inputC<0){//check for null and negative values.
				throw new InvalidInputException("Invalid Input: Input negative.Please pass numeric value to get proper result");
				
			}
		}catch(NumberFormatException nfe){
			throw new InvalidInputException("Invalid Input: Please pass numeric value to get proper result.");
		}
		
		
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(TriangleTypesUtils.findTriangleType(new Integer(a.toString()), new Integer(b.toString()), new Integer(c.toString())));
	}
	

}
