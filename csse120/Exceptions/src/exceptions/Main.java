package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*int x=98,y=0;
		System.out.println(divideEAFP(x, y));
		System.out.println(divideLBYL(x, y));
	*/
		int x=getIntLBYL();
		System.out.println(x);
	}
	private static int getInt() {
		Scanner s= new Scanner(System.in);
		return s.nextInt();
	}
	private static int getIntEAFP() {
		Scanner s= new Scanner(System.in);
		System.out.println("please enter an integer");
		try {
			return s.nextInt();
		}
		catch (InputMismatchException e) {
			// TODO: handle exception
			return 0;
		}
	}
	private static int getIntLBYL() {
		Scanner s = new Scanner(System.in);
		boolean isvalid=true;
		System.out.println("please enter an integer");
		String input=s.nextLine();
		for(int i=0;i<input.length();i++) {
			if(!Character.isDigit(input.charAt(i))) {
				isvalid=false;
				break;
			}
		}
		if(isvalid) {
			return Integer.parseInt(input);
			
		}
		return 0;
	}
	private static int divideLBYL(int x, int y) {
		if(y!=0) {
			return x/y;
		}
		else {
			return 0;
		}
	}
	private static int divideEAFP(int x, int y) {
		try {
			return x/y;
		}catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("Comes here");
			return 0;
		}
	}
}
