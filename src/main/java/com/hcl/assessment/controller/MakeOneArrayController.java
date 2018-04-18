package com.hcl.assessment.controller;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.assessment.controller.utils.MakeOneArrayUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller class for MakrOneArray api. It will expose a post api to accept arrays of numbers. 
 * In response, all arrays will be combined and resultant array will be sorted with all 
 * array values (without duplicates).
 * @author kanika.sharma
 *
 */
@Api(value="MakeOneArray")
@RestController
public class MakeOneArrayController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MakeOneArrayController.class);
	private static org.slf4j.Marker marker;	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),                        
            Charset.forName("utf8")                     
            );
	
	@ApiOperation(value = "Accepts JSON objects with multiple number arrays. Combine these arrays, removes duplicate numbers and sorts them. Response is JSON object which contains this combined sorted array.",
				notes="Combine, remove duplicate and sort all input arrays in request JSON object.", response = String.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "OK")
	}
	)
	@PostMapping("/api/makeonearray")
	public ResponseEntity<Object> makeOneArray(@RequestBody Map<String, List<Integer>> multipleList){
		LOGGER.info(marker, "IN: MakeOneArray Controller {}","");
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.contentType(APPLICATION_JSON_UTF8)
				.body(MakeOneArrayUtils.createAndSortAllArrays(multipleList));
	}
	
}

