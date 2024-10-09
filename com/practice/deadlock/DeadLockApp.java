package com.practice.deadlock;


public class DeadLockApp {

	public static void main(String[] args) throws Exception {
		
		//DeadLockApp obj = new DeadLockApp();
		Runner process = new Runner();
		Thread t1 = new Thread(() -> { 
			try {
				process.firstThread();
			} catch (Exception e) {}
		});
		
		Thread t2 = new Thread(() -> { 
			try {
				process.secondThread();
			} catch (Exception e) {}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();	// join with 1000mili is not helping to break the blocking of queue.take(). The program is indefinitely.
		
		System.out.println("All done, good to exit, with the balance.");
		process.finished();
		
	}

}
