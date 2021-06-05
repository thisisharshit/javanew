package com.harshit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.parameterized.*;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {
	
	private BankAccount account;
	private double amount;
	private boolean branch; 
	private double expected;
	
	public BankAccountTestParameterized(double amount, boolean branch, double expected) {
		this.amount = amount;
		this.branch = branch;
		this.expected = expected;
	}
	
	@org.junit.Before
	public void setup(){
		account= new BankAccount("harshit", "agarwal", 1000.00, BankAccount.CHECKING);
		System.out.println("Running a test...");
	}
	
	@Parameters
	public static Collection<Object[]> testConditions(){
		return Arrays.asList(new Object[][] {
			{100.00,true,1100.00},
			{200.00,true,1200.00},
			{325.14,true,1325.14},
			{489.33,true,1489.33},
			{1000.00,true,2000.00}
		});
	}
	
	@org.junit.Test
	public void deposit() throws Exception{
		account.deposit(amount,branch);
		assertEquals(expected, account.getBalance(), 0.01); // Third parameter is accepted diff in expected and actual values
	}

	
}
