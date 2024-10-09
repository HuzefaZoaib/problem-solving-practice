package com.practice;

import java.util.Arrays;

public class PositiveAndNegativeAlternate {

	public static void main(String[] args) {
		
		int[] arr = new int[] {-1,4,8,-6,3,8,-4,-6,-9,2};
		String arrString = Arrays.toString(arr);
		fixPositiveNegativeAlternateint(arr);
		System.out.printf("Arrays:%s, After Rearrange:%s", arrString, Arrays.toString(arr));
	}
	
	static void fixPositiveNegativeAlternateint(int[] arr) {
		
		// assuming first should be positive and next should be negative.
		// Even position should be positive, odd position should be negative
		for(int i=0; i<arr.length; i++) {
			if(i%2==0 && arr[i]<0) {
				// search and replace with positive
				for(int j=i+1; j<arr.length; j++) {
					if(arr[j]>0) {
						swap(arr, i, j);
						break;
					}
				}
			} else if(i%2==1 && arr[i]>0) {
				// search and replace with negative
				for(int j=i+1; j<arr.length; j++) {
					if(arr[j]<0) {
						swap(arr, i, j);
						break;
					}
				}
			}
		}
		
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
