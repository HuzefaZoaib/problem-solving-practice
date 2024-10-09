package com.practice.regex;

public class ReplaceDuplicateWord {

	public static void main(String[] args) {
		
		String s = "I am a good for good good boy boy.";
		System.out.printf("String:%s, Corrected:%s \n", s, correctedAfterRemovingImmidiateDuplicate(s));
	}
	
	static String correctedAfterRemovingImmidiateDuplicate(String s) {
		
		String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
		java.util.regex.Matcher m = p.matcher(s);
		
		while(m.find()) {
			// group contains the original string.
			//System.out.println(m.group(1));
			//System.out.println(m.group());
			System.out.printf("m.group():%s m.group(1):%s \n", m.group(0), m.group(1));
			s = s.replaceAll(m.group(), m.group(1)); // part of the string where regex matched
		}
		
		return s;
	}
}
