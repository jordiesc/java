/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordi.horas.repositorio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jordi.horas.domain.Hora;

/**
 *
 * @author jordi
 */
@Stateless
public class HoraFacade extends AbstractFacade<Hora> {

    @PersistenceContext(unitName = "myUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HoraFacade() {
        super(Hora.class);
    }
    
}
