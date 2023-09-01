package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import sena.ejemplo.model.*;

@Controller
@SessionAttributes("equipo")
@RequestMapping("/equipo")
public class EquipoController {
    
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IEquipo equipod;

    // Agregar equipos

    @PostMapping("/add")
    public String add(Equipo equipo, Model m){
        equipod.save(equipo);
        return "redirect:/equipo/listar";
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

          //Actualizar equipo
        @GetMapping("/ver/{IdEquipo}")
    public String ver(@PathVariable Integer IdEquipo,Model m){
        Equipo equipo=null;
        if(IdEquipo>0){
            equipo=equipod.findOne(IdEquipo);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("equipo",equipo);
        m.addAttribute("accion", "Actualizar Equipo");
        return "equipo/form";
    }


    @GetMapping("/form")     
    public String form(Model m){
        Equipo equipo=new Equipo();
        m.addAttribute("equipo", equipo);
        m.addAttribute("accion", "Agregar Cliente");
        return "equipo/form";
    }


    
}
