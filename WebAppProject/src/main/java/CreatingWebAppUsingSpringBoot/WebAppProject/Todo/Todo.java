package CreatingWebAppUsingSpringBoot.WebAppProject.Todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class Todo {

	
	@Size(min=10,message ="Enter minimum 10 char")
	private String description;
	private LocalDate targetDAte;
	private boolean done;
	private int id;
	private String username;
	
	//constructor same name class which builds todo objects 
	public Todo(int id, String username, String description, LocalDate targetDAte, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDAte = targetDAte;
		this.done = done;
	}
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getTargetDAte() {
		return targetDAte;
	}


	public void setTargetDAte(LocalDate targetDAte) {
		this.targetDAte = targetDAte;
	}


	public boolean isDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}
	

	@Override
	public String toString() {
		return "todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDAte="
				+ targetDAte + ", done=" + done + "]";
	}

}
