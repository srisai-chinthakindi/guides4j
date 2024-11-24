package com.guides4j.webApplication.todoApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
//For prototype-1 
@Service
public class ToDoService {
	
	private static int count;
	public static List<ToDo> masterToDos = new ArrayList<>();
	static {
		List<ToDo> todos = new ArrayList<>();
		todos.add(new ToDo(++count,"Walking","srisai",LocalDate.now(),false));
		todos.add(new ToDo(++count,"LeetCode","srisai",LocalDate.now(),false));
		todos.add(new ToDo(++count,"SpringCourse","gopi",LocalDate.now(),true));
		masterToDos.addAll(todos);
	}

	public List<ToDo> getSampleData(String userName){
		Predicate<ToDo> p = item -> item.getCreatedBy().equalsIgnoreCase(userName);
		return masterToDos.stream().filter(p).toList();
	}
	
	public void addToDos(ToDo todo) {
		masterToDos.add(new ToDo(++count,todo.getName(),todo.getCreatedBy(),todo.getCreatedAt(),false));
	}

	public void deleteById(long id) {
		Predicate<ToDo> p = t -> t.getId() == id;
		masterToDos.removeIf(p);
	}
	
	
	public ToDo findById(long id) {
		Predicate<ToDo> p = t -> t.getId() == id;
		return masterToDos.stream().filter(p).findFirst().get();
	}

	public void updateById(@Valid ToDo todo) {
		 deleteById(todo.getId());
		 addToDos(todo);
	}
	
	
}



