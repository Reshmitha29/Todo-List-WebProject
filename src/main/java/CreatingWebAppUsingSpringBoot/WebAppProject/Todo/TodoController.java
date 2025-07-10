package CreatingWebAppUsingSpringBoot.WebAppProject.Todo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;
	
	//springboot injects an instance of todoservice into your todo controller. 
	//dependency injection todoservice is  dep to todicntroler to do task --- throgh a constructor

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("todopage")
	public String DisplayTodoList(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("reshu");
		model.addAttribute("todos", todos);
		
		return "todopage" ;
	}

	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username,"Default value",LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(@RequestParam String description, ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "add-todo";
		}
		String username = (String)model.get("name");
		todoService.addTodo(username, description, 
				todo.getTargetDAte(), false);
		return "redirect:/todopage";
	}
	//to delete a todo
	
	@RequestMapping("delete-todo")
	public String DeleteTodoList(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:/todopage" ;
	}
	// ModelMap model is used to display the result from backend(model map carries the data from java controller to view)
	@RequestMapping(value="update-todo" ,method = RequestMethod.GET)
	public String ShowUpdateTodoList(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.FindById(id);
		model.addAttribute("todo", todo);
		return "add-todo" ;
		
	}
		
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
		public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
			
			if(result.hasErrors()) {
				return "add-todo";
			}
			
			String username = (String)model.get("name");
			todo.setUsername(username);
			todoService.updateTodo(todo);
			return "redirect:todopage";
		
	}
	
	

}
