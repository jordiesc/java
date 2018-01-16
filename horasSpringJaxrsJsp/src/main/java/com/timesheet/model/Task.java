package com.timesheet.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String description;

	//bi-directional many-to-one association to Hora
	@OneToMany(mappedBy="task")
	@JsonIgnore
	private List<Hora> horas;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JsonIgnore
	private Project project;

	public Task() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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
		hora.setTask(this);

		return hora;
	}

	public Hora removeHora(Hora hora) {
		getHoras().remove(hora);
		hora.setTask(null);

		return hora;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}