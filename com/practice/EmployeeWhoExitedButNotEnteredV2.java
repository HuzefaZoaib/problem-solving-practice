package com.practice;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeWhoExitedButNotEnteredV2 {

	// Assuming records are in order
	private static List<String[]> RECORDS = Arrays.asList(new String[][]{
	    new String[]{"Paul",     "enter"},
	    new String[]{"Pauline",  "exit"},
	    new String[]{"Paul",     "enter"},
	    new String[]{"Paul",     "exit"},
	    new String[]{"Martha",   "exit"},
	    new String[]{"Joe",      "enter"},
	    new String[]{"Martha",   "enter"},
	    new String[]{"Steve",    "enter"},
	    new String[]{"Martha",   "exit"},
	    new String[]{"Jennifer", "enter"},
	    new String[]{"Joe",      "enter"},
	    new String[]{"Curtis",   "exit"},
	    new String[]{"Curtis",   "enter"},
	    new String[]{"Joe",      "exit"},
	    new String[]{"Martha",   "enter"},
	    new String[]{"Martha",   "exit"},
	    new String[]{"Jennifer", "exit"},
	    new String[]{"Joe",      "enter"},
	    new String[]{"Joe",      "enter"},
	    new String[]{"Martha",   "exit"},
	    new String[]{"Joe",      "exit"},
	    new String[]{"Joe",      "exit"}
	});

	record Employee(String name, String cardPunchStatus){
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Employee employee = (Employee) o;
			return name.equals(employee.name) && cardPunchStatus.equals(employee.cardPunchStatus);
		}

		@Override
		public int hashCode() {
			return (name+cardPunchStatus).hashCode();
		}

		public Employee cloneWithInvertedStatus() {
			if("exit".equals(this.cardPunchStatus)) {
				return new Employee(this.name, "enter");
			} else {
				return new Employee(this.name, "exit");
			}
		}
	}

	public static void main(String[] args) {

		List<Employee> employees = RECORDS.stream().map(e -> new Employee(e[0],e[1])).collect(Collectors.toList());

		// If Employee is entered, then Lookup the Employee with exit or vice versa
		// If Employee enter and exit both exist, then delete them from the list
		List<Employee> enteries = employees.stream().filter(e -> "enter".equals(e.cardPunchStatus)).collect(Collectors.toList());
		List<Employee> exits = employees.stream().filter(e -> "exit".equals(e.cardPunchStatus)).collect(Collectors.toList());

		// We are finding Disjoints over here, Which are not common in both
		for(Iterator<Employee> itr = enteries.iterator(); itr.hasNext();) {
			Employee e = itr.next();
			int i = exits.indexOf(e.cloneWithInvertedStatus());
			if (i>-1) {
				itr.remove();
				exits.remove(i);
			}
		}

		for(Iterator<Employee> itr = exits.iterator(); itr.hasNext();) {
			Employee e = itr.next();
			int i = enteries.indexOf(e.cloneWithInvertedStatus());
			if (i>-1) {
				itr.remove();
				enteries.remove(i);
			}
		}
		
		System.out.printf("Entered without Exit: %s %n", enteries);
		System.out.printf("Exit without Entered: %s", exits);
	}
}
