package com.practice;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class HourGlassess {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
        Integer m = scanner.nextInt();
        scanner.hasNextLine();
        BigInteger.valueOf(1);
	}

}

class Result1 {
	
	
	public static int hourglassSum(List<List<Integer>> arr) {
	
		int max = Integer.MIN_VALUE;
		for(int r=0; r<=3; r++) {
			for(int c=0; c<=3; c++) {
				
				List<Integer> row1 = arr.get(r);
				List<Integer> row2 = arr.get(r+1);
				List<Integer> row3 = arr.get(r+2);
				
				// first row sum
				int sum1 = row1.get(c)+row1.get(c+1)+row1.get(c+2);
				int sum2 = row2.get(c+1);
				int sum3 = row3.get(c)+row3.get(c+1)+row3.get(c+2);
				
				max = Math.max(max, (sum1+sum2+sum3));
			}
		}
		
		return max;
	}
}


class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    
        int max = Integer.MIN_VALUE;
        
        for(int rowOffset=0; rowOffset<=3; rowOffset++)
        for(int colOffset=0; colOffset<=3; colOffset++) {
            int sum = 0;
            
            // First Row
            for(int col=colOffset;col<(3+colOffset);col++){
                sum += arr.get(rowOffset).get(col);
            }
            
            // Middle Row
            sum += arr.get(1+rowOffset).get(1+colOffset);
            
            // Third Row
            for(int col=colOffset;col<(3+colOffset);col++){
                sum += arr.get(2+rowOffset).get(col);
            }
            
            max = Math.max(max, sum);
        }
        
        return max;
    }

}



/*
import java.io
import java.math.BigInteger;.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<Integer> fib = new ArrayList<>(50);
        fib.add(0);
        fib.add(1);
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()) {
            int n = s.nextInt();
            if(n < fib.size()) {
                System.out.println(fib.get(n));
                continue;
            }
            
            for(int i=fib.size(); i<=n; i++) {
                fib.add(fib.get(i-2)+fib.get(i-1));
            }
            
            System.out.println(fib.get(n));
        }
    
    }
}
*/
/*
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        s.hasNextLine();
        String line = s.nextLine();
        Stack<Character> characterStack= new Stack<Character>();
        for(int i=0; i<line.length();i++){
            char character = line.charAt(i);
            switch(character){
            case '{':
            case '(':
            case '[':
                characterStack.push(character);
                break;
            case '}':
            case ')':
            case ']': // It would be a closing character    
                if(characterStack.isEmpty()){
                    System.out.println("False");
                    return;
                }
                char openChar=characterStack.pop();
                if((character=='}' && openChar!='{') ||(character==')' && openChar!='(') ||(character==']' && openChar!='[') ){
                        System.out.println("False");
                        return;
                }
                
            }
        }
        if(characterStack.isEmpty())
            System.out.println("True");
        else
            System.out.println("False");
    }
}
*/
/*
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {       
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        for(int i=1;i<=n;i++) {
            if(i%3==0 && i%5==0) {
                System.out.println("FizzBuzz");
            } else if(i%3==0 && i%5!=0) {
                System.out.println("Fizz");
            }else if(i%3!=0 && i%5==0) {
                System.out.println("Buzz");
            }else if(i%3!=0 || i%5!=0) {
                System.out.println(i);
            }
        }
    }
}
*/