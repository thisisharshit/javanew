package com.example.SIB;

public class StaticInitializationBlock {
	private static final String owner;
	static {
		owner="harshit";
		System.out.println("SIB 1 called");
	}
	public StaticInitializationBlock() {
		System.out.println("constructor called");
	}
	static {
		System.out.println("SIB 2 called");
	}
	public void main() {
		System.out.println("owner is "+owner);
	}
	public static void main(String[] args) {
		StaticInitializationBlock sib=new StaticInitializationBlock();
		sib.main();
		StaticInitializationBlock sib2=new StaticInitializationBlock();
		sib2.main();
	}
}
