package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoIntegerResultToSum {

	public static void main(String[] args) {
		
		TwoIntegerResultToSum _this = new TwoIntegerResultToSum();
		int[] data = new int[] {8,1,2,3,10,20,0,9,8,7,10}; int sum=10;
		List<Pair> result = _this.collectPairMakingSum(data, sum);
		System.out.println("Sum="+sum+", "+result);
		
		sum = 20;
		result = _this.collectPairMakingSum(data, sum);
		System.out.println("Sum="+sum+", "+result);
	}

	List<Pair> collectPairMakingSum(int[] arr, int sum) {
		
		List<Pair> result = new ArrayList<TwoIntegerResultToSum.Pair>();
		Arrays.sort(arr);
		
		for(int left=0,right=arr.length-1; left<=right;) {
			if(arr[left]+arr[right] > sum) {
				right--;
			} else if(arr[left]+arr[right] < sum) {
				left++;
			} else {
				result.add(new Pair(arr[left],arr[right]));
				right--;
				left++;
			}
		}
		
		return result;
	}
	
	class Pair {
		
		int num1;
		int num2;
		
		public Pair(int num1, int num2) {
			super();
			this.num1 = num1;
			this.num2 = num2;
		}

		@Override
		public String toString() {
			return "Pair(" + num1 + ", " + num2 + ")";
		}
	}
}
