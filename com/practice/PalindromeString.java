package com.practice;

public class PalindromeString {

	public static void main(String[] args) {
		
		String str = "";
		System.out.printf("\"%s\" is %sPalindrome.\r\n", str, (checkPalindrome(str)?"":"not "));
		
		str = "a";
		System.out.printf("\"%s\" is %sPalindrome.\r\n", str, (checkPalindrome(str)?"":"not "));
		
		str = "aba";
		System.out.printf("\"%s\" is %sPalindrome.\r\n", str, (checkPalindrome(str)?"":"not "));
	
		str = "civic";
		System.out.printf("\"%s\" is %sPalindrome.\r\n", str, (checkPalindrome(str)?"":"not "));
	}
	
	static boolean checkPalindrome(String str) {
		
		if(str == null || str.trim() == "") {
			return false;
		}
		
		str = str.trim();
		
		int length = str.length();
		int left=0,right=length-1;
		
		while(left<right) {
			if(str.charAt(left)==str.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		
		return true;
	}
}
