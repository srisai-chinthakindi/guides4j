package com.guides4j.webApplication.todoApplication;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class toDoController {

	@Autowired
	ToDoService toDoService;

	@RequestMapping(value = "todos", method = RequestMethod.GET)
	public String getAllToDos(ModelMap map) {
		if(map.get("todos") == null) {
			map.addAttribute("todos", toDoService.getSampleData());
		}
		return "list-todos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String addToDos(ModelMap map) {
//	one-side binding which will be reflected in list-todos	i,e bean to from	
		map.put("todo",new ToDo(0,"Default Task Name", "Default UserName", LocalDate.now(), false));
		return "addToDo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addingToDosManage(ModelMap map,@Valid @ModelAttribute("todo") ToDo todo,BindingResult result) {
		if(result.hasErrors()) { 
			return "addToDo";
		}
//		two-way binding i,e form to Bean
		toDoService.addToDos(todo);
		return "redirect:todos";
	}
	
	@RequestMapping("delete-todos")
	public String deleteToDo(@RequestParam long id) {
		toDoService.deleteById(id);
		return "redirect:todos";
	}
	
	@RequestMapping(value="update-todos", method = RequestMethod.GET )
	public String updateFromToDo(@RequestParam long id,ModelMap map) {
		ToDo todo = toDoService.findById(id);
		map.addAttribute("todo",todo);
		return "addToDo";
	}
	
	@RequestMapping(value="update-todos", method = RequestMethod.POST )
	public String updateToDo(ModelMap map,@Valid @ModelAttribute("todo") ToDo todo,BindingResult result) {
		if(result.hasErrors()) { 
			return "addToDo";
		}
		toDoService.updateById(todo);
		return "redirect:todos";
	}
	
//	
	

}