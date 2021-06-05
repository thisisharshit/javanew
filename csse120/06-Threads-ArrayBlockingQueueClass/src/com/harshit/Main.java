package com.harshit;
import static com.harshit.Main.EOF;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
public class Main {
	public static final String EOF="EOF";
	public static void main(String[] args) {
		ArrayBlockingQueue<String> buffer=new ArrayBlockingQueue<String>(6);
//		ExecutorService executorService = Executors.newFixedThreadPool(3);

		ExecutorService executorService = Executors.newFixedThreadPool(5); //to check future code
		Producer producer=new Producer(buffer);
		Consumer consumer1=new Consumer(buffer);
		Consumer consumer2=new Consumer(buffer);
		
//		new Thread(producer).start();
//		new Thread(consumer1).start(); //sometimes this consumer will remove the data sometimes other
//		new Thread(consumer2).start();
		
		executorService.execute(producer);
		executorService.execute(consumer1);
		executorService.execute(consumer2);
		
		Future<String> future=executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception{
				System.out.println("I'm being printed from callable class");
				return "This is the Callable result";
				
			}
		});
		try {
			System.out.println(future.get());
		} catch (ExecutionException e) {
			System.out.println("Something went wrong");
		}catch (InterruptedException e) {
			System.out.println("Thread running the task  was interrupted"); 
		}
		
		
		executorService.shutdown();
	}
}
class Producer implements Runnable{
	private ArrayBlockingQueue<String> buffer;

	public Producer(ArrayBlockingQueue<String> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		Random random=new Random();
		String[] nums= {"1","2","3","4","5"};
		for(String num:nums) {
			try {
				System.out.println("Adding..."+num);			
				buffer.put(num);
				Thread.sleep(random.nextInt(1000));
			} catch (Exception e) {
				System.out.println("Producer was interrupted");
			}
		}
		System.out.println("Adding  EOF and exiting...");

		try {
			buffer.put(EOF); //put is a thread safe method
		} catch (InterruptedException e) {
			 
		}
		

	}
}
class Consumer implements Runnable{
	private ArrayBlockingQueue<String> buffer;
	public Consumer(ArrayBlockingQueue<String> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		
		while(true) {
			synchronized (buffer) {
				try {
					if(buffer.isEmpty()) {
						continue;
					}
					if(buffer.peek().equals(EOF)) {
						System.out.println("Exiting");
						break;
					}else {
						System.out.println("Removed "+buffer.take());
					}
				} catch (InterruptedException e) {
					
				}
			}
			
		}
			
				
	}
	
	
}