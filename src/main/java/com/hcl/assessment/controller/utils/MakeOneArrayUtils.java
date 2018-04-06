package com.hcl.assessment.controller.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hcl.assessment.model.MakeOneArrayResponse;
import com.hcl.assessment.model.MultipleListArray;
/**
 * Utility class to combine multiple arrays and return one array as response.
 * The returned array will be sorted (ascending order and will not contain any duplicates).
 * @author kanika.sharma
 *
 */
public class MakeOneArrayUtils {
	
	/**
	 * private constructor
	 */
	private MakeOneArrayUtils(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method takes Multiple arrays as input and returns combined array.
	 * @param multipleArrayList
	 * @return
	 */
	
	public static MakeOneArrayResponse createAndSortAllArrays(MultipleListArray multipleArrayList){
		int size = multipleArrayList.getArray1().length+multipleArrayList.getArray2().length+multipleArrayList.getArray3().length;
		List<Integer> result = new ArrayList<>();
		Integer[] oneArray = new Integer[size];
		MakeOneArrayResponse response = new MakeOneArrayResponse();
		
		//Combine all arrays into oneArray
		System.arraycopy(multipleArrayList.getArray1(), 0, oneArray, 0, multipleArrayList.getArray1().length);
		System.arraycopy(multipleArrayList.getArray2(), 0, oneArray, multipleArrayList.getArray1().length, multipleArrayList.getArray2().length);
		System.arraycopy(multipleArrayList.getArray3(), 0, oneArray, multipleArrayList.getArray1().length+multipleArrayList.getArray2().length, multipleArrayList.getArray3().length);
		
		for(Integer n:oneArray){
			if(!result.contains(n)){//check to avoid duplicates
				result.add(n);
			}
			
		}
		Collections.sort(result);//sort the array in ascending order
		
		response.setArray(result.toArray(new Integer[result.size()]));
		return response;
		
	}
	
	
}
