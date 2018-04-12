package com.hcl.assessment.controller.utils;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public static String createAndSortAllArrays(MultipleListArray multipleArrayList){
		List<Integer> result = new ArrayList<>();
		MakeOneArrayResponse response = new MakeOneArrayResponse();
		
		
		//size will now give total size of combined array
		Integer[] oneArray = new Integer[getCombinedSize(multipleArrayList)];
		
		//form the result array without duplicates.
		for(Integer n:combineAllArrays(oneArray, multipleArrayList)){
			if(!result.contains(n)){//check to avoid duplicates
				result.add(n);
			}
			
		}
		Collections.sort(result);//sort the array in ascending order
		
		response.setArray(result.toArray(new Integer[result.size()]));
		
		return "{" + "\"Array\": "+Arrays.deepToString(response.getArray())+"}";
		
	}
	
	/**
	 * This method will check and compute size of all arrays to form a combined one.
	 * @param multipleArrayList
	 * @return
	 */
	private static int getCombinedSize(MultipleListArray multipleArrayList){
		int size = 0;
		//Check for all arrays upto 10.
		if(null!=multipleArrayList.getArray1()){
			size = size + multipleArrayList.getArray1().length;
		}
		if(null!=multipleArrayList.getArray2()){
			size = size + multipleArrayList.getArray2().length;
		}
		if(null!=multipleArrayList.getArray3()){
			size = size + multipleArrayList.getArray3().length;
		}
		if(null!=multipleArrayList.getArray4()){
			size = size + multipleArrayList.getArray4().length;
		}
		if(null!=multipleArrayList.getArray5()){
			size = size + multipleArrayList.getArray5().length;
		}
		if(null!=multipleArrayList.getArray6()){
			size = size + multipleArrayList.getArray6().length;
		}
		if(null!=multipleArrayList.getArray7()){
			size = size + multipleArrayList.getArray7().length;
		}
		if(null!=multipleArrayList.getArray8()){
			size = size + multipleArrayList.getArray8().length;
		}
		if(null!=multipleArrayList.getArray9()){
			size = size + multipleArrayList.getArray9().length;
		}
		if(null!=multipleArrayList.getArray10()){
			size = size + multipleArrayList.getArray10().length;
		}
		
		return size;
	}
	
	/**
	 * This method will combine all arrays to form one array.
	 * @param oneArray
	 * @param multiArrays
	 * @return
	 */
	private static Integer[] combineAllArrays(Integer[] oneArray, MultipleListArray multipleArrayList){
		//Combine all arrays into oneArray
		int position = 0;
		//Check for array 1
		if(null!=multipleArrayList.getArray1()){
			System.arraycopy(multipleArrayList.getArray1(), 0, oneArray, position, multipleArrayList.getArray1().length);
			position = multipleArrayList.getArray1().length;
		}
		//Check for array 2
		if(null!=multipleArrayList.getArray2()){
			System.arraycopy(multipleArrayList.getArray2(), 0, oneArray, position, multipleArrayList.getArray2().length);
			position = position + multipleArrayList.getArray2().length;
		}
		//Check for array 3
				if(null!=multipleArrayList.getArray3()){
					System.arraycopy(multipleArrayList.getArray3(), 0, oneArray, 
							position, multipleArrayList.getArray3().length);
					position = position + multipleArrayList.getArray3().length;
				}
				
				
				//Check for array 4
				if(null!=multipleArrayList.getArray4()){
					System.arraycopy(multipleArrayList.getArray4(), 0, oneArray, position,
							multipleArrayList.getArray4().length);
					position = position + multipleArrayList.getArray4().length;
				}
				//Check for array 5
				if(null!=multipleArrayList.getArray5()){
					System.arraycopy(multipleArrayList.getArray5(), 0, oneArray, position,
							multipleArrayList.getArray5().length);
					position = position + multipleArrayList.getArray5().length;
				}
				//Check for array 6
				if(null!=multipleArrayList.getArray6()){
					System.arraycopy(multipleArrayList.getArray6(), 0, oneArray, position,
						multipleArrayList.getArray6().length);
					position = position + multipleArrayList.getArray6().length;
				}
				
				//Check for array 7
				if(null!=multipleArrayList.getArray7()){
					System.arraycopy(multipleArrayList.getArray7(), 0, oneArray, position,
							multipleArrayList.getArray7().length);
					position = position + multipleArrayList.getArray7().length;
				}
				
				//Check for array 8
				if(null!=multipleArrayList.getArray8()){
					System.arraycopy(multipleArrayList.getArray8(), 0, oneArray, position,
						multipleArrayList.getArray8().length);
					position = position + multipleArrayList.getArray8().length;
				}
				
				//Check for array 9
				if(null!=multipleArrayList.getArray9()){
					System.arraycopy(multipleArrayList.getArray9(), 0, oneArray, position,
						multipleArrayList.getArray9().length);
					position = position + multipleArrayList.getArray9().length;
				}
				
				//Check for array 10
				if(null!=multipleArrayList.getArray10()){
					System.arraycopy(multipleArrayList.getArray10(), 0, oneArray, position,
						multipleArrayList.getArray10().length);
				}
				
				return oneArray;
	}
	
}
