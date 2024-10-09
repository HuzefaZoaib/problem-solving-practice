package com.practice.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AWSDemoInventoryString {

	public static void main(String[] args) {
		
		String s = "|**|*|*|";
		List<Integer> startIndices = Arrays.asList(1,1);
		List<Integer> endIndices = Arrays.asList(5,6);
		List<Integer> exptected = Arrays.asList(2,3);
		List<Integer> solve = solve(s, startIndices, endIndices);
		List<Integer> solveRegEx = solve(s, startIndices, endIndices);
		System.out.printf("Expected:%s, Got:%s, fromRegEx:%s \n", exptected, solve, solveRegEx);
	
		s = "*|*|*|";
		startIndices = Arrays.asList(1,1);
		endIndices = Arrays.asList(1,6);
		exptected = Arrays.asList(2);
		solve = solve(s, startIndices, endIndices);
		solveRegEx = solve(s, startIndices, endIndices);
		System.out.printf("Expected:%s, Got:%s, fromRegEx:%s \n", exptected, solve, solveRegEx);

		s = "*|*|";
		startIndices = Arrays.asList(1,1);
		endIndices = Arrays.asList(1,3);
		exptected = Arrays.asList(0);
		solve = solve(s, startIndices, endIndices);
		solveRegEx = solve(s, startIndices, endIndices);
		System.out.printf("Expected:%s, Got:%s, fromRegEx:%s \n", exptected, solve, solveRegEx);
	}
	
	static List<Integer> solve(String s, List<Integer> startIndices, List<Integer> endIndices) {
	
		List<Integer> allItemCounts = new ArrayList<Integer>();
		for(int i=0; i<startIndices.size(); i++) {
			
			// Start Indices will have 1 based indexes
			int si = startIndices.get(i);
			int ei = endIndices.get(i);
			
			int itemCount = 0;
			if(ei <= s.length()) {
				String sub = s.substring(si-1, ei);
				boolean isCompartmentStarted = false;
				int subItemCount = 0;
				for(int j=0; j<sub.length(); j++) {
					char c = sub.charAt(j);
					
					if(!isCompartmentStarted && c == '|') {
						isCompartmentStarted = true;
						subItemCount = 0;
					} else if(isCompartmentStarted && c == '*') {
						subItemCount++;
					} else if(isCompartmentStarted && c == '|') {
						isCompartmentStarted = false;
						itemCount += subItemCount;
						j--; // because the same character will be treated as start also
					}
				}
			}
			
			allItemCounts.add(itemCount);
		}
		
		return allItemCounts;
	}

	static List<Integer> solveRegex(String s, List<Integer> startIndices, List<Integer> endIndices) {
		
		List<Integer> allItemCounts = new ArrayList<Integer>();
		for(int i=0; i<startIndices.size(); i++) {
			
			// Start Indices will have 1 based indexes
			int si = startIndices.get(i);
			int ei = endIndices.get(i);
			
			int itemCount = 0;
			if(ei <= s.length()) {
				String sub = s.substring(si-1, ei);
				
				/**
				 * (?<=\|): Positive lookbehind assertion to ensure that the match is 
				 * preceded by a pipe character (|).
				 * (\*+): Capturing group that matches one or more asterisks (*).
				 * (?=\|): Positive lookahead assertion to ensure that the match is 
				 * followed by a pipe character (|).
				 * 
				 * Couple of more material
				 * * https://stackoverflow.com/questions/17969436/java-regex-capturing-groups
				 * * https://stackoverflow.com/questions/5319840/greedy-vs-reluctant-vs-possessive-qualifiers
				 */
				//String pattern = "(\\|(\\*+)\\|)+";
				//String pattern = "(?<=\\|)(\\*+)(?=\\|)";	// this works
				String pattern = "(\\|\\*+\\|)+";			// this simpler one
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(sub);
				while(m.find()) {
					//System.out.println("sub="+sub);
					//System.out.println(m.groupCount());
					//System.out.println(m.group(1));
					itemCount += m.group(1).length();
				}	
			}
			
			allItemCounts.add(itemCount);
		}
		
		return allItemCounts;
	}
}
