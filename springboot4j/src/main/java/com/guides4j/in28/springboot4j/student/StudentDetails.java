package com.guides4j.in28.springboot4j.student;

public class StudentDetails {
	
	private int id;
	
	private String FirstName ;
	
	private String LastName;

	public StudentDetails(int id, String firstName, String lastName) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
	}


	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}
	
	
}
