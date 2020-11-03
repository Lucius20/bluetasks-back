package pierobon.paiva.lucilio.bluetasks.domain.task;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pierobon.paiva.lucilio.bluetasks.domain.user.AppUser;

@Entity
@EntityListeners(TaskListener.class)
public class Task {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message = "A descrição da tarefa é obrigatória.")
	@Length(min = 3, max = 60, message = "O tamanho da descrição é inválido (mín.: 3, máx.: 60).")
	private String description;
	
	@NotNull(message = "A data deve ser informada.")
	@FutureOrPresent(message = "A data não pode ser anterior à data atual.")
	private LocalDate whenToDo;
	
	private boolean done = false;
	
	@ManyToOne
	@JoinColumn(name = "app_user_id")
	@JsonIgnore
	//@NotNull(message = "O usuário da tarefa é obrigatório.")
	private AppUser appUser;
	
	public Task() {
	}

	public Task(String description, LocalDate whenToDo, boolean done) {
		this.description = description;
		this.whenToDo = whenToDo;
		this.done = done;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getWhenToDo() {
		return whenToDo;
	}

	public void setWhenToDo(LocalDate whenToDo) {
		this.whenToDo = whenToDo;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Integer getId() {
		return id;
	}
	
	public AppUser getAppUser() {
		return appUser;
	}
	
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}
