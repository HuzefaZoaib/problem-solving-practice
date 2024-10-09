package com.practice;

public class FactoryPattern {

	public static Object getObject(String whichOne) {
		switch(whichOne) {
			case "A":
				return new String("A");
			default:
				return new String("Default");
		}
	}
}
