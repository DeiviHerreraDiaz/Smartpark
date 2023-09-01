package sena.ejemplo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sena.ejemplo.model.*;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@SessionAttributes("vehiculo")
@RequestMapping("/vehiculo")
public class VehiculoController {
    
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IVehiculo vehiculod;

    // Agregar vehiculos

    @PostMapping("/add")
    public String add(Vehiculo vehiculo, Model m){
        vehiculod.save(vehiculo);
        return "redirect:/vehiculo/listar";
    }

    // Ruta para formulario de vehiculos

    @GetMapping(value="/registrar-vehiculo")
    public String registrar(){

        return "vehiculo/registroVehicularGeneral";
    }

    // Ruta consultar / Listar

    @GetMapping(value="/listar")
    public String listar(Model m){

        m.addAttribute("vehiculo", vehiculod.findAll());

        return "vehiculo/listar";
    }

                //Actualizar vehiculo
        @GetMapping("/ver/{IdVehiculo}")
    public String ver(@PathVariable Integer IdVehiculo,Model m){
        Vehiculo vehiculo=null;
        if(IdVehiculo>0){
            vehiculo=vehiculod.findOne(IdVehiculo);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("vehiculo",vehiculo);
        m.addAttribute("accion", "Actualizar Equipo");
        return "vehiculo/form";
    }


    @GetMapping("/form")     
    public String form(Model m){
        Vehiculo vehiculo=new Vehiculo();
        m.addAttribute("vehiculo", vehiculo);
        m.addAttribute("accion", "Agregar Cliente");
        return "vehiculo/form";
    }

    

    

}
