package com.search;

import java.util.Stack;

public class BinarySearchCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "A";
		Stack<Integer> st = new Stack<>();
		
		
		int[] arr = new int[] {2,4,8,15,17,30,37,38,40};
		int searchSt = 15;
		int searchEd = 30;
		count = 0;
		bst(arr, searchSt, searchEd, 0, arr.length);
		System.out.printf("Index of %d-%d is %d\n", searchSt, searchEd, count);

		searchSt = 16;
		searchEd = 18;
		count = 0;
		bst(arr, searchSt, searchEd, 0, arr.length);
		System.out.printf("Index of %d-%d is %d\n", searchSt, searchEd, count);

		searchSt = 0;
		searchEd = 2;
		count = 0;
		bst(arr, searchSt, searchEd, 0, arr.length);
		System.out.printf("Index of %d-%d is %d\n", searchSt, searchEd, count);

		searchSt = 0;
		searchEd = 1;
		count = 0;
		bst(arr, searchSt, searchEd, 0, arr.length);
		System.out.printf("Index of %d-%d is %d\n", searchSt, searchEd, count);
	}
	
	static int count = 0;
	static void bst(int[] arr, int searchSt, int searchEd, int start, int end) {
		
		if(start >= end)
			return;
		
		int mid = start + (end-start)/2;
		int ele = arr[mid];
		
		if( bt(ele, searchSt, searchEd) ) {
			count++;
		} 
		
		bst(arr, searchSt, searchEd, start, mid);
		bst(arr, searchSt, searchEd, mid+1, end);
	}
	
	static boolean bt(int ele, int st, int ed) {
		return ele >= st && ele <= ed;
	}

}
