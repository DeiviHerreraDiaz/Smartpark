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
    private IEquipoService equipoService;

    // Agregar equipos
    // aqui agregamos
    @PostMapping("/add")
    public String add(Equipo equipo, Model m) {
        equipoService.save(equipo);
        return "redirect:/Equipo/listar";
    }

    // Ruta para formulario de equipos
    @GetMapping(value = "/registrar-equipo")
    public String registrar() {
        return "equipo/registroEquipo";
    }

    // Ruta consultar / Listar
    @GetMapping(value = "/listar")
    public String listar(Model m) {
        m.addAttribute("equipos", equipoService.findAll());
        return "equipo/listar";
    }
//Actualizar equipo
//Actualizacion
        @GetMapping("/ver/{IdEquipo}")
    public String ver(@PathVariable Integer IdEquipo,Model m){
        Equipo equipo=null;
        if(IdEquipo>0){
            equipo=equipoService.findById(IdEquipo);
        }else{
            return "redirect:/Equipo/listar";
        }
        m.addAttribute("equipo",equipo);
        m.addAttribute("accion", "Actualizar Equipo");
        return "Equipo/form";
    }


    @GetMapping("/form")     
    public String form(Model m){
        Equipo equipo=new Equipo();
        m.addAttribute("equipo", equipo);
        m.addAttribute("accion", "Agregar Equipo");
        return "Equipo/form";
    }

            @GetMapping("/updateUserStatus/{idEquipo}")
    public String updateUserStatus(@PathVariable Integer idEquipo) {
        Equipo equipo = equipoService.findById(idEquipo);

        if (equipo != null) {
            equipoService.updateEstado(idEquipo, equipo.isEstado());
            System.out.println("This 1 -> " + equipo.isEstado());
        }
        return "redirect:/Equipo/listar";
    }

}

