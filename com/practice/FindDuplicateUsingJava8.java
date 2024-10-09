package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateUsingJava8 {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		names.add("A");
		names.add("B");
		names.add("C");
		names.add("D");
		names.add("B");
		names.add("A");

		Map<String,Long> _histrogram = names.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()));

		//System.out.println(names.stream().collect(Collectors.toMap(String::length, e->e)));

		//System.out.println(names.stream().collect(Collectors.groupingBy(e->e, Collectors.maxBy(String::compareTo))));

		Map<String,Integer> histrogram = new HashMap<>();
		names.stream().forEach( name -> {
			if( histrogram.get(name) == null ) {
				histrogram.put(name, 1);
			} else {
				histrogram.put(name, histrogram.get(name) + 1);
			}
		});
		
		List<Map.Entry<String, Integer>> duplicates = histrogram.entrySet().stream()
			.filter(entry -> entry.getValue() > 1)
			.collect(Collectors.toList());
		
		System.out.println(duplicates);
	
		duplicates.forEach(System.out::print);
	}
}
