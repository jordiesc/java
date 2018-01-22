/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordi.security.repo;

import com.jordi.security.domain.Proyecto;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jordi
 */
public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {
    List<Proyecto> findByUsuario(String usuairo);
}
