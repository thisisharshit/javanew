package com.harshit;

public class Main {

	private static Object lock = new Object();
	
	public static void main(String[] args) {
		Thread t1= new Thread(new Worker(),"Priority 10"); 
		Thread t2= new Thread(new Worker(),"Priority 8"); 
		Thread t3= new Thread(new Worker(),"Priority 6"); 
		Thread t4= new Thread(new Worker(),"Priority 4"); 
		
		t1.setPriority(10);
		t2.setPriority(8);
		t3.setPriority(6);
		t4.setPriority(4);// its only a suggestion to the OS, we cant actually force the OS to run threads in specific order
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
	private static class Worker implements Runnable{
		private int runCount = 1;
		
		@Override
		public void run() {
			for(int i=0;i<100;i++) {
				synchronized (lock) {
					System.out.format("%s: runCount = %d\n",Thread.currentThread().getName(),runCount++);
					// execute critical section of code
				}
			}
		}
		
	}
}
