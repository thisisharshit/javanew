package HelloWorld;

public class Main extends Object{
	public static void main(String args[]) {
		/*car porshe;
		porshe= new car();
		car holden = new car();
		porshe.setmodel("carrera");
		System.out.println(porshe.getmodel());
		*/
		
		bankaccount harshit = new bankaccount("1234",1232,"harshit","zyx.com","1234");
		System.out.println(harshit.getBalance());
		harshit.withdraw(100.0);
		harshit.deposit(50);
		harshit.withdraw(50);
		
	}
}

