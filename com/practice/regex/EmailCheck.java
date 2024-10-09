package com.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCheck {

	public static void main(String[] args) {
		
		String email = "huzefa_zoaib2000@yahoo.com";
		String expected = "true";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "huzefazoaib@gmail.com";
		expected = "true";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "huzefa.zoaib@gmail.com";
		expected = "true";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "huzefa.zoaib@live.net";
		expected = "true";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "huzefa.zoaib@kinesso.com";
		expected = "true";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));

		email = "huzefa.zoaib@kinesso.abc";
		expected = "true";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "huzefa.zoaib@kinesso.co.uk";
		expected = "true";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "@kinesso.com";
		expected = "false";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "h@kinesso.com";
		expected = "false";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "huz@kinesso.com";
		expected = "true";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "huzefa.zoaib@.com";
		expected = "false";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "huzefa.zoaib@k.com";
		expected = "false";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "huzefa.zoaib@ki.com";
		expected = "false";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
		email = "huzefa.zoaib@kin.com";
		expected = "true";
		System.out.printf("email:%s Expected:%s Got:%s \n", email, expected, check(email));
	
	}
	
	static boolean check(String email) {
		
		String regex = "^([a-z_0-9\\.]{2,}\\@[a-z]{3,}\\.[a-z]{2,3}(\\.[a-z]{2})?)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
