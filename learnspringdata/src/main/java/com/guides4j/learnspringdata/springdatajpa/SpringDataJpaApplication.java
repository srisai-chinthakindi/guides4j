package com.guides4j.learnspringdata.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class SpringDataJpaApplication implements CommandLineRunner {
	
	@Autowired
	private CourseSpirngDataJpaRepo springDataJpaRepo;

	@Override
	public void run(String...args) throws Exception {
		springDataJpaRepo.save(new courseSpringDataJPA(1,"Spring Data","Sri"));
		springDataJpaRepo.save(new courseSpringDataJPA(2,"Spring JPA","Sai"));
		springDataJpaRepo.save(new courseSpringDataJPA(3,"Spring Data JPA	","Sri Sai"));
		
		System.out.println(springDataJpaRepo.findById(2l));
		
		springDataJpaRepo.deleteById(1l);
		
		System.out.println(springDataJpaRepo.findById(1l));
		System.out.println(springDataJpaRepo.findByName("Spring JPA"));
		System.out.println(springDataJpaRepo.findByName("Spring"));
	}

}
