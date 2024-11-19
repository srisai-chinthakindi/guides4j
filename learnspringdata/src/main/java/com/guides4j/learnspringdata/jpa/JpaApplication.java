package com.guides4j.learnspringdata.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JpaApplication implements CommandLineRunner {
	
	@Autowired
	private JpaRepo jpaRepo;
	
	@Override
	public void run(String...args) throws Exception {
//		jpaRepo.insertCourse(new Course(1,"Java","Sri"));
//		jpaRepo.insertCourse(new Course(2,"Java JPA","Sai"));
//		jpaRepo.insertCourse(new Course(3,"Java Hibernate","Sri Sai"));
//		
//		System.out.println(jpaRepo.findCourseById(2));
//		
//		jpaRepo.deleteCourseById(1);
//		
//		System.out.println(jpaRepo.findCourseById(1));
		
		
	}

}
