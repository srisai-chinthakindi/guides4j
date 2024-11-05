package com.guides4j.in28.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloSpringConfig {
	
	@Bean
	public String name() {
		return "Gopi";
	}
	
	@Bean
	public int age() {
		return 10;
	}
	
	@Bean
	@Primary
	Person person() {
		return new Person("Krishana",13, adress());
	}
	
	@Bean
	@Primary
	public Adress adress() {
		return new Adress("Dwaraka","Akanda-Bharath");
	}
	
	
//	Till here we seen how to initialise the Spring Beans and retriving Beans
//	What is we want out Custom Names
	
	@Bean(name = "gopiBeanName")
	public String name2() {
		return "Custom Name";
	}
	
	@Bean
	@Qualifier("mathuraAdress")
	public Adress newAdress() {
		return new Adress("Gokulam","Mathura");
	}

//	What if we want to use the same Beans inside another Bean 
//	For Example if we want to use the Adress name and age in Person
    @Bean
    public Person methodInjection() {
		return person();
	}
//    Like if there are no Candidates or Bean Names with Qualifer Name then it check for the Type in parameter injection
//    Secondly we can able to inject by parameter  
    /*
 Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.guides4j.in28.spring.config.Adress' available: expected single matching bean but found 2: adress,newAdress
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveNotUnique(DependencyDescriptor.java:218)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1420)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1353)
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:911)
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:789)
	... 14 more
	
	This is caused beacuse while parameterised Injection it is checking for randomAdress Bean Name
	So it throws NoUniqueBeanDefinitonException
	Then Checks for the Adress Return Types but if there is and Ambiguity it throws an Error
	To avoid this we can use Qualifier Adress which Adress can be used here 
     */
    @Bean
    public Person personParams(String name, int age,@Qualifier("mathuraAdress") Adress randomAdress) {
    	return new Person(name,age,randomAdress);
    }
    
    @Bean
    public Person qualifierPerson(@Qualifier("mathuraAdress") Adress adress) {
    	return new Person("Krishana",13, adress);
    }
    
    
}


// java 16 feature 
 record Person(String name, int age, Adress adress) {};

 record Adress(String city,String country) {};
