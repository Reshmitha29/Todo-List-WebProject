package CreatingWebAppUsingSpringBoot.WebAppProject.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	//Todo is a reference data type here
	private static List<Todo> todos = new ArrayList<>();
	//private static List<type - //todo> name of list //todos = new ArrayList<>();
	private static int todosCount  =0;
	static {
		todos.add(new Todo(++todosCount ,"reshu","aws",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount ,"reshu","jps",LocalDate.now().plusYears(1),false));
	}

	public List<Todo> findByUsername(String username) {
		// TODO Auto-generated method stub
		return todos;
	}
	
	public void addTodo(String username,String description,LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}

	public void deleteById(int id) {
		Predicate<? super Todo> predicate = Todo -> Todo.getId() == id; //bean name //functional code
		// Predicate(type predicate(todo) operation: take a todo object - check if id =ID - result true or false
		// variable -predicate //input -> wat to do with input
		todos.removeIf(predicate);
	}

	public Todo FindById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = Todo -> Todo.getId() == id; 
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
		
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
		// TODO Auto-generated method stub
		
	}

}
