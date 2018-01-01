package org.jordi.horas.repository;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import org.jordi.horas.domain.Projecto;

@Named("projecto")
public class ProjectoRepository extends AbstractRepository<Projecto, String> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjectoRepository() {
        super(Projecto.class);
    }

}
