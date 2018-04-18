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
	private static org.slf4j.Marker marker;
	public static final String EQUILATERAL = "Equilateral";
	public static final String ISOSCELES = "Isosceles";
	public static final String SCALENE = "Scalene";
	public static final String NOT_A_TRIANGLE = "Not a triangle";
	public static final String TRIANGLE_TYPE = "findTriangleType(): Triangle type is: {}";
	
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
		LOGGER.info(marker, "IN: findTriangleType() {}","");
		
		if(a>=(b+c) || c>=(b+a) || b>=(a+c)){//if one side is less than sum of other two sides
			LOGGER.debug(marker, "findTriangleType(): Given sides do not form a triangle {}","");
			return NOT_A_TRIANGLE;
		}else if(a==b && b==c){//all sides are equal
			LOGGER.debug(marker, TRIANGLE_TYPE, EQUILATERAL);
			return EQUILATERAL;
		}
        else if((a==b)||(b==c)||(c==a)){//two sides are equal
        	LOGGER.debug(marker, TRIANGLE_TYPE, ISOSCELES);
            return ISOSCELES;
        }   
        else if(a!=b && b!=c && c!=a){//none of the sides are equal
        	LOGGER.debug(marker, TRIANGLE_TYPE, SCALENE);
            return SCALENE;
        }
        
		return NOT_A_TRIANGLE;
	}

}
