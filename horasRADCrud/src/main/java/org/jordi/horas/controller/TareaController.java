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
import org.jordi.horas.domain.Tarea;
import org.jordi.horas.repository.TareaRepository;

/**
 *
 * @author jordi
 */
@Path("tarea")
public class TareaController {

    @Inject
    private Models model;
    @Inject
    private TareaRepository repository;
    @Inject
    private BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @Controller
    public String emptyTarea() {
        return "tarea/create.jsp";
    }

    @POST
    @Path("new")
    @Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createTarea(@Valid
            @BeanParam Tarea tarea) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.create(tarea);
        return "redirect:tarea/list";
    }

    @GET
    @Path("update/{id}")
    @Controller
    public String editTarea(@PathParam("id") String id) {
        model.put("TAREA", repository.find(id));
        return "tarea/update.jsp";
    }

    @POST
    @Path("update")
    @Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateTarea(@Valid
            @BeanParam Tarea tarea) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.edit(tarea);
        return "redirect:tarea/list";
    }

    @GET
    @Path("remove/{id}")
    @Controller
    public String removeTarea(@PathParam("id") String id) {
        repository.remove(repository.find(id));
        return "redirect:tarea/list";
    }

    @GET
    @Path("{id}")
    @Controller
    public String findTarea(@PathParam("id") String id) {
        model.put("TAREA", repository.find(id));
        return "tarea/view.jsp";
    }

    @GET
    @Path("list")
    @Controller
    public String findAllTarea() {
        model.put("TAREA_LIST", repository.findAll());
        return "tarea/list.jsp";
    }
    
}
