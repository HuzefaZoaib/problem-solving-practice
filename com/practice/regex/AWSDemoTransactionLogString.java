package com.practice.regex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AWSDemoTransactionLogString {

	public static void main(String[] args) {

		List<String> logs = Arrays.asList("88 99 200", "88 99 300", "99 32 100", "12 12 15");
		int threshold = 2;
		List<String> expected = Arrays.asList("88", "99");
		List<String> result = processLogs(logs, threshold);
		System.out.printf("Expected:%s, Got:%s \n", expected, result);
		
		logs = Arrays.asList("1 2 58", "1 7 78", "1 3 28", "2 2 17");
		threshold = 2;
		expected = Arrays.asList("1", "2");
		result = processLogs(logs, threshold);
		System.out.printf("Expected:%s, Got:%s \n", expected, result);
	
		logs = Arrays.asList("9 7 58", "22 7 20", "33 7 58", "22 7 38", "9999 45859432 09874682");
		threshold = 3;
		expected = Arrays.asList("7");
		result = processLogs(logs, threshold);
		System.out.printf("Expected:%s, Got:%s \n", expected, result);
	}

	static List<String> processLogs(List<String> logs, int threshold) {

		// Write your code here
		Map<String, Frequency> users = new HashMap<>();
		for (String s : logs) {
			String[] log = parseLog(s); //s.split(" ");
			
			users.putIfAbsent(log[0], new Frequency(log[0], 0));
			users.get(log[0]).increment();
			
			// Don't increment for user who are transacting for themselves
			if (!log[1].equals(log[0])) {
				users.putIfAbsent(log[1], new Frequency(log[1], 0));
				users.get(log[1]).increment();
			}
		}				
		
		List<Frequency> freqGreaterThreshold = users.values().stream().filter(f -> f.frequency >= threshold).collect(Collectors.toList());
		freqGreaterThreshold.sort(null);
		List<String> freqGreaterThresholdUsers = freqGreaterThreshold.stream().map(f->f.user).collect(Collectors.toList());
		
		return freqGreaterThresholdUsers;
	}
	
	static String[] parseLog(String log) {

		// Write your code here
		String[] arr = new String[2];
		String regex = "^([0-9]{1,9}) ([0-9]{1,9}) ([0-9]{1,9})$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(log);
		//System.out.println(m.matches());
		if(m.find()) {
			//System.out.println(m.group(0));
			arr[0] = m.group(1);
			arr[1] = m.group(2);
		}
		return arr;
	}
	
	static class Frequency implements Comparable<Frequency> {

		String user; 
		int frequency;
		
		public Frequency(String user, int frequency) {
			this.user = user;
			this.frequency = frequency;
		}
		
		int increment() {
			this.frequency = frequency + 1;
			return this.frequency;
		}
		
		@Override
		public int compareTo(Frequency f) {
			if(this.user.equals(f.user))
				return 0;
			
			return this.user.compareTo(f.user);
		}
		
		@Override
		public String toString() {
			return java.text.MessageFormat.format("User:{0} Frequence:{1}", user, frequency);
		}
	}
}
