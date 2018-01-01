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
import org.jordi.horas.domain.Usuario;
import org.jordi.horas.repository.UsuarioRepository;

/**
 *
 * @author jordi
 */
@Path("usuario")
public class UsuarioController {

    @Inject
    private Models model;
    @Inject
    private UsuarioRepository repository;
    @Inject
    private BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @Controller
    public String emptyUsuario() {
        return "usuario/create.jsp";
    }

    @POST
    @Path("new")
    @Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createUsuario(@Valid
            @BeanParam Usuario usuario) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.create(usuario);
        return "redirect:usuario/list";
    }

    @GET
    @Path("update/{id}")
    @Controller
    public String editUsuario(@PathParam("id") String id) {
        model.put("USUARIO", repository.find(id));
        return "usuario/update.jsp";
    }

    @POST
    @Path("update")
    @Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateUsuario(@Valid
            @BeanParam Usuario usuario) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        repository.edit(usuario);
        return "redirect:usuario/list";
    }

    @GET
    @Path("remove/{id}")
    @Controller
    public String removeUsuario(@PathParam("id") String id) {
        repository.remove(repository.find(id));
        return "redirect:usuario/list";
    }

    @GET
    @Path("{id}")
    @Controller
    public String findUsuario(@PathParam("id") String id) {
        model.put("USUARIO", repository.find(id));
        return "usuario/view.jsp";
    }

    @GET
    @Path("list")
    @Controller
    public String findAllUsuario() {
        model.put("USUARIO_LIST", repository.findAll());
        return "usuario/list.jsp";
    }
    
}
