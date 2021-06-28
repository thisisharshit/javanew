package com.harshit;

public class Main {
	public static void main(String[] args) {
		PolitePerson jane = new PolitePerson("jane");
		PolitePerson john = new PolitePerson("john");
		
		
		//using the same thread , so wont experience a deadlock
//		jane.sayHello(john);
//		john.sayHello(jane);
		
		System.out.println("--------------------------------");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				jane.sayHello(john);	
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				john.sayHello(jane);
			}
		}).start();;
		
		
		
	}
	
	//Thread1 acquires the lock on jane object and enters the sayHello() method. it prints to the console, then suspends.
	//Thread2 acquires the lock on john object and enters the sayHello() method. it prints to the console, then suspends.
	//Thread1 runs again and wants to say hello back to the john object. it tries to call the sayHelloBack() using the john object
	//that was passed into the sayhello(), but thread2 is holding the john lock, so thread1 suspends.
	//Thread2 runs again and wants to say hello back to the jane object. it tries to call the sayHelloBack() using the jane object
	//that was passed into the sayhello(), but thread1 is holding the jane lock, so thread1 suspends.
		
	
	static class PolitePerson{
		private final String name;
		public PolitePerson(String name) {
			this.name=name;
		}
		public String getName() {
			return name;
		}
		public synchronized void sayHello(PolitePerson person) {
			System.out.format("%s: %s has said hello to me!%n",this.name,person.getName());
			person.sayHelloBack(this);
		}
		public synchronized void sayHelloBack(PolitePerson person) {
			System.out.format("%s: %s has said hello back to me!%n",this.name,person.getName());
		}
	}
}
