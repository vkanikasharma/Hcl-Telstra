package com.hcl.assessment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.assessment.controller.exception.InvalidInputException;
import com.hcl.assessment.controller.utils.FibonacciSequenceUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller to test nth sequence in Fibonacci series. 
 * @author kanika.sharma
 *
 */
@RestController
@Api(value="FibonacciSeries")
public class FibonacciController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciController.class);
	
	@ApiOperation(value = "Returns the nth sequence in Fibonacci series", notes="Operation to calculate the nth sequence in Fibonacci series", response = Integer.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved Fibonacci sequence"),
	        @ApiResponse(code = 400, message = "Invalid Input: Please pass numeric value to get proper result.")
	}
	)
	@GetMapping("/api/Fibonacci")
	public ResponseEntity<Object> getNthFibonacciSequence(@RequestParam Object n){
		try{
			//Casting Object into Long to check input
			Long input = new Long(n.toString());
			if(input<=0){//check for negative values.
				LOGGER.error("Invalid Input: Input either zero or negative.Please pass numeric value to get proper result");
				throw new InvalidInputException("Invalid Input: Input either zero or negative.Please pass numeric value to get proper result");
				
			}
		}catch(NumberFormatException nfe){
			LOGGER.error(nfe.getMessage());
			throw new InvalidInputException("Invalid Input: Please pass numeric value to get proper result.");
		}
		
		LOGGER.info("Input is ok, calculating Fibonacci sequence for: "+n.toString());
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(FibonacciSequenceUtils.claculateNthSequence((new Long(n.toString()))));
	}
	
	

}
