package Threads;
import static Threads.ThreadColor.ANSI_BLUE;
public class AnotherThread extends Thread{

	@Override
	public void run() {
		System.out.println(ANSI_BLUE+"hello from "+currentThread().getName());
		
		try {
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			System.out.println("another thread woke me up");
			return;
		}
		
		System.out.println("three seconds have passed and I'm awake");
	}
	
}
