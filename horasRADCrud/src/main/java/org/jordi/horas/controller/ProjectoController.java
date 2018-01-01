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
import org.jordi.horas.domain.Projecto;
import org.jordi.horas.repository.ProjectoRepository;

/**
 *
 * @author jordi
 */
@Path("projecto")
public class ProjectoController {

    @Inject
    private Models model;
    @Inject
    private ProjectoRepository repository;
    @Inject
    private BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @Controller
    public String emptyProjecto() {
        return "projecto/create.jsp";
    }

    @POST
    @Path("new")
    @Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createProjecto(@Valid
            @BeanParam Projecto projecto) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.create(projecto);
        return "redirect:projecto/list";
    }

    @GET
    @Path("update/{id}")
    @Controller
    public String editProjecto(@PathParam("id") String id) {
        model.put("PROJECTO", repository.find(id));
        return "projecto/update.jsp";
    }

    @POST
    @Path("update")
    @Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateProjecto(@Valid
            @BeanParam Projecto projecto) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.edit(projecto);
        return "redirect:projecto/list";
    }

    @GET
    @Path("remove/{id}")
    @Controller
    public String removeProjecto(@PathParam("id") String id) {
        repository.remove(repository.find(id));
        return "redirect:projecto/list";
    }

    @GET
    @Path("{id}")
    @Controller
    public String findProjecto(@PathParam("id") String id) {
        model.put("PROJECTO", repository.find(id));
        return "projecto/view.jsp";
    }

    @GET
    @Path("list")
    @Controller
    public String findAllProjecto() {
        model.put("PROJECTO_LIST", repository.findAll());
        return "projecto/list.jsp";
    }
    
}
