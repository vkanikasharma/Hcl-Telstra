package com.hcl.assessment.controller;

import java.nio.charset.Charset;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.assessment.controller.utils.MakeOneArrayUtils;
import com.hcl.assessment.model.MultipleListArray;

/**
 * Controller class for MakrOneArray api. It will expose a post api to accept arrays of numbers. 
 * In response, all arrays will be combined and resultant array will be sorted with all 
 * array values (without duplicates).
 * @author kanika.sharma
 *
 */
@RestController
public class MakeOneArrayController {
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),                        
            Charset.forName("utf8")                     
            );
	
	@PostMapping("/api/makeonearray")
	public ResponseEntity<Object> makeOneArray(@RequestBody MultipleListArray multipleList){
		
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.contentType(APPLICATION_JSON_UTF8)
				.body(MakeOneArrayUtils.createAndSortAllArrays(multipleList));
	}
	
}

