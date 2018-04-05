package com.hcl.assessment.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.assessment.controller.exception.InvalidInputException;
import com.hcl.assessment.controller.utils.TriangleTypesUtils;

@RestController
public class TriangleTypeController {
	
	@GetMapping("/api/TriangleType")
	public ResponseEntity<Object> getTriangleType(@RequestParam int a, @RequestParam int b, @RequestParam int c){
		
		if(a<0 || b<0 || c<0){//check for negative values.
			throw new InvalidInputException("Invalid input: One or more inputs are negative");
			
		}
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(TriangleTypesUtils.findTriangleType(a, b, c));
	}
	

}
