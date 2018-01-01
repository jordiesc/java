/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jordi.horas.controller;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.jordi.horas.controller.util.ErrorBean;
import org.jordi.horas.controller.util.ValidationUtil;
import org.jordi.horas.domain.Perfil;
import org.jordi.horas.repository.PerfilRepository;

/**
 *
 * @author jordi
 */
@Path("perfil")
public class PerfilController {

    @Inject
    private Models model;
    @Inject
    private PerfilRepository repository;
    @Inject
    private BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @Controller
    public String emptyPerfil() {
        return "perfil/create.jsp";
    }

    @POST
    @Path("new")
    @Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createPerfil(@Valid
            @BeanParam Perfil perfil) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.create(perfil);
        return "redirect:perfil/list";
    }

    @GET
    @Path("update/{id}")
    @Controller
    public String editPerfil(@PathParam("id") Long id) {
        model.put("PERFIL", repository.find(id));
        return "perfil/update.jsp";
    }

    @POST
    @Path("update")
    @Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updatePerfil(@Valid
            @BeanParam Perfil perfil) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.edit(perfil);
        return "redirect:perfil/list";
    }

    @GET
    @Path("remove/{id}")
    @Controller
    public String removePerfil(@PathParam("id") Long id) {
        repository.remove(repository.find(id));
        return "redirect:perfil/list";
    }

    @GET
    @Path("{id}")
    @Controller
    public String findPerfil(@PathParam("id") Long id) {
        model.put("PERFIL", repository.find(id));
        return "perfil/view.jsp";
    }

    @GET
    @Path("list")
    @Controller
    public String findAllPerfil() {
        model.put("PERFIL_LIST", repository.findAll());
        return "perfil/list.jsp";
    }
    
}
