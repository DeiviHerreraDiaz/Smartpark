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
import sena.ejemplo.model._Vehiculo;
import sena.ejemplo.service.IVehiculoService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@SessionAttributes("Vehiculo")
@RequestMapping("/Vehiculo")
public class VehiculoController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IVehiculoService vehiculod;

    // Agregar vehiculos

    @PostMapping("/add")
    public String add(_Vehiculo vehiculo, Model m) {
        vehiculod.save(vehiculo);
        return "redirect:/Vehiculo/listar";
    }

    // Ruta para formulario de vehiculos

    @GetMapping(value = "/registrar-vehiculo")
    public String registrar() {
        return "vehiculo/registroVehicularGeneral";
    }

    // Ruta consultar / Listar

    @GetMapping(value = "/listar")
    public String listar(Model m) {
        m.addAttribute("vehiculo", vehiculod.findAll());
        return "vehiculo/listar";
    }

            //Actualizar equipo
        @GetMapping("/ver/{IdVehiculo}")
    public String ver(@PathVariable Integer IdVehiculo,Model m){
        _Vehiculo vehiculo=null;
        if(IdVehiculo>0){
            vehiculo=vehiculod.findOne(IdVehiculo);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("vehiculo",vehiculo);
        m.addAttribute("accion", "Actualizar Vehiculo");
        return "Vehiculo/form";
    }


    @GetMapping("/form")     
    public String form(Model m){
        _Vehiculo vehiculo=new _Vehiculo();
        m.addAttribute("vehiculo", vehiculo);
        m.addAttribute("accion", "Agregar Cliente");
        return "Vehiculo/form";
    }

                @GetMapping("/updateUserStatus/{idVehiculo}")
    public String updateUserStatus(@PathVariable Integer idVehiculo) {
        _Vehiculo vehiculo = vehiculod.findOne(idVehiculo);

        if (vehiculo != null) {
            vehiculod.updateEstado(idVehiculo, vehiculo.isEstado());
            System.out.println("This 1 -> " + vehiculo.isEstado());
        }
        return "redirect:/Equipo/listar";
    }


}
