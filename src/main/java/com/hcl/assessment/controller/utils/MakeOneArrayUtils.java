package com.hcl.assessment.controller.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hcl.assessment.model.MakeOneArrayResponse;
import com.hcl.assessment.model.MultipleListArray;

public class MakeOneArrayUtils {
	
	/**
	 * This method takes Multiple arrays as input and returns combined array.
	 * @param multipleArrayList
	 * @return
	 */
	
	public static MakeOneArrayResponse createAndSortAllArrays(MultipleListArray multipleArrayList){
		
		List<Integer> result = new ArrayList<Integer>();
		MakeOneArrayResponse response = new MakeOneArrayResponse();
		if(multipleArrayList!=null){
			for(Integer n: multipleArrayList.getArray1()){
				if(!result.contains(n)){//check to avoid duplicates
					result.add(n);
				}
			}
			
			for(Integer n: multipleArrayList.getArray2()){
				if(!result.contains(n)){//check to avoid duplicates
					result.add(n);
				}
			}
			for(Integer n: multipleArrayList.getArray3()){
				if(!result.contains(n)){//check to avoid duplicates
					result.add(n);
				}
			}
			
			Collections.sort(result);//sort the array in ascending order
			
			
			response.setArray(result.toArray(new Integer[result.size()]));
		}
		
		
		return response;
	}
	
	
}
