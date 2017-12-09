/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordi.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author SESCO31
 */
@Entity
public class Proyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    
    String codigo
    String descripcion
    boolean activo

    public Proyecto( codigo,  descripcion,  activo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    
}
