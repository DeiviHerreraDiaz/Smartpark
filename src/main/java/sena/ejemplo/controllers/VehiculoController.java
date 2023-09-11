package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sena.ejemplo.model.Vehiculo;
import sena.ejemplo.repository.vehiculoRepository;
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

    // Agregar vehiculos

    @PostMapping("/add")
    public String add(Vehiculo vehiculo, Model m) {

        vehiculod.save(vehiculo);

        return "redirect:/Vehiculo/listar";
    }

    // Ruta para formulario de vehiculos

    @GetMapping(value = "/registrar-vehiculo")
    public String registrar(Model m) {
        
        Vehiculo vehiculo = new Vehiculo();

        m.addAttribute("vehiculo", vehiculo);

        return "vehiculo/registroVehicularGeneral";
    }

    // Ruta consultar / Listar

    @GetMapping(value = "/listar")
    public String listar(Model m) {
        m.addAttribute("vehiculo", vehiculod.findAll());
        return "vehiculo/listar";
    }

    //Actuazlizar 

    @GetMapping("/ver/{idVehiculo}")
    public String ver(@PathVariable Integer idVehiculo, Model m){

        Vehiculo vehiculo = vehiculod.findOne(idVehiculo);

        m.addAttribute("vehiculo", vehiculo);

        return "Vehiculo/registroVehicularGeneral";

    }
    
    // Cambiar estado

    @GetMapping("/updateUserStatus/{idVehiculo}")
    public String updateUserStatus(@PathVariable Integer idVehiculo) {
        Vehiculo vehiculo = vehiculod.findOne(idVehiculo);

        if (vehiculo != null) {
            vehiculod.updateEstado(idVehiculo, vehiculo.isEstado());
            System.out.println("This 1 -> " + vehiculo.isEstado());
        }
        return "redirect:/Vehiculos/listar";
    }

}