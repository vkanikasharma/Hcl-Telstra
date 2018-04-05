package com.hcl.assessment.controller;

import java.util.Objects;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.assessment.controller.exception.InvalidInputException;
import com.hcl.assessment.controller.utils.ReverseWordsUtils;

@RestController
public class ReverseWordsController {
	
	
	@GetMapping("/api/ReverseWords")
	public ResponseEntity<Object> getReversedWords(@RequestParam String sentence){
		
		if(Objects.isNull(sentence) || sentence.length()==0){
			throw new InvalidInputException("Invalid Input: Either Null or empty string");
			
		}
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(ReverseWordsUtils.reverseWords(sentence));
	}
	
	

}
