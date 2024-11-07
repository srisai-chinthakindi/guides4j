package com.guides4j.in28.springboot4j.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/getDetails")
public class StudentController {
	
	@Autowired
	private StudentConfiguration studentConfig;
	
	@RequestMapping("/students")
	public List<StudentDetails> stList(){
		return Arrays.asList(
				new StudentDetails(1, "Gopi", "Krishana"),
				new StudentDetails(2, "Srisai", "Chinthakindi"));
	}
	
	@RequestMapping("/studentConfiguration")
	public StudentConfiguration getStudentConfiguration(){
		return studentConfig;
	}
}
