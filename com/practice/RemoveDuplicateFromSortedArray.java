package com.practice;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

	public static void main(String[] args) {
		
		int[] sortedArray = new int[] {1,2,2,2,3,3,4,4};
		String arrStr = Arrays.toString(sortedArray);
		removeDuplicate(sortedArray);
		System.out.println("Original Array: "+arrStr+ ", Removed Duplicates:" +Arrays.toString(sortedArray));
	}
	
	static int removeDuplicate(int[] sortedArray) {
		
		int j=0;
		for(int i=0; i<sortedArray.length-1; i++) {
			if(sortedArray[i] != sortedArray[i+1]) {
				// if this ith element and next element is same
				sortedArray[j] = sortedArray[i];
				j++;
			}
		}
		
		sortedArray[j++] = sortedArray[sortedArray.length-1];
		
		return j;
		
	}
}
