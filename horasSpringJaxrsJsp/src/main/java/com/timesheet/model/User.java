package com.timesheet.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String name;

	private String password;

	private String surename;

	//bi-directional many-to-one association to Hora
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Hora> horas;

	public User() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurename() {
		return this.surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public List<Hora> getHoras() {
		return this.horas;
	}

	public void setHoras(List<Hora> horas) {
		this.horas = horas;
	}

	public Hora addHora(Hora hora) {
		getHoras().add(hora);
		hora.setUser(this);

		return hora;
	}

	public Hora removeHora(Hora hora) {
		getHoras().remove(hora);
		hora.setUser(null);

		return hora;
	}

}