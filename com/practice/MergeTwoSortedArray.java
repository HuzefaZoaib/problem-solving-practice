package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		mergeSortedArrays(Arrays.asList(new Integer[] {}), Arrays.asList(new Integer[]{}));
		mergeSortedArrays(Arrays.asList(new Integer[] {1}), Arrays.asList(new Integer[]{}));
		mergeSortedArrays(Arrays.asList(new Integer[] {}), Arrays.asList(new Integer[]{1}));
		mergeSortedArrays(Arrays.asList(new Integer[] {1}), Arrays.asList(new Integer[]{1}));
		mergeSortedArrays(Arrays.asList(new Integer[] {1}), Arrays.asList(new Integer[]{1,1}));
		mergeSortedArrays(Arrays.asList(new Integer[]{1,2}), Arrays.asList(new Integer[]{2,3}));
		mergeSortedArrays(Arrays.asList(new Integer[]{1,3,5}), Arrays.asList(new Integer[]{2,4,6,7}));
	}
	
	static void mergeSortedArrays(List<Integer> list1, List<Integer> list2) {
		
		int list1Index=0, list2Index=0;
		List<Integer> mergedList = new ArrayList<>(list1.size()+list2.size());
		
		while(list1Index<list1.size() && list2Index<list2.size()) {
			
			if(list1.get(list1Index) < list2.get(list2Index)) {
				mergedList.add(list1.get(list1Index));
				list1Index++;
			} else if(list1.get(list1Index) > list2.get(list2Index)) {
				mergedList.add(list2.get(list2Index));
				list2Index++;
			} else {
				mergedList.add(list1.get(list1Index));
				mergedList.add(list2.get(list2Index));
				list1Index++; list2Index++;
			}
		}
		
		// Filled the left overs
		while(list1Index<list1.size()) {			
			mergedList.add(list1.get(list1Index));
			list1Index++;
		}
		while(list2Index<list2.size()) {			
			mergedList.add(list2.get(list2Index));
			list2Index++;
		}
		
		System.out.printf("List-A:%s, List-B:%s, Merged List:%s\r\n", list1, list2, mergedList);
	}
}
