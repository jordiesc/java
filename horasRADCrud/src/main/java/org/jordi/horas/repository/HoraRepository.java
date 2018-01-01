package org.jordi.horas.repository;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import org.jordi.horas.domain.Hora;

@Named("hora")
public class HoraRepository extends AbstractRepository<Hora, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HoraRepository() {
        super(Hora.class);
    }

}
