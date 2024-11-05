package com.guides4j.in28.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guides4j.in28.spring.gameDemo.GameRunner;



public class XmlConfigurationContextLauncherApplication {
	
	public static void main(String[] args) {

		try (var context = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
			
//			Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
//			
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();

		}
	}
}
