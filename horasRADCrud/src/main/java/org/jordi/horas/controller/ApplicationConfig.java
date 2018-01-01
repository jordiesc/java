/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jordi.horas.controller;

import java.util.Set;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;
import javax.mvc.engine.ViewEngine;

/**
 *
 * @author jordi
 */
@javax.ws.rs.ApplicationPath("resources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }


    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(ViewEngine.VIEW_FOLDER, "/WEB-INF/views");
        return props;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.jordi.horas.controller.HoraController.class);
        resources.add(org.jordi.horas.controller.PerfilController.class);
        resources.add(org.jordi.horas.controller.ProjectoController.class);
        resources.add(org.jordi.horas.controller.TareaController.class);
        resources.add(org.jordi.horas.controller.UsuarioController.class);
        resources.add(org.jordi.horas.controller.util.CustomParamConverterProvider.class);
    }
    
}
