package com.programming.threads;

import java.util.concurrent.TimeUnit;

public class StopThread {

	private static boolean requestStop;
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() ->  {
			int i =0;
			
			while(!stopRequested()) {
				System.out.println(i++);
			}
			
			
		});
		
		t1.start();
		TimeUnit.SECONDS.sleep(1);
		requestStop();

	}
	
	private static synchronized void requestStop() {
		requestStop = true;
	}
	
	private static synchronized boolean stopRequested() {
		return requestStop;
	}

}
