package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InsertIntoLinkedListViaStream {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		
		Stream<Integer>  concat = Stream.concat(list.stream(),Stream.of(6));
		System.out.println("Postponed Concatenated List: " +concat.collect(Collectors.toList()));
		
		
	}
}
