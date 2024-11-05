package com.guides4j.in28.spring.dependencyInjection;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
/*
 * creating a bussiness class and other classes as Dependency in the Same File To Illustrate the Dependecy Injection types
 * 
 */

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Component
class BussinessClass {

//	Field Injection used Reflection which can be Done if the Filed is @AutoWired
//	@Autowired
	private Dependency1 dep1;

//	@Autowired
	private Dependency2 dep2;

//	Setter Injection 
//	@Autowired
//	public void setDep1(Dependency1 dep1) {
//		System.out.println("Setter Injection ");
//		this.dep1 = dep1;
//	}
//
//
//	@Autowired
//	public void setDep2(Dependency2 dep2) {
//		this.dep2 = dep2;
//	}

	public BussinessClass(Dependency1 dep1, Dependency2 dep2) {
		super();
//		System.out.println("Constructor Injection is Being Done Which Doestn't Autowired Annotation");
		this.dep1 = dep1;
		this.dep2 = dep2;
	}
  
	@Override
	public String toString() {
		return "Dependency1 : " + dep1 + " and Dependency2 " + dep2;
	}
}

@Configuration
@ComponentScan
public class DependecyInjection {
	public static void main(String[] args) {
		try (var ctx = new AnnotationConfigApplicationContext(DependecyInjection.class)) {
//			Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(ctx.getBean(BussinessClass.class));
		}
	}
}
