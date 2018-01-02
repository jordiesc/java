/**
 * This file was generated by the Jeddict
 */
package org.jordi.horas.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author jordi
 */
@Entity
public class Hora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Basic

    private double hora;

    @Basic

    private String mes;

    @Basic

    private String referencia;

    @Basic

    private String comentario;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)

    private Date timestamp;

    private String usuario;

    @ManyToOne(targetEntity = Tarea.class)
    private Tarea tarea;

    @ManyToOne(targetEntity = Projecto.class)
    private Projecto projecto;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getHora() {
        return this.hora;
    }

    public void setHora(double hora) {
        this.hora = hora;
    }

    public String getMes() {
        return this.mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Tarea getTarea() {
        return this.tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Projecto getProjecto() {
        return this.projecto;
    }

    public void setProjecto(Projecto projecto) {
        this.projecto = projecto;
    }

}
