/**
 * 
 */
package com.hcl.assessment.controller.exception;

/**
 * Class for error messages stored as constants.
 * @author kanika.sharma
 *
 */
public class ErrorMessages {
	
	/**
	 * private constructor
	 */
	private ErrorMessages(){
		throw new UnsupportedOperationException();
	}
	
	public static final String FIBONACCI_ERROR_ZERO_NEGATIVE = "Invalid Input: Input either zero or negative.Please pass numeric value to get proper result.";
	public static final String INPUT_ERROR_NON_NUMERIC = "Invalid Input: Please pass numeric value to get proper result.";
	public static final String INPUT_ERROR_NEGATIVE = "Invalid Input: Input negative.Please pass numeric value to get proper result.";
	public static final String REVERSE_WORDS_ERROR_EMPTY = "Invalid Input: Either null or empty string.";

}
