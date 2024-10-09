package com.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingByTwoFields {

	static class Person {
		String name;
		int age;
		
		public Person(String name, int age) {
			this.name=name;
			this.age=age;
		}

		@Override
		public String toString() {
			return "[Name: "+name+", Age: "+age+"]";
		}
	}
	
	public static void main(String[] args) {

		Comparator<Person> c = Comparator.comparing(p -> p.name);
		c = c.thenComparing(p -> p.age);
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("A", 4));
		persons.add(new Person("B", 4));
		persons.add(new Person("A", 3));
		
		persons.sort(c);
		System.out.println(persons);
	}
}



