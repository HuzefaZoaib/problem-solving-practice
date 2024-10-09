package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeWhoExitedButNotEntered {

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
	
	public static void main(String[] args) {
		
		// Streams are lazy, it will not process until the terminal method is invoked
		RECORDS.stream().map( (record) -> {System.out.println("Record called"); return record[0]+record[1];});
		try { Thread.sleep(5000); } catch(Exception ex) {}
		RECORDS.stream().map( (record) -> {System.out.println("Record called"); return record[0]+record[1];}).collect(Collectors.toList());
		try { Thread.sleep(5000); } catch(Exception ex) {}
		
		List<String> records = RECORDS.stream().map( (record) -> {System.out.println("Record called"); return record[0]+record[1];}).collect(Collectors.toList());
		
		List<String> enteredButNotExit = new ArrayList<>();
		List<String> exitButNotEntered = new ArrayList<>();
		for(String record : records) {
			if(record.contains("exit")) {
				String employeeName = record.substring(0, record.indexOf("exit"));
				if(enteredButNotExit.contains(employeeName+"enter")) {
					enteredButNotExit.remove(employeeName+"enter");
				} else {
					exitButNotEntered.add(record);
				}
			} else {
				enteredButNotExit.add(record);
			}
		}
		
		System.out.printf("Entered without Exit: %s %n", enteredButNotExit);
		System.out.printf("Exit without Entered: %s", exitButNotEntered);
	}
}
