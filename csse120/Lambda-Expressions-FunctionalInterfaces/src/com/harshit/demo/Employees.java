package com.harshit.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Employees {
	public static void main(String[] args) {

		Employee john = new Employee("John Doe", 30);
		Employee tim = new Employee("Tim Buchalka",21);
		Employee jack = new Employee("Jack Hill", 40);
		Employee snow = new Employee("Snow White",22);
		List<Employee> employees= new ArrayList<Employee>();
		employees.add(john);
		employees.add(tim);
		employees.add(jack);
		employees.add(snow);
		
		
		
		
		employees.forEach(e->{ // forEach method takes a lambda expression
			System.out.println(e.getName());
			System.out.println(e.getAge());
		});
		
		
		printEmployeeByAge(employees, "Employees over age 30", (e)->e.getAge()>30);
		// predicate,consumer interface doesnot care about the type of parameter being passed
		
		printEmployeeByAge(employees, "Employees younger than 25", new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				return t.getAge()<25;
			}
		});
		
		
		IntPredicate greaterThan15 = (i) -> i>15;
		IntPredicate lessThan100 = (i) -> i<100;
		System.out.println(greaterThan15.test(10));
		int a =10;
		System.out.println(greaterThan15.test(a+5));
		
		
		System.out.println(greaterThan15.and(lessThan100).test(150)); // chaining two predicates
		System.out.println(greaterThan15.and(lessThan100).test(50));
		
		// supplier interface
		// printing 10 random numbers
		
//		Random random = new Random();
//		for(int i=0;i<10;i++) {
//			System.out.println(random.nextInt());
//		}
		
		Random random = new Random();
		Supplier<Integer> randomSupplier = () -> random.nextInt(1000); //supplier doesnot accept a parameter
		for(int i=0;i<10;i++) {
			System.out.println(randomSupplier.get());
		}
		
		
//		employees.forEach(e-> {
//			String lastName = e.getName().substring(e.getName().indexOf(' ')+1);
//			System.out.println("Last Name is: "+lastName);
//		});
		
		
		Function<Employee, String> getLastName = (Employee e)->{
			return e.getName().substring(e.getName().indexOf(' ')+1);
		};
		Function<Employee, String> getFirstName = (Employee e)->{
			return e.getName().substring(0,e.getName().indexOf(' '));
		};
		
		String lastName = getLastName.apply(employees.get(1));
		System.out.println(lastName);
		
		
		Function<Employee, String> upperCase = employee->employee.getName().toUpperCase();
		Function<String, String> FirstName = name -> name.substring(0,name.indexOf(' ')); 
		Function chainedFunction = upperCase.andThen(FirstName); //uppercase fn will be called 1st, then firstName fn will operate on 1st fn  result
		System.out.println(chainedFunction.apply(employees.get(0)));
		
		
		BiFunction<String, Employee, String> concatAge = (String name, Employee e)->{
			return name.concat(" "+e.getAge());
		};
		String upperName=upperCase.apply(employees.get(0));
		System.out.println(concatAge.apply(upperName, employees.get(0)));
		
		
		IntUnaryOperator incby5 = (i) -> i+5;
		System.out.println(incby5.applyAsInt(10));
		
		
	}
	
	private static void printEmployeeByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
		System.out.println(ageText);
		System.out.println("=============");
		for(Employee e:employees) {
			if(ageCondition.test(e)) {
				System.out.println(e.getName());
			}
		}
		System.out.println();
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

