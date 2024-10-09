package com.practice;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLatchTryout {
	
	class Processor extends Thread {
		private CountDownLatch latch;

		Processor(CountDownLatch latch) {
			this.latch = latch;
		}
		
		public void run() {
			try {
				Thread.sleep(10);
			}catch(Exception e) {}
			
			System.out.println("Hello from Process");
			
			//if(latch.getCount() != 2) 
			latch.countDown();
		}
	}
	
	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService ex = Executors.newFixedThreadPool(3);
	
		ThreadLatchTryout _this = new ThreadLatchTryout();
		for(int i=0; i<3; i++) {
			ex.submit(_this.new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All Process Done");
	}

}
