package com.hcl.assessment.controller;

import java.util.Objects;

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
import com.hcl.assessment.controller.utils.ReverseWordsUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * This class will expose a get api which will take a sentence as input.
 * In response, it will return the sentence with all words in reverse.
 * @author kanika.sharma
 *
 */
@Api(value="ReverseWords")
@RestController
public class ReverseWordsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReverseWordsController.class);
	private static org.slf4j.Marker marker;	
	@ApiOperation(value = "Reverses the letters of each word in a sentence.", notes="Reverses the letters of each word in a sentence.", response = String.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 400, message = "Invalid Input: Either null or empty string")
	}
	)
	@GetMapping("/api/ReverseWords")
	public ResponseEntity<Object> getReversedWords(@RequestParam String sentence){
		LOGGER.info(marker, "IN: ReverseWords Controller {}","");
		if(Objects.isNull(sentence) || sentence.length()==0){
			LOGGER.error(ErrorMessages.REVERSE_WORDS_ERROR_EMPTY);
			throw new InvalidInputException(ErrorMessages.REVERSE_WORDS_ERROR_EMPTY);
			
		}
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(ReverseWordsUtils.reverseWords(sentence));
	}
	
	

}
