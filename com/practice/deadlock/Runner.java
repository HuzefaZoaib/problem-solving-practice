package com.practice.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	Account acct1 = new Account();
	Account acct2 = new Account();
	
	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();
	
	public void firstThread() throws InterruptedException {
		
		Random random = new Random();
		for(int i=0; i<10000; i++) {
			
			lock1.lock();
			lock2.lock();
			
			try {
				Account.transfer(acct1, acct2, random.nextInt(100));
			}	finally {
				lock1.unlock();
				lock2.unlock();	
			}
		}
	}
	
	public void secondThread() throws InterruptedException {
		Random random = new Random();
		for(int i=0; i<10000; i++) {

			lock1.lock();
			lock2.lock();
			
			try {
				Account.transfer(acct2, acct1, random.nextInt(100));
			}	finally {
				lock1.unlock();
				lock2.unlock();	
			}
		}
	}
	
	public void finished() {
		System.out.println("Account_1 Balance: "+acct1.getBalance());
		System.out.println("Account_2 Balance: "+acct2.getBalance());
		System.out.println("Total Balance: "+(acct1.getBalance()+acct2.getBalance()));
	}
}
