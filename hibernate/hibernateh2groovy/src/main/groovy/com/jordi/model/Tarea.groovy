/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jordi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 *
 * @author jordi
 */
@Entity
class Tarea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String codigo
    String descripcion
    @ManyToOne
    Proyecto proyecto
	
}

