package com.practice.regex;

import java.util.regex.Pattern;

public class TagContentExtractor {

	private static String TAG_OPENING_REGEX = "<(.+)>([^<]+)</\\1>";
	
	public static void main(String[] args) {
		
		java.util.regex.Pattern p = Pattern.compile(TAG_OPENING_REGEX);
		
		String str = "<h1>Hello</h1><h2>Hello H2</h2>";
		java.util.regex.Matcher m = p.matcher(str);
		
		while(m.find()) {
			System.out.println(m.groupCount());
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
			//System.out.println(m.group(3));
		}
		
		
	}

}
