package com.hcl.assessment.controller.utils;
/**
 * Utility class to find type of triangle.
 * @author kanika.sharma
 *
 */
public class TriangleTypesUtils {
	
	public static final String EQUILATERAL = "Equilateral";
	public static final String ISOSCELES = "Isosceles";
	public static final String SCALENE = "Scalene";
	public static final String NOT_A_TRIANGLE = "Not a triangle";
	
	/**
	 * private constructor
	 */
	private TriangleTypesUtils(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method finds the triangle type by comparing its sides.
	 * @param a
	 * @param b
	 * @param c
	 * @return type
	 */
	public static String findTriangleType(int a, int b, int c){
		
		if(a==b && b==c){//all sides are equal
			return EQUILATERAL;
		}else if(a>=(b+c) || c>=(b+a) || b>=(a+c)){//if one side is less than sum of other two sides
			return NOT_A_TRIANGLE;
		}
        else if ((a==b && b!=c) || (b==c && c!=a)){//two sides are equal
            return ISOSCELES;
        }   
        else if(a!=b && b!=c){//none of the sides are equal
            return SCALENE;
        }
        
		return NOT_A_TRIANGLE;
	}

}
