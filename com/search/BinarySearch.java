package com.search;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {2,4,8,15,17,30,37,40};
		int search = 37;
		searchedIndex = -1;
		bst(arr, search, 0, arr.length);
		System.out.printf("Index of %d is %d\n", search, searchedIndex);

		search = 25;
		searchedIndex = -1;
		bst(arr, search, 0, arr.length);
		System.out.printf("Index of %d is %d\n", search, searchedIndex);

		search = 2;
		searchedIndex = -1;
		bst(arr, search, 0, arr.length);
		System.out.printf("Index of %d is %d\n", search, searchedIndex);

		search = 40;
		searchedIndex = -1;
		bst(arr, search, 0, arr.length);
		System.out.printf("Index of %d is %d\n", search, searchedIndex);
	}
	
	static int searchedIndex = -1;
	static void bst(int[] arr, int search, int start, int end) {
		
		if(start > end)
			return;
		
		int mid = start + (end-start)/2;
		if( search == arr[mid] ) {
			searchedIndex = mid;
		} else if (search < arr[mid]) {
			bst(arr, search, start, mid-1);
		} else if (search > arr[mid]) {
			bst(arr, search, mid+1, end);
		}
	}

}
