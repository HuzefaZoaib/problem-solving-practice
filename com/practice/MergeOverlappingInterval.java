package com.practice;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeOverlappingInterval {

	static class Interval {
		int start;
		int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public String toString() {
			return MessageFormat.format("Start: {0} End:{1}", start, end);
		}
		
		public Interval clone() {
			return new Interval(this.start, this.end);
		}
	}
	
	public static void main(String[] args) {
		
		/**
		 * 
		Follow the steps mentioned below to implement the approach:
		
		- Sort all intervals in increasing order of start time.
		- Traverse sorted intervals starting from the first interval, 
		- Do the following for every interval.
		- - If the current interval is not the first interval and it overlaps with the previous interval, 
		    then merge it with the previous interval. Keep doing it while the interval overlaps with the previous one.         
		- -  Otherwise, Add the current interval to the output list of intervals.
		 */
		
		Interval arr[] = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        mergeIntervals(Arrays.asList(arr));
        
        System.out.println();
        
        arr = new Interval[4];
        arr[0] = new Interval(1, 2);
        arr[1] = new Interval(3, 4);
        arr[2] = new Interval(4, 7);
        arr[3] = new Interval(6, 8);
        mergeIntervals(Arrays.asList(arr));
	
        System.out.println();
        
        arr = new Interval[4];
        arr[0] = new Interval(1, 2);
        arr[1] = new Interval(3, 4);
        arr[2] = new Interval(5, 6);
        arr[3] = new Interval(6, 8);
        mergeIntervals(Arrays.asList(arr));
	
	}
	
	static void mergeIntervals(final List<Interval> intervals) {
		
		// Sorting
		Map<Integer,Interval> sorted = new TreeMap<>();
		intervals.stream().forEach(interval -> sorted.put(interval.start, interval.clone()));

		// Check with previous, and if overlapping merge it
		List<Interval> mergedIntervals = new ArrayList<Interval>();
		for(Map.Entry<Integer,Interval> entry : sorted.entrySet()) {
			
			if(mergedIntervals.size() == 0) {
				mergedIntervals.add(entry.getValue());
				continue;
			}
			
			Interval previousInterval = mergedIntervals.get(mergedIntervals.size()-1);
			if(  previousInterval.end >= entry.getValue().start ) {
				// it is overlapping so merged it
				previousInterval.end = entry.getValue().end;
				continue;
			}
			
			mergedIntervals.add(entry.getValue());
		}
		
		System.out.println(intervals);
		System.out.println(mergedIntervals);
	}
}
