/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jordi.modelconstrain

import java.io.Serializable;
import javax.persistence.Table
import javax.persistence.UniqueConstraint
import javax.persistence.Basic
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Table(uniqueConstraints=[@UniqueConstraint(columnNames=["name","user"])])
class Post2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
	@Basic
	@Temporal(TemporalType.DATE)
    Date  creationDate 
	String user;
	String description;	 
}

