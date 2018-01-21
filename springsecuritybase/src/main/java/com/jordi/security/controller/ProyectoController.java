/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordi.security.controller;

import com.jordi.security.domain.Proyecto;
import com.jordi.security.repo.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jordi
 */
@Controller
public class ProyectoController {

    @Autowired
    private ProyectoRepository repositorio;

    @RequestMapping("/proyectos")
    public String getProyectos(Model model) {
        List<Proyecto> proyectos = repositorio.findByUsuario("jordi");
        model.addAttribute("proyectos", proyectos);
        return "/view/proyecto";
    }
}
