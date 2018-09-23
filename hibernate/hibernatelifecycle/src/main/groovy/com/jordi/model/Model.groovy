/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jordi.model

import java.io.Serializable;
import javax.persistence.Basic
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
	@Basic
	@Temporal(TemporalType.DATE)
    Date  creationDate  
}