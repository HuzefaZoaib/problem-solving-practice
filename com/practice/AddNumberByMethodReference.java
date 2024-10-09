package com.practice;

import java.util.function.BinaryOperator;

public class AddNumberByMethodReference {

	static int sum(int a, int b) {
		return a+b;
	}
	
	static Integer sum(int a, int b, BinaryOperator<Integer> operator) {
		return operator.apply(a, b);
	}
	
	public static void main(String[] args) {
		System.out.println(sum(1,3,AddNumberByMethodReference::sum));
	}
}
