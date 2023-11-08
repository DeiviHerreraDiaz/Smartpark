package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sena.ejemplo.model.Vehiculo;
=======
import org.springframework.web.bind.annotation.*;
import sena.ejemplo.model.Vehiculo;
import sena.ejemplo.repository.vehiculoRepository;
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
import sena.ejemplo.service.IVehiculoService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@RequestMapping("/Vehiculo")
public class VehiculoController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IVehiculoService vehiculod;

<<<<<<< HEAD
    @PostMapping("/add")
    public String add(Vehiculo vehiculo, Model m, RedirectAttributes flash) {

        vehiculod.save(vehiculo);
        flash.addFlashAttribute("success", "Vehiculo registrado o actualizado exitosamente");
        return "redirect:/Vehiculo/listar";
    }

    @GetMapping(value = "/registrar-vehiculo")
    public String registrar(Model m) {

=======
    // Agregar vehiculos

    @PostMapping("/add")
    public String add(Vehiculo vehiculo, Model m) {

        vehiculod.save(vehiculo);

        return "redirect:/Vehiculo/listar";
    }

    // Ruta para formulario de vehiculos

    @GetMapping(value = "/registrar-vehiculo")
    public String registrar(Model m) {
        
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        Vehiculo vehiculo = new Vehiculo();

        m.addAttribute("vehiculo", vehiculo);

        return "vehiculo/registroVehicularGeneral";
    }

<<<<<<< HEAD
=======
    // Ruta consultar / Listar

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @GetMapping(value = "/listar")
    public String listar(Model m) {
        m.addAttribute("vehiculo", vehiculod.findAll());
        return "vehiculo/listar";
    }

<<<<<<< HEAD
    @GetMapping("/ver/{idVehiculo}")
    public String ver(@PathVariable Integer idVehiculo, Model m, RedirectAttributes flash) {
=======
    //Actuazlizar 

    @GetMapping("/ver/{idVehiculo}")
    public String ver(@PathVariable Integer idVehiculo, Model m){
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09

        Vehiculo vehiculo = vehiculod.findOne(idVehiculo);

        m.addAttribute("vehiculo", vehiculo);
<<<<<<< HEAD
        flash.addFlashAttribute("success", "Vehiculo registrado o actualizado exitosamente");
        return "Vehiculo/registroVehicularGeneral";

    }

    @GetMapping("/updateUserStatus/{idVehiculo}")
    public String updateUserStatus(@PathVariable Integer idVehiculo, RedirectAttributes flash) {
=======

        return "Vehiculo/registroVehicularGeneral";

    }
    
    // Cambiar estado

    @GetMapping("/updateUserStatus/{idVehiculo}")
    public String updateUserStatus(@PathVariable Integer idVehiculo) {
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        Vehiculo vehiculo = vehiculod.findOne(idVehiculo);

        if (vehiculo != null) {
            vehiculod.updateEstado(idVehiculo, vehiculo.isEstado());
            System.out.println("This 1 -> " + vehiculo.isEstado());
        }
<<<<<<< HEAD
        flash.addFlashAttribute("success", "Se cambio de estado exitosamente exitosamente");
        return "redirect:/Vehiculo/listar";
=======
        return "redirect:/Vehiculos/listar";
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    }

}