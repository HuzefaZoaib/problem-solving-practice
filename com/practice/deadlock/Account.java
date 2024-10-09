package com.practice.deadlock;

public class Account {

	private int balance = 1000;
	
	public int deposit(int amt) {
		balance += amt;
		return balance; // New Balance
	}
	
	public int withdraw(int amt) {
		balance -= amt;
		return balance;	// New Balance
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public static void transfer(Account acct1, Account acct2, int amt) {
		acct1.withdraw(amt);
		acct2.deposit(amt);
	}
}
