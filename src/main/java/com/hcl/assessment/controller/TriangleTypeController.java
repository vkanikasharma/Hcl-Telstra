package com.hcl.assessment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.assessment.controller.exception.ErrorMessages;
import com.hcl.assessment.controller.exception.InvalidInputException;
import com.hcl.assessment.controller.utils.TriangleTypesUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * This class will expose a get api which will take sides of a triangle as input.
 * In response, based on the length of sides, type of triangle will be returned.
 * @author kanika.sharma
 *
 */
@Api(value="TriangleTypes")
@RestController
public class TriangleTypeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TriangleTypeController.class);
	private static org.slf4j.Marker marker;	
	@ApiOperation(value = "Returns the type of triangle given the lengths of its sides.", notes="Returns the type of triangle given the lengths of its sides", response = String.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 400, message = "Invalid Input: Please pass numeric value to get proper result.")
	}
	)
	@GetMapping("/api/TriangleType")
	public ResponseEntity<Object> getTriangleType(@RequestParam Object a, @RequestParam Object b, @RequestParam Object c){
		LOGGER.info(marker, "IN: TriangleType Controller {}","");
		try{
			//Casting Object into Long to check input
			Integer inputA = new Integer(a.toString());//side a
			Integer inputB = new Integer(b.toString());//side b
			Integer inputC = new Integer(c.toString());//side c
			
			if(inputA<0 ||
					inputB<0 ||
					inputC<0){//check for null and negative values.
				LOGGER.error(ErrorMessages.INPUT_ERROR_NEGATIVE);
				throw new InvalidInputException(ErrorMessages.INPUT_ERROR_NEGATIVE);
				
			}
		}catch(NumberFormatException nfe){
			LOGGER.error(nfe.getMessage(),  nfe);
			throw new InvalidInputException(ErrorMessages.INPUT_ERROR_NON_NUMERIC);
		}
		
		
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(TriangleTypesUtils.findTriangleType(new Integer(a.toString()), new Integer(b.toString()), new Integer(c.toString())));
	}
	

}
