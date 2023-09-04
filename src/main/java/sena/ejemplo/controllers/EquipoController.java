package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sena.ejemplo.model._Equipo;
import sena.ejemplo.service.IEquipoService;

@Controller
@SessionAttributes("Equipo")
@RequestMapping("/Equipo")
public class EquipoController {

    @Autowired
    private IEquipoService equipoService;

    // Agregar equipos
    @PostMapping("/add")
    public String add(_Equipo equipo, Model m) {
        equipoService.save(equipo);
        return "redirect:/Equipo/listar";
    }

    // Ruta para formulario de equipos
    @GetMapping(value = "/registrar-equipo")
    public String registrar() {
        return "Equipo/registroEquipo";
    }

    // Ruta consultar / Listar
    @GetMapping(value = "/listar")
    public String listar(Model m) {
        m.addAttribute("equipos", equipoService.findAll());
        return "Equipo/listar";
    }
//Actualizar equipo
        @GetMapping("/ver/{IdEquipo}")
    public String ver(@PathVariable Integer IdEquipo,Model m){
        _Equipo equipo=null;
        if(IdEquipo>0){
            equipo=equipoService.findOne(IdEquipo);
        }else{
            return "redirect:/Equipo/listar";
        }
        m.addAttribute("equipo",equipo);
        m.addAttribute("accion", "Actualizar Equipo");
        return "Equipo/form";
    }


    @GetMapping("/form")     
    public String form(Model m){
        _Equipo equipo=new _Equipo();
        m.addAttribute("equipo", equipo);
        m.addAttribute("accion", "Agregar Equipo");
        return "Equipo/form";
    }

}

