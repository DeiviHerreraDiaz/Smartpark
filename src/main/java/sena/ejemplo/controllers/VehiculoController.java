package sena.ejemplo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sena.ejemplo.model.*;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sena.ejemplo.service.IVehiculoService;

@Controller
@RequestMapping("/Vehiculo")
public class VehiculoController {
    
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IVehiculoService vehiculod;

    // Agregar vehiculos

    @PostMapping("/add")
    public String add(Vehiculo vehiculo, Model m){
        vehiculod.save(vehiculo);
        return "redirect:/Vehiculo/listar";
    }

    // Ruta para formulario de vehiculos

    @GetMapping(value="/registrar-vehiculo")
    public String registrar(){return "vehiculo/registroVehicularGeneral";}

    // Ruta consultar / Listar

    @GetMapping(value="/listar")
    public String listar(Model m){
        m.addAttribute("vehiculo", vehiculod.findAll());
        return "vehiculo/listar";
    }

    

    

    

}
