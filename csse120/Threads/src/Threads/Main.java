package Threads;

import static Threads.ThreadColor.ANSI_PURPLE;
import static Threads.ThreadColor.ANSI_GREEN;;
public class Main {
	public static void main(String[] args) {
		System.out.println(ANSI_PURPLE+"Hello from the main thread");
		Thread anotherThread = new AnotherThread();
		anotherThread.setName("==Another thread==");
//		anotherThread.run();
		anotherThread.start();
		
		new Thread() {
			public void run() {
				System.out.println(ANSI_GREEN+"hello from anonymous class thread");
			}
		}.start();
		
		//runnable method of doing the above thing
		Thread myrunnableThread=new Thread(new MyRunnable() {
			@Override
			public void run() {
				System.out.println("hello from anonymous class's implementation of  run()");
				try {
					anotherThread.join(2000);
					System.out.println("another thread terminated or timed out, so i'm running again");
				} catch (InterruptedException e) {
					System.out.println("i couldnt wait after all, i was interrupted");
				}
			}
		});
		myrunnableThread.start();
		
//		anotherThread.interrupt();
		
		
		System.out.println("hello again from the main thread");
	}
}
