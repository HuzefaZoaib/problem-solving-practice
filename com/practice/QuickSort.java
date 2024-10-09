package com.practice;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		QuickSort quicksort = new QuickSort();
		int[] arr = new int[] {5,8,9,1,6,5};
		String arrStr = Arrays.toString(arr);
		quicksort.quicksort(arr, 0, arr.length-1);
		System.out.printf("Original:%s, Sorted:%s", arrStr, Arrays.toString(arr));
	}

	void quicksort(int[] arr, int start, int end) {
		
		if(start >= end) {
			return;
		}
		
		int partition = partition(arr, start, end);
		System.out.println(partition);
		quicksort(arr, start, partition-1);
		quicksort(arr, partition, end);
	}
	
	int partition(int[] arr, int start, int end) {

		int mid = start + (end - start) / 2;
		int pivot = arr[mid];

		int left = start;
		int right = end;

		while (left <= right) {

			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			//if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			//}
		}
		
		return left;
	}

	// A utility function to swap two elements
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
