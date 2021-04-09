package exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
	public static void main(String[] args){
		try {
			int result=divide();
			System.out.println(result);
		} catch (ArithmeticException|NoSuchElementException e) {
			// TODO: handle exception
			System.out.println(e.toString());
			System.out.println("unable to perform division");
		}
		
		
		
	}
	private static int divide() {
		
		int x,y;
		//try {
			x = getInt();
			y = getInt();
			return x/y;
		/*} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new ArithmeticException("no suitable input");
		}catch (ArithmeticException e) {
			// TODO: handle exception
			throw new ArithmeticException("attempt to divide by zero");
		}*/
		//int x=getInt();
		/*try {
			return x/y;
		} catch (ArithmeticException e) {
			// TODO: handle exception
			throw new ArithmeticException("attempt to divide by zero");
		}*/
	}
	private static int getInt() {
		Scanner s = new Scanner(System.in);
		System.out.println("enter");
		while(true) {
			try {
				return s.nextInt();
			}catch (InputMismatchException e) {
				// TODO: handle exception
				s.nextLine();
				System.out.println("Please enter a number: ");
			}
		}
		
	}
}
