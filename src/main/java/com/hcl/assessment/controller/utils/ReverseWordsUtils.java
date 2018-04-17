package com.hcl.assessment.controller.utils;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class will provide method to reverse the words in a given sentence. 
 * @author kanika.sharma
 *
 */
public class ReverseWordsUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReverseWordsUtils.class);
	public static final String SPACE = " ";
	
	/**
	 * private constructor
	 */
	private ReverseWordsUtils(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method will take a sentence as input and reverse all the words in the sentence.
	 * @param sentence
	 * @return
	 */
	public static String reverseWords(String sentence){
		LOGGER.info("Inside reverseWords()");
		LOGGER.debug("Reverse words for sentence: "+sentence);
		StringBuilder reversedSentence = new StringBuilder();
		Pattern pattern = Pattern.compile("\\s");
		
		String[] words = pattern.split(sentence);
			
		for(String word: words){
			reversedSentence.append((new StringBuilder(word)).reverse().toString())
			.append(SPACE);
		}
		LOGGER.debug("Reverse words output: "+reversedSentence.toString().trim());
		return reversedSentence.toString().trim();
	}
	
}
