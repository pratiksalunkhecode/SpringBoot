package com.javamasterlastpractice.MyTodoApp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("Name")
public class TodoController {
	
	private TodoService todoService;
	public TodoController(com.javamasterlastpractice.MyTodoApp.TodoService todoService) {
		super();
		this.todoService = todoService;
	}
		
	@RequestMapping("list-todos")
	public String TodoService(ModelMap model) {
		
		List<Todo> todos = todoService.findByUsername("in28minute");
		model.put("Todos", todos);
		return "Todo";
		
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String shownNewTodoPage(ModelMap model) {	
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "",LocalDate.now().plusYears(0), false);
		model.put("todo", todo);
		return "addtodo";
		
	}
	
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addingNewTodo(ModelMap model, @Valid Todo todo , BindingResult result) {		
		if(result.hasErrors()) {
			return "addtodo";
		}		
		String username = (String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), 
				             todo.getTargateDate(), false);		
		return "redirect:list-todos";	
	}
	
	
	@RequestMapping("delete-todo")
	public String deleteTodos(@RequestParam int id) {
		
		todoService.deleteByid(id);
		return "redirect:list-todos";
		
	}

	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String updateTodos(@RequestParam int id,ModelMap model) {
		
		Todo todo = todoService.findByid(id);
		model.addAttribute("todo", todo);
		return "addtodo";
		
	}
	
	
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo , BindingResult result) {		
		if(result.hasErrors()) {
			return "addtodo";
		}		
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);		
		return "redirect:list-todos";	
	}
	

}
