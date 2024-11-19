package com.guides4j.learnspringdata.spring_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringJdbcApplication implements CommandLineRunner {
	
	@Autowired
	CourseSpringJdbcRepo courseRepo;

	@Override
	public void run(String...args) throws Exception {
//		courseRepo.insertCourse(new Course(1,"Spring","Sri"));
//		courseRepo.insertCourse(new Course(2,"SpringBoot","Sai"));
//		courseRepo.deleteCourse(Long.valueOf(1));
//		System.out.println(courseRepo.findById(2));
	}

}
