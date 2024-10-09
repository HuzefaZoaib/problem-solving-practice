package com.practice;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringLengthWithoutRepeatingCharacter {

	
	public static void main(String[] args) {
		
		String s = "abbca";
		solution(s);
		
		s = "abcabcbb";
		solution(s);
		
		s = "bbbb";
		solution(s);
		
		s = "";
		solution(s);
	}

	private static void solution(String s) {
		List<Character> visitedChars = new ArrayList<>();
		
		int longest=0,longestLeft=0,longestRight=0;
		int left=0,right=0;
		while(right < s.length()) {
			char righty = s.charAt(right);
			if(visitedChars.contains(righty)) {
				visitedChars.remove((Character)s.charAt(left));
				left++;
			} else {
				visitedChars.add(righty);
				right++;
				
				if( (right-left) > longest) {
					longest = right-left;
					longestLeft = left;
					longestRight = right;
				}
			}
		}

		System.out.println("Longest Substring: " + s.substring(longestLeft, longestRight));
		System.out.println("Length of Longest Substring: " + longest);
	}
}
