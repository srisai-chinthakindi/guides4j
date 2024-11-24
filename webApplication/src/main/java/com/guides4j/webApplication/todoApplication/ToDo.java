package com.guides4j.webApplication.todoApplication;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name="tododb")
public class ToDo {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=10, message = "Enter Atleast 10 Characters")
	private String name;
	
	private String createdBy;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private LocalDate createdAt;
	
	private boolean Status;
	
	public ToDo() {
		
	}
	
	

	public ToDo(long id, String name, String createdBy, LocalDate createdAt, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		Status = status;
	}

	@Override
	public String toString() {
		return "ToDo [Id=" + id + ", name=" + name + ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", Status=" + Status + "]";
	}

	public long getId() {
		return  id;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public boolean getStatus() {
		return this.Status;
	}

	public void setStatus(boolean status) {
		this.Status = status;
	}
	
	
	
	
}
