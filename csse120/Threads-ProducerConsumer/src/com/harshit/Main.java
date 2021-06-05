package com.harshit;
import static com.harshit.Main.EOF;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
public class Main {
	public static final String EOF="EOF";
	public static void main(String[] args) {
		List<String> buffer=new ArrayList<String>();
		
		ReentrantLock bufferlock= new ReentrantLock();
		
		Producer producer=new Producer(buffer,bufferlock);
		Consumer consumer1=new Consumer(buffer,bufferlock);
		Consumer consumer2=new Consumer(buffer,bufferlock);
		
		new Thread(producer).start();
		new Thread(consumer1).start(); //sometimes this consumer will remove the data sometimes other
		new Thread(consumer2).start();
	}
}
class Producer implements Runnable{
	private List<String> buffer;
	private ReentrantLock bufferLock;
	public Producer(List<String> buffer,ReentrantLock bufferLock) {
		this.buffer = buffer;
		this.bufferLock=bufferLock;
	}

	@Override
	public void run() {
		Random random=new Random();
		String[] nums= {"1","2","3","4","5"};
		for(String num:nums) {
			try {
				System.out.println("Adding..."+num);
				
//				synchronized (buffer) {
//					buffer.add(num);
//				}
				
//				bufferLock.lock();
//				buffer.add(num);
//				bufferLock.unlock();
					
				bufferLock.lock();
				try {
					buffer.add(num);
				} finally {
					bufferLock.unlock();
				}
				
				Thread.sleep(random.nextInt(1000));
			} catch (Exception e) {
				System.out.println("Producer was interrupted");
			}
		}
		System.out.println("Adding  EOF and exiting...");
//		synchronized (buffer) {
//			buffer.add(EOF);
//		}
		
//		bufferLock.lock();
//		buffer.add(EOF);
//		bufferLock.unlock();
		
		bufferLock.lock();
		try {
			buffer.add(EOF);
		} finally {
			bufferLock.unlock();
		}

	}
}
class Consumer implements Runnable{
	private List<String> buffer;
	private ReentrantLock bufferLock;
	public Consumer(List<String> buffer,ReentrantLock bufferLock) {
		this.buffer = buffer;
		this.bufferLock=bufferLock;
	}

	@Override
	public void run() {
		int counter=0;
		while(true) {
//			synchronized (buffer) {
//				if(buffer.isEmpty()) {
//					continue;
//				}
//				if(buffer.get(0).equals(EOF)) {
//					System.out.println("Exiting");
//					break;
//				}else {
//					System.out.println("Removed "+buffer.remove(0));
//				}
//			}
			
			if(bufferLock.tryLock()) { //returns true if a lock is available for thread
				
				try {
					if(buffer.isEmpty()) {
//						bufferLock.unlock();
						continue;
					}
					System.out.println("counter = "+counter);
					counter=0;
					if(buffer.get(0).equals(EOF)) {
						System.out.println("Exiting");
//						bufferLock.unlock();
						break;
					}else {
						System.out.println("Removed "+buffer.remove(0));
					}
				} finally {
					bufferLock.unlock();
				}
			}else {
				counter++;
			}
			
		}
		
	}
	
	
}