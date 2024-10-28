package com.guides4j.in28.spring.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LearnSpringContext {

	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(HelloSpringConfig.class);
		
//		1. We have launched Spring Context using Configuration Class via AnnotationCofigApplication Context
//		Beacuse Spring Context can be initialised in two ways BeanFactory and ApplicationContext
		
		System.out.println(ctx.getBean("name"));
		System.out.println(ctx.getBean("gopiBeanName"));
		System.out.println(ctx.getBean("methodInjection"));
		
//		Here we are able to access them from the BeanName but we can also access them based on Type
//		You might be getting doubt it might be nonsense but it is possible also 
		/*
		 *
Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.guides4j.in28.spring.config.Person' available: expected single matching bean but found 2: person,methodInjection
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveNamedBean(DefaultListableBeanFactory.java:1312)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveBean(DefaultListableBeanFactory.java:486)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:341)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:334)
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1250)
	at com.guides4j.in28.spring.config.LearnSpringContext.main(LearnSpringContext.java:20)

		*/
//		we might be getting the ambiguity issues to avoid them we have @primary and @Qualifier annotation
		
		System.out.println(ctx.getBean(Adress.class));
		System.out.println(ctx.getBean(Person.class));
		
//		So we are able to call them with the parameters as well
		System.out.println(ctx.getBean("qualifierPerson"));
		System.out.println(ctx.getBean("personParams"));
		
		

		
		
	}
}
