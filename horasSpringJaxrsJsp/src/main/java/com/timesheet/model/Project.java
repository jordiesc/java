package com.timesheet.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private byte active;

	private String description;

	//bi-directional many-to-one association to Hora
	@OneToMany(mappedBy="project")
	@JsonIgnore
	private List<Hora> horas;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="project")
	@JsonIgnore
	private List<Task> tasks;

	public Project() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Hora> getHoras() {
		return this.horas;
	}

	public void setHoras(List<Hora> horas) {
		this.horas = horas;
	}

	public Hora addHora(Hora hora) {
		getHoras().add(hora);
		hora.setProject(this);

		return hora;
	}

	public Hora removeHora(Hora hora) {
		getHoras().remove(hora);
		hora.setProject(null);

		return hora;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setProject(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setProject(null);

		return task;
	}

}