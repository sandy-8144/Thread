package com.programming.threads;

import java.util.concurrent.TimeUnit;
/*
 * When we use volatile keyword with a variable, all the threads read it’s value directly from the memory and don’t cache it. 
 * This makes sure that the value read is the same as in the memory.
 * 
 */
public class StopThreadVolatile {

	private static volatile boolean requestStop;
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() ->  {
			int i =0;
			
			while(!requestStop) {
				System.out.println(i++);
			}
			
			System.out.println("Thread end...");
			
		});
		
		t1.start();
		TimeUnit.SECONDS.sleep(1);
		requestStop=true;

	}
	
	
	
}
