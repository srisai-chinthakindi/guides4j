package com.guides4j.javacore4s;

public class NestedClasses {
	static String checkStatic = "Accessing Static";
	String checkNonStatic = "Acessing Non Static";
//	 both can access the private members of a class
	public static class StaticNestedClass {
//		can have both static and NonStatic variables and Methods
		private final String aboutMe = "StaticNested";

		public void getDetails() {
			System.out.println("Hey Im " + this.aboutMe + " class Type");
			System.out.println(checkStatic);
//			System.out.println(checkNonStatic); we can refer instance blocks -- directly
		}

	}

	public class NonStaticNestedClass {
		private final String aboutMe = "Inner Nested Non Static";

		public void getDetails() {
			System.out.println("Hey Im " + aboutMe + " class Type");
//			Able to acess Static as well as instance members of the outerclass
			System.out.println(checkNonStatic + "\t" + checkStatic);
		}
	}

	public void method() {
		final int localVar = 30;
		int k = 10;

		class LocalMethodInnerClass {
//	        	static String why = "Why im not allowed"; 
//	        	Static variables are associated with the class itself and are shared among all instances of that class. 
//				They are initialized when the class is loaded and exist independently of any object instances.
			public final String InnerClassMember = "Hello";

			void display() {
				// Access final local variable from the enclosing method
				System.out.println(localVar);
//				System.out.println(k);
/*
 *             Accessing the members must be Effectively final or Final  
 *             Due to the following Reasons:
 *             Consistency: Avoiding value changes that could lead to inconsistent behavior.
 *			   Thread Safety: Preventing issues in multithreaded environments where variables might be modified unexpectedly.
 *			   Scope Integrity: Maintaining clarity and predictability by keeping variable values stable within the method’s scope.
 *               
 */

			}
			
		}
		

		LocalMethodInnerClass local = new LocalMethodInnerClass();
		local.display();
		k = 20;
	}

	public static void main(String[] args) {
//		Accesing them 
		NestedClasses.StaticNestedClass st = new NestedClasses.StaticNestedClass();
		st.getDetails();
		NestedClasses nest = new NestedClasses();
		nest.method();
		NonStaticNestedClass ns = nest.new NonStaticNestedClass();
		ns.getDetails();
	}
}
