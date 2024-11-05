package com.guides4j.javacore4s;

/*
 * Let us Consider a Class Base which has a method show();
 * and Class SubClass which extends A and overrides the Method show();
 * Which looks like
 */
class Base {
	public void show() {
		System.out.println("In Base show");
	}
}

class SubClass extends Base {
	@Override
	public void show() {
		System.out.println("In SubClass show");
	}
}

public class AnonymousClasses {
	public static void main(String[] args) {
		Base ins = new SubClass();
		ins.show(); // op : In SubClass show beacause the method is overridden
		
		/*
		 * But instead of creating a class and overiding the methods we use this concept of 
		 * An Anonymous Inner class to which is able to code with ease 
		 * Similarly work for Interfaces as well
		 * 
		 */
		Base base = new Base() {
			@Override
			public void show() {
				System.out.println("I have overriden the method without new Class in Main ");
			}
			
		};
		base.show();
		
	}
}
