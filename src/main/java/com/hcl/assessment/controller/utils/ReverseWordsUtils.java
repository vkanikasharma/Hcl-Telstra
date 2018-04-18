package com.hcl.assessment.controller.utils;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class will provide method to reverse the words in a given sentence. 
 * @author kanika.sharma
 *
 */
public class ReverseWordsUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReverseWordsUtils.class);
	private static org.slf4j.Marker marker;
	public static final String SPACE = " ";
	
	/**
	 * private constructor
	 */
	private ReverseWordsUtils(){
		throw new UnsupportedOperationException();
	}
	
	/**  
	* This method will reverse words in a given string with maintaining 
	* special characters in place. 
	* @param sentence  
	* @return reversedSentence
	*/ 
	
	public static String reverseWords(String sentence) { 
		LOGGER.info(marker, "IN: reverseWords() {}",""); 	
		LOGGER.debug(marker, "reverseWords(): Reverse words of input: {}",sentence);
		
	    StringBuilder reversedSentence = new StringBuilder();
	    Deque<Character> deque = new ArrayDeque<>();//provides LIFO operations
	    for(int i=0; i<sentence.length();i++){
	        char c = sentence.charAt(i);
	        if(!isAlphabet(c)){//if not an alphabet
	             while(!deque.isEmpty()){
	            	 reversedSentence.append(deque.pop());//return the first element of deque
	             }
	             reversedSentence.append(c);
	            }else{
	            	deque.push(c);//push c to head of deque
	            }
	            }
	    		LOGGER.debug(marker, "reverseWords(): Output: {}",reversedSentence);
	            return reversedSentence.toString();
	}   
	
	/**
	 * Method to check whether a character is et or not.
	 * @param ch
	 * @return
	 */
	private static boolean isAlphabet(char ch){
		return ((ch >='a' && ch<='z') || (ch >='A' && ch <='Z'));
	}
	
}
