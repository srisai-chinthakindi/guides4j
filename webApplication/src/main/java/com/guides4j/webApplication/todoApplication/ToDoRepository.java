package com.guides4j.webApplication.todoApplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
//	custom method to retrieve 
	List<ToDo> findByCreatedBy(String createdBy);
}
