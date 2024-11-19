package com.guides4j.learnspringdata.springdatajpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="courseSpringDataJPA")
public class courseSpringDataJPA {
	
	@Id
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String author;
	
	public courseSpringDataJPA() {
		
	}
	
	public courseSpringDataJPA(long id , String name , String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
}
