package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
import sena.ejemplo.model.Equipo;
import sena.ejemplo.service.IEquipoService;

@Controller
@RequestMapping("/Equipo")
public class EquipoController {

    @Autowired
    private IEquipoService equipod;

<<<<<<< HEAD

    @PostMapping("/add")
    public String add(Equipo equipo, Model m, RedirectAttributes flash) {

        equipod.save(equipo);
        flash.addFlashAttribute("success", "Equipo registrado o actualizado exitosamente");
        return "redirect:/Equipo/listar";
    }

=======
    // Agregar equipos
    @PostMapping("/add")
    public String add(Equipo equipo, Model m) {

        equipod.save(equipo);

        return "redirect:/Equipo/listar";
    }

    // Ruta para formulario de equipos
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @GetMapping(value = "/registrar-equipo")
    public String registrar(Model m) {

        Equipo equipo = new Equipo();

        m.addAttribute("equipo", equipo);

        return "equipo/registroEquipo";
    }

<<<<<<< HEAD
=======
    // Ruta consultar / Listar
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @GetMapping(value = "/listar")
    public String listar(Model m) {
        m.addAttribute("equipos", equipod.findAll());
        return "equipo/listar";
    }

<<<<<<< HEAD
    @GetMapping("/ver/{idEquipoww}")
    public String ver(@PathVariable Integer idEquipo, Model m, RedirectAttributes flash) {

        Equipo equipo = equipod.findById(idEquipo);

        m.addAttribute("equipo", equipo);
        flash.addFlashAttribute("success", "Equipo registrado o actualizado exitosamente");
        return "Equipo/registroEquipo";

    }

    @GetMapping("/updateUserStatus/{idEquipo}")
    public String updateUserStatus(@PathVariable Integer idEquipo, RedirectAttributes flash) {
=======
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
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        Equipo equipo = equipod.findById(idEquipo);

        if (equipo != null) {
            equipod.updateEstado(idEquipo, equipo.isEstado());
            System.out.println("This 1 -> " + equipo.isEstado());
        }
<<<<<<< HEAD
        flash.addFlashAttribute("success", "Se cambio de estado exitosamente");
        return "redirect:/Equipo/listar";
    }

}
=======
        return "redirect:/Equipo/listar";
    }

}

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
