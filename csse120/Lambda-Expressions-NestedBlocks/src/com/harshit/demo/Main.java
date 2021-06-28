package com.harshit.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		
		new Thread(()->{
			System.out.println("Printing from the runnable");
			System.out.println("Line 2");
			System.out.println("this is line 3");
		}).start();
			
		Employee john = new Employee("John Doe", 30);
		Employee tim = new Employee("Tim Buchalka",21);
		Employee jack = new Employee("Jack Hill", 40);
		Employee snow = new Employee("Snow White",22);
		List<Employee> employees= new ArrayList<Employee>();
		employees.add(john);
		employees.add(tim);
		employees.add(jack);
		employees.add(snow);
		
		
//		Collections.sort(employees, new Comparator<Employee>() {
//			@Override
//			public int compare(Employee employee1, Employee employee2) {
//				return employee1.getName().compareTo(employee2.getName());
//			}
//		});
		
//		Collections.sort(employees, (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));
		//OR
		Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		
		
		for(Employee e:employees) {
			System.out.println(e.getName());
			System.out.println(e.getAge());
		}
		
		employees.forEach(e->{ // forEach method takes a lambda expression
			System.out.println(e.getName());
			System.out.println(e.getAge());
		});
		
		
//		String sillyString = doStringStuff(new UpperConcat() {
//			@Override
//			public String upperAndConcat(String s1, String s2) {
//				return s1.toUpperCase()+" "+ s2.toUpperCase();
//			}
//		}, employees.get(0).getName(), employees.get(0).getName());
		
		UpperConcat uc= (String s1,String s2) -> s1.toUpperCase()+" "+s2.toUpperCase(); 
		String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(0).getName());
		
		System.out.println(sillyString);
		
		AnotherClass anotherClass=new AnotherClass();
		System.out.println(anotherClass.doSomething());
		
	}
	
	public  final static  String doStringStuff(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}
	
}

class Employee{
	private String name;
	private int age;
	public Employee(String name, int age) {
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

interface UpperConcat{
	public String upperAndConcat(String s1, String s2);
	
}

class AnotherClass{
	public String doSomething() {
		System.out.println("The Another class name is "+getClass().getSimpleName());
		
//		return Main.doStringStuff(new UpperConcat() {
//			@Override
//			public String upperAndConcat(String s1, String s2) {
//				System.out.println("The Lambda's Expression class is "+getClass().getSimpleName());
//				String result=s1.toUpperCase()+" "+s2.toUpperCase();
//				return result;
//			}
//		}, "String1", "String2");


//		UpperConcat uc=(s1,s2)->{
//			System.out.println("The Lambda's Expression class name is "+getClass().getSimpleName());
//			return s1.toUpperCase()+" "+s1.toUpperCase();
//		};
//		return Main.doStringStuff(uc, "String1", "String2");
		
		
		final int i=0;
		
		{
			
			UpperConcat uc=new UpperConcat() {
				@Override
				public String upperAndConcat(String s1, String s2) {
					System.out.println("i  within anonymous class "+i); //local variable doesnt belong to anonymous class instance, thats why have to declared final 
					return s1.toUpperCase()+" "+s1.toUpperCase();
				}
			};
				

			System.out.println("The Another class name is "+getClass().getSimpleName());
//			i++; //it can use the local variable without using final as in case with anonymous class
			System.out.println(i);
			return Main.doStringStuff(uc, "String1", "String2");
		}
		
	}
	
	
	public void printValue() {
		int number = 25;
		Runnable r = ()->{
			
			try {
				Thread.sleep(5000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("The value is "+number);
			
		};
		new Thread(r).start();
	}
}
