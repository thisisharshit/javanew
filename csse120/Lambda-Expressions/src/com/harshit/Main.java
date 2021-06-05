package com.harshit;

public class Main {
	public static void main(String[] args) {
//		new Thread(new codeToRun()).start();
		
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Printing from the runnable");
//			}
//		}).start();
		
//		new Thread(()->System.out.println("Printing from the runnable")).start();
		
		//having multiple lines of code in runnable implementation
		
		new Thread(()->{
			System.out.println("Printing from the runnable");
			System.out.println("Line 2");
			System.out.println("this is line 3");
		}).start();
			
		
	}
	
}

class codeToRun implements Runnable{

	@Override
	public void run() {
		System.out.println("Printing from the runnable");	
	}
	
}