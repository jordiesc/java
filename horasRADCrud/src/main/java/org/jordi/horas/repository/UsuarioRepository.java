package org.jordi.horas.repository;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import org.jordi.horas.domain.Usuario;

@Named("usuario")
public class UsuarioRepository extends AbstractRepository<Usuario, String> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRepository() {
        super(Usuario.class);
    }

}
