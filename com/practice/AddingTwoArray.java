package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddingTwoArray {

	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(1,2,3,4);
		System.out.printf("Sum of %s + %s is %s\r\n",list1,list2,add(list1,list2));
	}
	
	static List<Integer> add(final List<Integer> list1, final List<Integer> list2) {
		
		List<Integer> resultArray = new ArrayList<>();
		
		int i=0,j=0;
		for(; i<list1.size() && j<list2.size(); i++,j++) {
			resultArray.add(list1.get(i)+list2.get(j));
		}
		
		for(; i<list1.size(); i++) {
			resultArray.add(list1.get(i));
		}
		
		for(; j<list2.size(); j++) {
			resultArray.add(list2.get(j));
		}
		
		return resultArray;
	}
}

