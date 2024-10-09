package com.practice.regex;

import java.util.regex.Pattern;

public class DuplicateWords {

	/**
	 * \\b for word boundary, make sure the start of a word
	 * (\\w+) this captures a word and puts it into a group, equivalent to [a-zA-Z0-9_]
	 * (?: ... ) this is a non capturing group, 
	 *           it groups the enclosed pattern but does not create a back-reference for it
	 * \\W+ this captures non-word and puts,  equivalent to [^a-zA-Z0-9_]
	 * \\1 This is a backreference to the first captured group (the word captured by (\\w+)). 
	 *     It ensures that the same word is matched again.
	 * (?: ... \\b) Another word boundary to ensure that the repeated word ends correctly.
	 * + This quantifier ensures that the non-capturing group (?:\\W+\\1\\b) can be repeated 
	 *   one or more times.
	 *   It allows for multiple repetitions of the same word with non-word characters in between.
	 */
	private static String DUPLICATE_WORD_REGEX = "\\b(\\w+)(?:\\W+\\1\\b)+";
	
	public static void main(String[] args) {
		
		java.util.regex.Pattern p = Pattern.compile(DUPLICATE_WORD_REGEX, Pattern.CASE_INSENSITIVE);
		java.util.regex.Matcher m;
		
		String str = "hello Hello world, how do do you do.";
		m = p.matcher(str);
		while(m.find()) {
			System.out.printf("Group:%s, Group[1]:%s\n",m.group(),m.group(1));
			str = str.replaceAll(m.group(), m.group(1));
		}
		
		System.out.println(str);
	}
}
