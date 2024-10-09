package com.practice;

public class CoinDynamicProblem {

	public static void main(String[] args) {
		
		int m = 5;
		int[] coins = new int[] {1,2};
		System.out.println( min_coins(m, coins) );
	}
	
	static int min_coins(int m, int[] coins) {
		int ans = -1;
		if (m == 0) {
			ans = 0;
		} 
		else {
			// Reset value
			ans = -1;
			for(int coin : coins) {
				int sub = m - coin;
				if(sub < 0)
					continue;
				int _ans = min_coins(sub, coins)+1;
				ans = min_ignore_none(ans, _ans);
				System.out.printf("m=%d, coin:%d, sub=%d, _ans=%d, min=%d \n", m, coin, sub, _ans, ans);
			}
		}
		
		return ans;
	}
	
	static int min_ignore_none(int a, int b) {
		if(a < 0)
			return b;
		if(b < 0)
			return a;
		return Math.max(a, b);
	}
}
