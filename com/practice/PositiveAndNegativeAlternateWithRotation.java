package com.practice;

import java.util.Arrays;

public class PositiveAndNegativeAlternateWithRotation {

	public static void main(String[] args) {
		
		int[] arr = new int[] {-1,4,8,-6,3,8,-4,-6,-9,2,2,2};
		String arrString = Arrays.toString(arr);
		fixPositiveNegativeAlternateint(arr);
		System.out.printf("Arrays:%s, After Rearrange:%s", arrString, Arrays.toString(arr));
	}
	
	static void rotate(int[] arr, int startIndex) {
		int lastVal = arr[arr.length-1];
		for(int i=arr.length-1; i>startIndex; i--) {
			arr[i] = arr[i-1];
		}
		arr[startIndex] = lastVal;
	}
	
	static void fixPositiveNegativeAlternateint(int[] arr) {
		
		// assuming first should be positive and next should be negative.
		// Even position should be positive, odd position should be negative
		// [2, -1, 4, -9, 8, -6, 3, -6, 8, -4]
		// [2, -1, 4, -9, 2, -6, 8, -6, 3, -4, 8]
		// [2, -1, 4, -9, 2, -6, 2, -4, 8, -6, 3, 8]
		for(int i=0; i<arr.length;i++) {
			int j=arr.length-1;
			if(i%2==0 && arr[i]<0) {
				// search and replace with positive
				do {
					rotate(arr, i);
					j--;
				} while(arr[i]<0 && j>i);
			} else if(i%2==1 && arr[i]>0) {
				// search and replace with negative
				do {
					rotate(arr, i);
					j--;
				} while(arr[i]>0 && j>i);
			}
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
