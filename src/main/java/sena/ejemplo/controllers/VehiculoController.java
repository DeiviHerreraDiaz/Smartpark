package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sena.ejemplo.model.Vehiculo;
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

    @PostMapping("/add")
    public String add(Vehiculo vehiculo, Model m, RedirectAttributes flash) {

        vehiculod.save(vehiculo);
        flash.addFlashAttribute("success","Vehiculo registrado o actualizado exitosamente");
        return "redirect:/Vehiculo/listar";
    }

    @GetMapping(value = "/registrar-vehiculo")
    public String registrar(Model m) {

        Vehiculo vehiculo = new Vehiculo();

        m.addAttribute("vehiculo", vehiculo);

        return "vehiculo/registroVehicularGeneral";
    }

    @GetMapping(value = "/listar")
    public String listar(Model m) {
        m.addAttribute("vehiculo", vehiculod.findAll());
        return "vehiculo/listar";
    }

    @GetMapping("/ver/{idVehiculo}")
    public String ver(@PathVariable Integer idVehiculo, Model m, RedirectAttributes flash){

        Vehiculo vehiculo = vehiculod.findOne(idVehiculo);

        m.addAttribute("vehiculo", vehiculo);
        flash.addFlashAttribute("success","Vehiculo registrado o actualizado exitosamente");
        return "Vehiculo/registroVehicularGeneral";

    }

    @GetMapping("/updateUserStatus/{idVehiculo}")
    public String updateUserStatus(@PathVariable Integer idVehiculo, RedirectAttributes flash) {
        Vehiculo vehiculo = vehiculod.findOne(idVehiculo);

        if (vehiculo != null) {
            vehiculod.updateEstado(idVehiculo, vehiculo.isEstado());
            System.out.println("This 1 -> " + vehiculo.isEstado());
        }
        flash.addFlashAttribute("success","Se cambio de estado exitosamente exitosamente");
        return "redirect:/Vehiculo/listar";
}

}