package com.practice;

public class AnagramCheck {

	public static void main(String[] args) {
		
		anagramCheck("conversation", "voice rants on");
		anagramCheck("eleven plus two", "twelve plus one");
		anagramCheck("night", "thing");
	
		System.out.println();
		
		anagramCheckWithWhitespace("conversation", "voice rants on");
		anagramCheckWithWhitespace("eleven plus two", "twelve plus one");
		anagramCheckWithWhitespace("night", "thing");	
	}
	
	static void anagramCheck(String word1, String word2) {
		
		/*
		 * Count Sort will be more suitable.
		 * 
		 * Another technique could be done by taking the Sum but it will fail for some scenarios like 1+2+3 == 2+2+2 == 0+3+3 that is wrong.
		 */
		boolean isAnagram = false;
		int[] countA = new int[256];
		int[] countB = new int[256];
		if(word1.length() == word2.length()) {
			
			for(int i=0; i<word1.length(); i++) {
				countA[word1.charAt(i)]++;
				countB[word2.charAt(i)]++;
			}
			
			for(int i=0; i<countA.length; i++) {
				isAnagram = (countA[i]==countB[i]);
				if(isAnagram == false) {
					break;
				}
			}
		}
		
		
		System.out.printf("Word: \"%s\" and Word: \"%s\" are %s Anagram.\r\n", word1, word2, (isAnagram?"":"not"));
	}
	
	static void anagramCheckWithWhitespace(String word1, String word2) {
		
		/*
		 * Count Sort will be more suitable.
		 * 
		 * Another technique could be done by taking the Sum but it will fail for some scenarios like 1+2+3 == 2+2+2 == 0+3+3 that is wrong.
		 */
		boolean isAnagram = false;
		int[] countA = new int[256];
		int[] countB = new int[256];
		
		for(int i=0; i<word1.length(); i++) {
			if(word1.charAt(i) == ' ') {
				continue;
			}
			
			countA[word1.charAt(i)]++;
		}
		
		for(int i=0; i<word2.length(); i++) {
			if(word2.charAt(i) == ' ') {
				continue;
			}
			
			countB[word2.charAt(i)]++;
		}
			
		for(int i=0; i<countA.length; i++) {
			isAnagram = (countA[i]==countB[i]);
			if(isAnagram == false) {
				break;
			}
		}
		
		
		System.out.printf("Word: \"%s\" and Word: \"%s\" are %s Anagram.\r\n", word1, word2, (isAnagram?"":"not"));
	}
}
