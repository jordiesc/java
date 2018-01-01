package org.jordi.horas.repository;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import org.jordi.horas.domain.Perfil;

@Named("perfil")
public class PerfilRepository extends AbstractRepository<Perfil, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilRepository() {
        super(Perfil.class);
    }

}
