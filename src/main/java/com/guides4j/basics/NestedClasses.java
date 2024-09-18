package com.guides4j.basics;

public class NestedClasses {
	static String checkStatic = "Accessing Static";
	String checkNonStatic = "Acessing Non Static";

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
//	               Accessing Outer members of the class depends on the Method Signature

			}
		}

		LocalMethodInnerClass local = new LocalMethodInnerClass();
		local.display();
	}

	public static void main(String[] args) {
//		Accesing them 
		NestedClasses.StaticNestedClass st = new NestedClasses.StaticNestedClass();
		st.getDetails();
		NestedClasses nest = new NestedClasses();
		NonStaticNestedClass ns = nest.new NonStaticNestedClass();
		ns.getDetails();
	}
}
