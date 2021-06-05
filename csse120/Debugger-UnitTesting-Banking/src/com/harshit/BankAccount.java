package com.harshit;


public class BankAccount {
	private String firstName;
	private String lastName;
	private double balance;
	public static final int CHECKING=1;
	public static final int SAVINGS=2;
	
	private int accountType;
	
	public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.balance=balance;
		this.accountType=typeOfAccount;
	}
	// THe branch argument is true if the customer is performing the transaction at a branch, with a teller.
	// false if the customer is performing the transaction at an ATM.
	public double deposit(double amount, boolean branch) {
		balance+=amount;
		return balance;
	}
	public double withdraw(double amount, boolean branch) {
		if((amount>500.00) && !branch) {
			throw new IllegalArgumentException();
		}
		balance-=amount;
		return balance;
	}
	
	public double getBalance() {
		return balance;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isChecking() {
		return accountType==CHECKING;
	}
	
	
	
	
}
