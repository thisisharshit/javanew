package HelloWorld;

public class bankaccount {
	private String accno;
	private double balance;
	private String name,email,phone;
	
	public bankaccount() {
		System.out.println("empty constructor");
	}
	public bankaccount(String accno, double balance, String name, String email, String phone) {
		this.accno=accno;
		this.balance=balance;
		this.name=name;
		this.email=email;
		this.phone=phone;
	}
	
	
	
	
	public void deposit(double depositamt) {
		this.balance+=depositamt;
		System.out.println("deposit of "+ depositamt+" processed. Updated balance = "+ balance);
	}
	public void withdraw(double withdrawamt) {
		if(balance>=withdrawamt) {
			this.balance-=withdrawamt;
			System.out.println("withdrawal of "+withdrawamt+" proceessed, remaining balance = "+balance);
			
		}
		else {
			System.out.println("only "+balance+" available for withdrawal");
		}
	}
	
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
