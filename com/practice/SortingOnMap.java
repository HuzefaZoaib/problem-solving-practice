package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortingOnMap {

	public static void main(String[] args) {
		
		Map<String,String> data = new HashMap<String, String>();
		
		data.put("C", "A");
		data.put("B", "A");
		data.put("A", "A");
		data.put("D", "A");
		data.put("E", "A");
		
		Map<String, String> sortedMap = new TreeMap<>(data);
		sortedMap.entrySet().stream().forEach(entry -> System.out.printf("Key:%s, Value:%s\r\n", entry.getKey(), entry.getValue()));
	
		System.out.println();
		
		sortedMap.entrySet().stream().forEach(System.out::println);
		
		System.out.println();
		
		// comparingByKey will work, when Key is Comparable and implemented compareTo
		data.entrySet()
		  .stream()
		  .sorted(Map.Entry.<String, String>comparingByKey())
		  .forEach(System.out::println);
	}
}
