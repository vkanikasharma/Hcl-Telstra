package com.hcl.assessment.controller;

import java.util.Objects;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.assessment.controller.exception.InvalidInputException;
import com.hcl.assessment.controller.utils.FibonacciSequenceUtils;

/**
 * Controller to test nth sequence in Fibonacci series. 
 * @author kanika.sharma
 *
 */
@RestController
public class FibonacciController {
	
	
	@GetMapping("/api/Fibonacci")
	public ResponseEntity<Object> getNthFibonacciSequence(@RequestParam Long n){
		
		if(Objects.isNull(n) || n<0){//check for null and negative values.
			throw new InvalidInputException();
			
		}
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(FibonacciSequenceUtils.claculateNthSequence(n));
	}
	
	

}
