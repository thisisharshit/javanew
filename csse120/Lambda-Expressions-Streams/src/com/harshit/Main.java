package com.harshit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;



public class Main {
	public static void main(String[] args) {
		List<String> someBingoNumbers = Arrays.asList(
				"N40","N36",
				"B12","B6",
				"G53","G49","G60","G50",
				"g77","g78","g89","g50",
				"I26","I17","I29",
				"O71");
		
		List<String> gNum = new ArrayList<String>();
		
		
//		someBingoNumbers.forEach(number->{
//			if(number.toUpperCase().startsWith("G")) {
//				gNum.add(number); // gNum is effectively final as object reference stored in gNum variable doesnot change
////				System.out.println(number);
//			}
//		});
//		
//		gNum.sort((String s1, String s2)->s1.compareTo(s2));
//		gNum.forEach((String s) -> System.out.println(s));
		
		
		// equivalent code of above using Streams
		
		someBingoNumbers
				.stream()
				.map(String::toUpperCase) //OR .map(s->s.toUpperCase())
				   // class::method
				.filter(s->s.startsWith("G"))
				.sorted()
				.forEach(System.out::println); //this forEach method is diff from previously used ones
		Stream<String> ioNumberStream = Stream.of("I26","I27","I29","O71");
		Stream<String> inNumberStream = Stream.of("N40","N46","I26","I17","O71");
		Stream<String> concat = Stream.concat(ioNumberStream, inNumberStream);
		System.out.println("--------------------------------------------");
//		System.out.println(concat.distinct().count());
		System.out.println(concat.distinct().peek(System.out::println).count());
		
		
		
		
		
		Employee john = new Employee("John Doe", 30);
		Employee tim = new Employee("Tim Buchalka",21);
		Employee jack = new Employee("Jack Hill", 40);
		Employee snow = new Employee("Snow White",22);
		
		Department hr = new Department("HR dept");
		hr.addEmployee(john);
		hr.addEmployee(jack);
		hr.addEmployee(snow);
		Department accounting = new Department("Accouting");
		accounting.addEmployee(tim);
		
		List<Department> departments = new ArrayList<Department>();
		departments.add(hr);
		departments.add(accounting);
		
		departments.stream()
					.flatMap(department->department.getEmployees().stream())
					.forEach(System.out::println);
		
		
//		List<String> sortedGNum=someBingoNumbers.stream()
//												.map(String::toUpperCase)
//												.filter(s->s.startsWith("G"))
//												.sorted()
//												.collect(Collectors.toList());
		
		
		// collect method means we have a list and we can continue to work with if wanted to 
		// unlike forEach method which ends a stream and terminal method
		
		
		List<String> sortedGNum=someBingoNumbers.stream()
				.map(String::toUpperCase)
				.filter(s->s.startsWith("G"))
				.sorted()
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		for(String s:sortedGNum) System.out.println(s);
		
		Map<Integer, List<Employee>> groupedByAge = departments.stream()
																.flatMap(department->department.getEmployees().stream())
																.collect(Collectors.groupingBy(e->e.getAge()));
		
		// to get the youngest employee in the stream
		departments.stream().flatMap(department->department.getEmployees().stream())
																			.reduce((e1,e2)->e1.getAge()<e2.getAge()?e1:e2)
																			.ifPresent(System.out::println);
		
		Stream.of("ABC","AC","BAA","CCCC","XY","ST")
				.filter(s->{
					System.out.println(s);
					return s.length()==3;
				}); // we wont get anything printed bcoz stream operation are lazily evaluated
		// streams need a treminal operation to evaluate
		
		// lets add the terminal operation
		Stream.of("ABC","AC","BAA","CCCC","XY","ST")
			.filter(s->{
			System.out.println(s);
			return s.length()==3;
		})
			.count();
		
		
		
		
		
	}
}
