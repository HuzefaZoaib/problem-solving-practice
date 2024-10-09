package com.practice;

import java.util.Arrays;
import java.util.HashMap;

public class CheckingStringAsKeyInMap {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String,String>();
		
		map.put(processKey("AB"), "A1");
		map.put(processKey("BA"), "A2");
		
		System.out.println(map.entrySet());
		
		System.out.println(processKey("AB") == processKey("BB"));
		
		/**
		 * result is [AB=A2]
		 * Only one element got stored, the last one. 
		 * 
		 * Even if they were two objects, as in String str = new String("a"), str2 = new String("a") 
		 * the hashCodes would still be the same because for equal objects their hashcodes must match — 
		 * that's the essential property of a hashcode.
		 */
	}
	
	static String processKey(String key) {
		
		char[] c = key.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
