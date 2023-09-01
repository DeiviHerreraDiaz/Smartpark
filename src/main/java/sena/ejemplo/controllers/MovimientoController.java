    package sena.ejemplo.controllers;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

    import sena.ejemplo.model.*;

    @Controller
    @RequestMapping("/Movimiento")
    public class MovimientoController {
        
        @Autowired
        private IMovimiento movimientod;
        @Autowired
        private IVehiculo vehiculod;
        @Autowired
        private IEquipo equipod;
        @Autowired
        private IEquipo_movimiento equipo_movimientod;


        // Registrar entrada formulario

        @GetMapping(value = "/entrada")
        public String entrada(@RequestParam("documento") String documento, Model model){
            
            List<Equipo> equipos = equipod.findBydocumento(documento);
            List<Vehiculo> vehiculos = vehiculod.findBydocumento(documento);
            model.addAttribute("equipos", equipos);
            model.addAttribute("vehiculos", vehiculos); // Agregar la lista de vehículos al modelo
            model.addAttribute("documento", documento);
            return "movimiento/entrada.html";
        }

        // Registrar salida formulario

        @GetMapping(value = "/salida")
        public String salida(@RequestParam("documento") String documento, Model model){
            
            List<Equipo> equipos = equipod.findBydocumento(documento);
            List<Vehiculo> vehiculos = vehiculod.findBydocumento(documento);
            model.addAttribute("equipos", equipos);
            model.addAttribute("vehiculos", vehiculos); // Agregar la lista de vehículos al modelo
            model.addAttribute("documento", documento);
            return "movimiento/salida.html";
        }

        // Agregar movimiento entrada / salida

        @PostMapping("/add")
        public String add(Movimiento movimiento, @RequestParam(value = "equipoId", required = false) Integer equipoId, Model m) {
            if (equipoId != null) {
                Equipo equipoSeleccionado = equipod.findById(equipoId);

                if (equipoSeleccionado != null) {
                    List<Equipo> equipos = new ArrayList<>();
                    equipos.add(equipoSeleccionado);

                    // Guardar el Movimiento y su Equipo correspondiente en la base de datos
                    movimientod.saveMovimientoAndEquipos(movimiento, equipos);
                }
            } else {
                // Si no se proporcionó equipoId, solo guardar el Movimiento en la base de datos
                movimientod.save(movimiento);
            }

            return "redirect:/Usuario/listar";
        }

        @GetMapping(value = "/listar")
        public String listar(Model m){

            m.addAttribute("movimiento", movimientod.findAll());

            return "Movimiento/listarMovimiento";
        }

        @GetMapping(value = "/listarEquipoMovimiento")
        public String listarEquipoMovimiento(Model m){
            List<Equipo_movimiento> listaEquipoMovimiento = equipo_movimientod.findAll();
            m.addAttribute("listarEquipoMovimiento", listaEquipoMovimiento);
            return "Movimiento/listarEquipoMovimiento";
        }







// CONVERSIÓN DE HORA PARA ENTRADA / SALIDA

@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Time.class, new PropertyEditorSupport() {
        @Override
        public void setAsText(String text) {
            setValue(Time.valueOf(text + ":00"));
        }
    });
}


    }