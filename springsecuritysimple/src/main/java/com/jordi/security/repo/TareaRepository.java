/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordi.security.repo;

import com.jordi.security.domain.Tarea;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author jordi
 */
@RepositoryRestResource(path = "tarea")
public interface TareaRepository extends CrudRepository<Tarea,Long> {
    
}
