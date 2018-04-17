package com.hcl.assessment.controller.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to find type of triangle.
 * @author kanika.sharma
 *
 */

public class TriangleTypesUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(TriangleTypesUtils.class);
	public static enum TriangleType
	{
		Equilateral, Isosceles, Scalene ;
	}
	
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
		LOGGER.info("Inside findTriangleType()");
		LOGGER.debug("Find triangle type where a="+a+" ,b="+b+" and c="+c);
		if(a==b && b==c){//all sides are equal
			LOGGER.debug("Triangle type is: "+TriangleType.Equilateral.toString());
			return TriangleType.Equilateral.toString();
		}else if(a>=(b+c) || c>=(b+a) || b>=(a+c)){//if one side is less than sum of other two sides
			LOGGER.debug("Given sides do not form a triangle");
			return NOT_A_TRIANGLE;
		}
        else if ((a==b && b!=c) || (b==c && c!=a)){//two sides are equal
        	LOGGER.debug("Triangle type is: "+TriangleType.Isosceles.toString());
            return TriangleType.Isosceles.toString();
        }   
        else if(a!=b && b!=c){//none of the sides are equal
        	LOGGER.debug("Triangle type is: "+TriangleType.Scalene.toString());
            return TriangleType.Scalene.toString();
        }
        
		return NOT_A_TRIANGLE;
	}

}
