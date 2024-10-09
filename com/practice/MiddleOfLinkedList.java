package com.practice;

import java.util.Arrays;
import java.util.List;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		
		middleIndex(Arrays.asList(new Integer[] {}));
		middleIndex(Arrays.asList(new Integer[] {1}));
		middleIndex(Arrays.asList(new Integer[] {1,2}));
		middleIndex(Arrays.asList(new Integer[] {1,2,3}));
		middleIndex(Arrays.asList(new Integer[] {1,2,3,4}));
		middleIndex(Arrays.asList(new Integer[] {1,2,3,4,5}));
		middleIndex(Arrays.asList(new Integer[] {1,2,3,4,5,6}));
		middleIndex(Arrays.asList(new Integer[] {1,2,3,4,5,6,7}));
		middleIndex(Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8}));
		middleIndex(Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9}));
	}
	static int classLevelCounter = -1;
	static int classLevelMiddleIndex = -1;
	static int middleIndex(List<Integer> list) {
		
		int midIndex = -1;
		for(int counter=0; counter<list.size(); counter++) {
			
			if(counter%2 == 0) {
				midIndex++;
			}
		}
		
	
		list.stream().forEach(ele -> {
			classLevelCounter++;	// this will tell which Indexed Element it is
			if(classLevelCounter%2 == 0) {
				classLevelMiddleIndex++;
			}
		});
		
		System.out.printf("For ArraySize:%d, Middle Index is %d, Stream Middle Index: %d\r\n", list.size(), midIndex, classLevelMiddleIndex);

		classLevelCounter=-1;
		classLevelMiddleIndex = -1;
		return midIndex;
	}
}
