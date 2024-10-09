package com.practice;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.Comparator;
import java.util.List;

public class DescendingIntegerList {

	public static void main(String[] args) {
	
		List<Integer> data = new ArrayList<>();
		data.add(1);
		data.add(2);
		data.sort( Collections.<Integer>reverseOrder() );

		// Another Ways is
		data.sort( Comparator.<Integer>reverseOrder() );

		
		System.out.println(data);
	}
}
