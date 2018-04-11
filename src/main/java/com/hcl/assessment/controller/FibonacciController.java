package com.hcl.assessment.controller;

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
	public ResponseEntity<Object> getNthFibonacciSequence(@RequestParam Object n){
		try{
			//Casting Object into Long to check input
			Long input = new Long(n.toString());
			if(input<=0){//check for negative values.
				throw new InvalidInputException("Invalid Input: Input either zero or negative.Please pass numeric value to get proper result");
				
			}
		}catch(NumberFormatException nfe){
			throw new InvalidInputException("Invalid Input: Please pass numeric value to get proper result.");
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(FibonacciSequenceUtils.claculateNthSequence((new Long(n.toString()))));
	}
	
	

}
