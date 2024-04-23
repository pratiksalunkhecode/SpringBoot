package com.javamasterlastpractice.MyTodoApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService{
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todoCount = 0;
	
	static {
		
		todos.add(new Todo(++todoCount,"in28minute","Learn Spring boot", LocalDate.now().plusYears(1),true));
		todos.add(new Todo(++todoCount,"in28minute","Learn Spring ", LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todoCount,"in28minute","Learn java", LocalDate.now().plusYears(3),false));	
		
	}
	
	public List<Todo> findByUsername(String username){
		return todos; 
	}

	public void addTodo(String username,String description, LocalDate targatedate, boolean done) {
		Todo todo = new Todo(++todoCount,username,description,targatedate,done);
		todos.add(todo);
	}
	
	public void deleteByid(int id) {		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);		
	}
	
	public Todo findByid(int id) {		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;		
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteByid(todo.getId());
		todos.add(todo);
		
		
	}
	
}
