package com.hcl.assessment.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.assessment.controller.utils.MakeOneArrayUtils;
import com.hcl.assessment.model.MultipleListArray;

@RestController
public class MakeOneArrayController {
	
	
	@PostMapping("/api/makeonearray")
	public ResponseEntity<Object> makeOneArray(@RequestBody MultipleListArray multipleList){
		
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(MakeOneArrayUtils.createAndSortAllArrays(multipleList));
	}
	
	
}

