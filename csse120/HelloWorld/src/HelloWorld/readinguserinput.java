package HelloWorld;

import java.util.Scanner;
public class readinguserinput {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String nameString  =scanner.nextLine();
		
		scanner.close();
		System.out.println("your name is: "+nameString);
	}
}
