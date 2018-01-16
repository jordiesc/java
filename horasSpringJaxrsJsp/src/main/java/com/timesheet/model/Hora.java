package com.timesheet.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the hora database table.
 * 
 */
@Entity
@NamedQuery(name="Hora.findAll", query="SELECT h FROM Hora h")
public class Hora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String comment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private BigDecimal hours;

	private int mont;

	private String referencel;

	private int week;

	private int year;

	//bi-directional many-to-one association to Project
	@ManyToOne
	private Project project;

	//bi-directional many-to-one association to Task
	@ManyToOne
	private Task task;

	//bi-directional many-to-one association to UserController
	@ManyToOne
	private User user;

	public Hora() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getHours() {
		return this.hours;
	}

	public void setHours(BigDecimal hours) {
		this.hours = hours;
	}

	public int getMont() {
		return this.mont;
	}

	public void setMont(int mont) {
		this.mont = mont;
	}

	public String getReferencel() {
		return this.referencel;
	}

	public void setReferencel(String referencel) {
		this.referencel = referencel;
	}

	public int getWeek() {
		return this.week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}