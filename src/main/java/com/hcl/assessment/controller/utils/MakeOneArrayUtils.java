package com.hcl.assessment.controller.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to combine multiple arrays and return one array as response.
 * The returned array will be sorted (ascending order and will not contain any duplicates).
 * @author kanika.sharma
 *
 */
public class MakeOneArrayUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(MakeOneArrayUtils.class);
	/**
	 * private constructor
	 */
	private MakeOneArrayUtils(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method takes map of multiple arrays as input and returns combined array.
	 * @param multipleArrayList
	 * @return
	 */
	
	public static String createAndSortAllArrays(Map<String, List<Integer>> multipleArrayList){
		LOGGER.info("Inside createAndSortAllArrays()");
		List<Integer> result = new ArrayList<>();
	
		//form the result array without duplicates.
		for(List<Integer> list: multipleArrayList.values()){
			for(Integer i: list){
				if(!result.contains(i)){//check to avoid duplicates
					result.add(i);
				}
			}
		}
		Collections.sort(result);//sort the array in ascending order
		String response = "{" + "\"Array\": "+Arrays.deepToString(result.toArray(new Integer[result.size()]))+"}";
		LOGGER.debug("MakeOneArray response: "+response);
		
		return response;
		
	}
	
}
