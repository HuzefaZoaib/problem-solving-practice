package com.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimeNumber {

	public static void main(String[] args) {
		
		// Initialize with default prime numbers
		List<Integer> primeNumbers = new ArrayList<>();
		
		for(int n=2; n<=100; n++) {
	
			// Is Prime
			/* 
			 * If a number is not divided by any number till its square root. Then it is prime number.
			 * I have added a one more criteria, only check by division by passed  prime number 
			 * 0 and 1 are not prime numbers   
			 */
			
			// Run a loop from 2 to square root of n
			boolean nIsPrime = true;
			outer:
			for(Iterator<Integer> primeIterator = primeNumbers.iterator(); primeIterator.hasNext();) {
				for(int i=primeIterator.next(); i*i<=n; i++) {
					if (n%i == 0) {
						nIsPrime = false;
						break outer;
					}
				}
			}
			if(nIsPrime) {
				primeNumbers.add(n);
			}
		}
		
		System.out.printf("Prime Numbers: %s\r\n", primeNumbers);
	}
}
