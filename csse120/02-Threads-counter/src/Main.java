
public class Main {
	public static void main(String[] args) {
		Countdown countdown=new Countdown();
		countdownThread t1= new countdownThread(countdown);
		t1.setName("Thread 1");
		countdownThread t2= new countdownThread(countdown);
		t2.setName("Thread 2");
		
//		Countdown countdown1=new Countdown();
//		Countdown countdown2=new Countdown();
//		countdownThread t1= new countdownThread(countdown1);
//		t1.setName("Thread 1");
//		countdownThread t2= new countdownThread(countdown2);
//		t2.setName("Thread 2");
//		
		
		t1.start();
		t2.start();
	}
}

class Countdown{
	
	private int i;
	
	public synchronized void doCountdown() {
//		String color;
//		switch (Thread.currentThread().getName()) {
//			case "Thread 1":
//				color="cyan";
//				break;
//			case "Thread 2":
//				color="purple";
//				break;
//			default:
//				color="Green";
//		}
		synchronized (this) {
			for(i=10;i>0;i--) {
				System.out.println(Thread.currentThread().getName()+": i ="+i);
			}
		}
		
	}
}
class countdownThread extends Thread{
	private Countdown ThreadCountdown;
	public countdownThread(Countdown countdown) {
		ThreadCountdown=countdown;
	}
	
	public void run() {
		ThreadCountdown.doCountdown();
	}
}