package com.practice;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThredProducerAndConsumer {

	private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
	
	void producer() throws Exception {
		int i=100;
		while(i>0) {
			Thread.sleep(100);
		
			queue.put("Message: " +(Math.random()/10000));
			System.out.printf("i=%d ", --i);
		}
	
		System.out.println("Producer is done with producing.");
	}
	
	void consumer() throws Exception {
		
		while(true) {
			Thread.sleep(150);
		
			//queue.stream().forEach(value -> System.out.printf("Value: %s, Queue Size: %d\r\n", value, queue.size()));
			System.out.printf("Value: %s, Queue Size: %d\r\n", queue.take(), queue.size());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		ThredProducerAndConsumer obj = new ThredProducerAndConsumer();
		ProcessWithWaitNotify process = obj.new ProcessWithWaitNotify();
		Thread t1 = new Thread(() -> { 
			try {
				process.producer();
			} catch (Exception e) {}
		});
		
		Thread t2 = new Thread(() -> { 
			try {
				process.consumer();
			} catch (Exception e) {}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		System.out.println("Main Thread Existed from Producer.");
		//t2.interrupt();
		t2.join();	// join with 1000mili is not helping to break the blocking of queue.take(). The program is indefinitely.
		
		System.out.println("All done, good to exit.");
		
	}
	
	
	class ProcessWithWaitNotify {
	
		final LinkedList<Integer> data = new LinkedList<Integer>();
		final static int LIMIT = 10;
		final Object LOCK = new Object();
		
		void producer() throws Exception {
			
			int value = 0;
			
			while(true) {
				synchronized(LOCK) {
					
					Thread.sleep(100);
					
					while(data.size() == LIMIT) {
						LOCK.wait();
					}
					
					data.add(++value);
					LOCK.notify();
				}
			}
		}
		
		void consumer() throws Exception {
			
			while(true) {
				synchronized(LOCK) {
					
					Thread.sleep(500);
					
					while(data.size() == 0) {
						LOCK.wait();
					}
					
					System.out.print("List Size is " +data.size());
					int value = data.removeFirst();
					System.out.println("; value is " +value);
					LOCK.notify();
					
					//notify();
					//System.out.println("Notify Called");
					//System.out.println("Now going again to sleep.");
				}
			}
		}
	}
}
