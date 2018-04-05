package com.hcl.assessment.controller.utils;

import java.util.regex.Pattern;

/**
 * This class will provide method to reverse the words in a given sentence. 
 * @author kanika.sharma
 *
 */
public class ReverseWordsUtils {
	
	public static final String SPACE = " ";
	
	/**
	 * This method will take a sentence as in[ut and reverse all the words in the sentence.
	 * @param sentence
	 * @return
	 */
	public static String reverseWords(String sentence){
		StringBuffer reversedSentence = new StringBuffer();
		Pattern pattern = Pattern.compile("\\s");
		
		if(sentence!=null && sentence.length()>0){//check for null and empty
			String[] words = pattern.split(sentence);
			
			for(String word: words){
				reversedSentence.append((new StringBuilder(word)).reverse().toString())
				.append(SPACE);
			}
		}
		
		return reversedSentence.toString().trim();
	}
	
}
