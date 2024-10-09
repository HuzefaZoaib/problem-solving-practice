package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopThreeFrequentElements {

	public static void main(String[] args) {
		
		TopThreeFrequentElements topThree = new TopThreeFrequentElements();
		Map<Integer, Frequency> histrogram = topThree.createHistrogram(Arrays.asList(2,5,6,9,2,9,4,6,6,6,2,9,9,9));
		List<Frequency> frequencies = histrogram.values().stream().collect(Collectors.toList());
		frequencies.sort(null);
		
		System.out.printf("{Element, Frequency}: {%d, %d}, {%d, %d}, {%d, %d}",  
				frequencies.get(0).data, frequencies.get(0).frequency, 
				frequencies.get(1).data, frequencies.get(1).frequency,
				frequencies.get(2).data, frequencies.get(2).frequency);
	}
	
	Map<Integer, Frequency> createHistrogram(List<Integer> data) {

		Map<Integer, Frequency> histrogram = new HashMap<>();
		for(Integer ele : data) {
			if(histrogram.containsKey(ele)) {
				histrogram.get(ele).increment();
			} else {
				histrogram.put(ele, new Frequency(ele, 1));
			}
		}
		
		return histrogram;
	}
	
	class Frequency implements Comparable<Frequency> {
		int data;
		int frequency;
		
		Frequency(int data, int frequency) {
			this.data=data;
			this.frequency=frequency;
		}
		
		int increment() {
			this.frequency++;
			return this.frequency;
		}
		
		public String toString() {
			return java.text.MessageFormat.format("Data:{0} - Frequency:{1}", this.data, this.frequency);
		}

		@Override
		public int compareTo(Frequency o) {
			if(o.frequency == this.frequency)
				return 0;
			
			return this.frequency < o.frequency ? 1 : -1;
		}
	}
}
