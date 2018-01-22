/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordi.security.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author jordi
 */
@Entity
public class Tarea {
    @Id
    @GeneratedValue
    Long Id;

    public Tarea() {
    }
    String code;
    String descripcion;
    String usuario;
    int horas;

    public Tarea(Long Id, String code, String descripcion, String usuario, int horas) {
        this.Id = Id;
        this.code = code;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.horas = horas;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
}
