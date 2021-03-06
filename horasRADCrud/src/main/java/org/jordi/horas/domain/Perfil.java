/**
 * This file was generated by the Jeddict
 */
package org.jordi.horas.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.ws.rs.FormParam;

/**
 * @author jordi
 */
@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @FormParam("id")
    private Long id;

    @Basic
    @FormParam("code")
    private String code;

    @Basic
    @FormParam("descripcion")
    private String descripcion;

    @ManyToMany(targetEntity = Usuario.class, mappedBy = "perfils")
    private List<Usuario> usuarios;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addUsuario(Usuario usuario) {
        getUsuarios().add(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        getUsuarios().remove(usuario);
    }

}