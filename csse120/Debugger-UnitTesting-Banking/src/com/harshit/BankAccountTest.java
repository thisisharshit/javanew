package com.harshit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountTest {

	private BankAccount account;
	private static int ct;
	
	@org.junit.BeforeClass // this method must include static keyword
	public static void beforeClass() {
		System.out.println("This execute once before all test cases. ct = "+ ct++);
	}
	
	@org.junit.AfterClass // this method must include static keyword
	public static void afterClass() {
		System.out.println("This execute once after all test cases. ct = "+ct++);
	}
	
	@org.junit.After
	public void teardown() {
		System.out.println("Count = "+ct++);
	}
	
	
	@org.junit.Before // This method will run before every test
	public void setup() {
		account=new BankAccount("Harshit", "Agarwal", 1000.00, BankAccount.CHECKING);
		System.out.println("Running a test...");
	}
	
	@org.junit.Test
	public void deposit() throws Exception{
		double balance=account.deposit(200.00,true);
		assertEquals(1200.00, balance, 0); // Third parameter is accepted diff in expected and actual values
		assertEquals(1200.00,account.getBalance(),0);
	}
	
	@org.junit.Test
	public void withdraw_branch() throws Exception{
		double balance=account.withdraw(600.00, true);
		assertEquals(400.00, balance,0);
	}
	
	@org.junit.Test(expected = IllegalArgumentException.class) // add this para when we except an exception
	public void withdraw_notBranch() throws Exception{
		account.withdraw(600.00, false);
		//assertEquals(400.00, balance,0);
	}

	
	@org.junit.Test
	public void getBalance_deposit() throws Exception{
		account.deposit(200.00,true);
		assertEquals(1200.00, account.getBalance(), 0); // Third parameter is accepted diff in expected and actual values
	}
	
	@org.junit.Test
	public void getBalance_withdraw() throws Exception{
		account.withdraw(200.00,true);
		assertEquals(800.00, account.getBalance(), 0); // Third parameter is accepted diff in expected and actual values	
	}
	
	@org.junit.Test
	public void isChecking_true() {
		assertTrue("The account is not checking acocunt",account.isChecking());
		           // will return above line in case of false
	}
	
	
	
	
	
	
	

}
