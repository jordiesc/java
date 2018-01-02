/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordi.horas.repositorio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jordi.horas.domain.Tarea;

/**
 *
 * @author jordi
 */
@Stateless
public class TareaFacade extends AbstractFacade<Tarea> {

    @PersistenceContext(unitName = "myUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TareaFacade() {
        super(Tarea.class);
    }
    
}
