package com.guides4j.javacore4s;

import java.util.List;

public class FunctionalProgramming {
	public static void main(String[] args) {
//		Method References 

		List<Integer> li = List.of(1,2,3,4,5);
		

		//		Static Method References

		//		li.stream().filter(FunctionalProgramming::isEven).forEach(System.out::println);

		//		lamda Function

		//		li.stream().filter(d->d%2==0).forEach(System.out::println);
		
		li.stream()
			.filter(d->d%2==0)
			.map(x->x*x)
			.forEach(System.out::println);
		
		System.out.println(li);
	}
	
//	public static boolean isEven(int n) {
//		return n%2 == 0;
//	}
}
