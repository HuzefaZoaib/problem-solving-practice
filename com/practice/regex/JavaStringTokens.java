package com.practice.regex;

import java.util.Arrays;

public class JavaStringTokens {

	public static void main(String[] args) {
		
		String str = "He is a very very good boy, isn't he?";
		
		System.out.println(Arrays.toString(str.split("\\W+")));

	}

}
