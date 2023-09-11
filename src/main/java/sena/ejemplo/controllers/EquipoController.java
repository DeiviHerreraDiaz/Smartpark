package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sena.ejemplo.model.Equipo;
import sena.ejemplo.service.IEquipoService;

@Controller
@RequestMapping("/Equipo")
public class EquipoController {

    @Autowired
    private IEquipoService equipod;

    // Agregar equipos
    @PostMapping("/add")
    public String add(Equipo equipo, Model m) {

        equipod.save(equipo);

        return "redirect:/Equipo/listar";
    }

    // Ruta para formulario de equipos
    @GetMapping(value = "/registrar-equipo")
    public String registrar(Model m) {

        Equipo equipo = new Equipo();

        m.addAttribute("equipo", equipo);

        return "equipo/registroEquipo";
    }

    // Ruta consultar / Listar
    @GetMapping(value = "/listar")
    public String listar(Model m) {
        m.addAttribute("equipos", equipod.findAll());
        return "equipo/listar";
    }

//Actualizar

@GetMapping("/ver/{idEquipo}")
public String ver(@PathVariable Integer idEquipo, Model m){

    Equipo equipo = equipod.findById(idEquipo);

    m.addAttribute("equipo", equipo);

    return "Equipo/registroEquipo";

}

    // Cambiar estado

    @GetMapping("/updateUserStatus/{idEquipo}")
    public String updateUserStatus(@PathVariable Integer idEquipo) {
        Equipo equipo = equipod.findById(idEquipo);

        if (equipo != null) {
            equipod.updateEstado(idEquipo, equipo.isEstado());
            System.out.println("This 1 -> " + equipo.isEstado());
        }
        return "redirect:/Equipo/listar";
    }

}

