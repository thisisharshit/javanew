import java.util.Random;


public class Main {
	public static void main(String[] args) {
		Message message=new Message();
		new Thread(new Writer(message)).start();
		new Thread(new Reader(message)).start();
	}
}
class Message{
	private String message;
	private boolean empty=true;
	public synchronized String read() {
		while(empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		empty=true;
		notifyAll();
		return message;
	}
	public synchronized void write(String message) {
		while(!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		empty=false;
		this.message=message;
		notifyAll();
	}
}
//Producer class
class Writer implements Runnable{
	private Message message;
	public Writer(Message message) {
		this.message=message;
	}
	@Override
	public void run() {
		String messages[]= {
				"Humpty Dumpty sat on a wall",
				"Humpty Dumpty had a great fall",
				"All the King's horses and all the king's men",
				"couldn't put Humpty together again"
		};
		Random random=new Random();
		for(int i=0;i<messages.length;i++) {
			message.write(messages[i]);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}	
		}
		message.write("finished");
	}
	
}
//Consumer class
class Reader implements Runnable{
	private Message message;
	public Reader(Message message) {
		this.message=message;
	}
	@Override
	public void run() {
		Random random=new Random();
		for(String latestmessage=message.read();!latestmessage.equals("finished");latestmessage=message.read()) {
			System.out.println(latestmessage);
			try {
				Thread.sleep(random.nextInt(2000)); //returns upto 2 sec
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}