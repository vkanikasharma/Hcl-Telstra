package com.hcl.assessment.model;
/**
 * Model class sent as response for MakeOneArray API.
 * @author kanika.sharma
 *
 */
public class MakeOneArrayResponse {
	//name of output array
	Integer[] Array;

	/**
	 * @return the array
	 */
	public Integer[] getArray() {
		return Array;
	}

	/**
	 * @param array the array to set
	 */
	public void setArray(Integer[] array) {
		Array = array;
	}
	

}
