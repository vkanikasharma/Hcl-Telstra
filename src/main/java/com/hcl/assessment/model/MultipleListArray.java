package com.hcl.assessment.model;
/**
 * Model class received as request for MakeOneArray api. 
 * @author kanika.sharma
 *
 */
public class MultipleListArray {
	
	private Integer[] array1;//first array
	private Integer[] array2;//second array
	private Integer[] array3;//third array
	
	
	/**
	 * default constructor
	 */
	public MultipleListArray() {
		super(); 
	}



	/**
	 * @return the array1
	 */
	public Integer[] getArray1() {
		return array1;
	}



	/**
	 * @param array1 the array1 to set
	 */
	public void setArray1(Integer[] array1) {
		this.array1 = array1;
	}

	
	/**
	 * @return the array2
	 */
	public Integer[] getArray2() {
		return array2;
	}



	/**
	 * @param array2 the array2 to set
	 */
	public void setArray2(Integer[] array2) {
		this.array2 = array2;
	}



	/**
	 * @return the array3
	 */
	public Integer[] getArray3() {
		return array3;
	}



	/**
	 * @param array3 the array3 to set
	 */
	public void setArray3(Integer[] array3) {
		this.array3 = array3;
	}

	
}
