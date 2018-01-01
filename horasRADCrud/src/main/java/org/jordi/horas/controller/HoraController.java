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
import org.jordi.horas.domain.Hora;
import org.jordi.horas.repository.HoraRepository;

/**
 *
 * @author jordi
 */
@Path("hora")
public class HoraController {

    @Inject
    private Models model;
    @Inject
    private HoraRepository repository;
    @Inject
    private BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @Controller
    public String emptyHora() {
        return "hora/create.jsp";
    }

    @POST
    @Path("new")
    @Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createHora(@Valid
            @BeanParam Hora hora) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.create(hora);
        return "redirect:hora/list";
    }

    @GET
    @Path("update/{id}")
    @Controller
    public String editHora(@PathParam("id") Long id) {
        model.put("HORA", repository.find(id));
        return "hora/update.jsp";
    }

    @POST
    @Path("update")
    @Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateHora(@Valid
            @BeanParam Hora hora) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.edit(hora);
        return "redirect:hora/list";
    }

    @GET
    @Path("remove/{id}")
    @Controller
    public String removeHora(@PathParam("id") Long id) {
        repository.remove(repository.find(id));
        return "redirect:hora/list";
    }

    @GET
    @Path("{id}")
    @Controller
    public String findHora(@PathParam("id") Long id) {
        model.put("HORA", repository.find(id));
        return "hora/view.jsp";
    }

    @GET
    @Path("list")
    @Controller
    public String findAllHora() {
        model.put("HORA_LIST", repository.findAll());
        return "hora/list.jsp";
    }
    
}
