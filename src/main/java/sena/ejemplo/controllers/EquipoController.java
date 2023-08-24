package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import sena.ejemplo.model.*;

@Controller
@RequestMapping("/Equipo")
public class EquipoController {
    
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IEquipo equipod;

    // Agregar equipos

    @PostMapping("/add")
    public String add(Equipo equipo, Model m){
        equipod.save(equipo);
        return "redirect:/Equipo/listar";
    }

    // Ruta para formulario de equipos

    @GetMapping(value="/registrar-equipo")
    public String registrar(){
        return "equipo/registroEquipo";
    }

    // Ruta consultar / Listar

    @GetMapping(value="/listar")
    public String listar(Model m){

        m.addAttribute("equipo", equipod.findAll());

        return "equipo/listar";
    }
    
}
