package org.jordi.horas.repository;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import org.jordi.horas.domain.Tarea;

@Named("tarea")
public class TareaRepository extends AbstractRepository<Tarea, String> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TareaRepository() {
        super(Tarea.class);
    }

}
