package com.practice;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,3,5,7,9};
		solution(arr, 1);

		arr = new int[]{1,3,5,7,9};
		solution(arr, 0);

		arr = new int[]{1,3,5,7,9};
		solution(arr, 5);
	
		arr = new int[]{1,3,5,7,9};
		solution(arr, 6);
		
		arr = new int[]{};
		solution(arr, 2);
		
		arr = new int[]{1};
		solution(arr, 4);
		
		arr = new int[]{1,2};
		solution(arr, 4);
	}
	
	private static void solution(int[] arr, int rotateBy) {
		
		int[] copy = arr.clone();
		if(rotateBy < 1 || arr.length == 0) {
			System.out.printf("Original Array: %s, After rotation by %d is %s", Arrays.toString(arr), rotateBy, Arrays.toString(copy)); 
			System.out.println();
			return;
		}
		
		for(int count=0; count<rotateBy; count++) {
			int lastEle = copy[copy.length-1];
			for(int i=copy.length-2; i>=0; i--) {
				copy[i+1] = copy[i];
			}
			copy[0] = lastEle;
		}
		
		System.out.printf("Original Array: %s, After rotation by %d is %s", Arrays.toString(arr), rotateBy, Arrays.toString(copy));
		System.out.println();
	}

}
