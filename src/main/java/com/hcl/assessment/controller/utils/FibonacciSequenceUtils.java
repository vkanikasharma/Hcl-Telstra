package com.hcl.assessment.controller.utils;

/**
 * This class will provide utility method to calculate the nth number in Fibonacci sequence.
 * @author kanika.sharma
 *
 */
public class FibonacciSequenceUtils {
	
	/**
	 * This method finds and returns the nth number in Fibonacci series. Its a
	 * recursive program.
	 * @param num
	 * @return 
	 */
	public static Long claculateNthSequence(Long num){
		if (num == 1)
			return 0l;
		if (num == 2)
			return 1l;
		/*
		 * Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21...
		 * Every number in the series is a sum of last 2 numbers (except 1 and 2).
		 */
		
		return claculateNthSequence(num - 1) + claculateNthSequence(num - 2);
		
	}
	
}
