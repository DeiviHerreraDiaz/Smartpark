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
    import java.util.Optional;
    import java.util.stream.Collectors;

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

        // Agregar movimiento entrada / salida

        @PostMapping("/add")
        public String add(Movimiento movimiento, @RequestParam(value = "equipoId", required = false) Integer equipoId, Model m) {
            if (equipoId != null) {
                Optional<Equipo> equipoSeleccionadoOptional = equipod.findById(equipoId);

                if (equipoSeleccionadoOptional.isPresent()) {
                    Equipo equipoSeleccionado = equipoSeleccionadoOptional.get();
                    List<Equipo> equipos = new ArrayList<>();
                    equipos.add(equipoSeleccionado);

                    // Guardar el Movimiento y su Equipo correspondiente en la base de datos
                    movimiento.setEquipos(equipos); // Asegúrate de tener un método setEquipos en la clase Movimiento
                    movimientod.save(movimiento);
                }
            } else {
                // Si no se proporcionó equipoId, solo guardar el Movimiento en la base de datos
                movimientod.save(movimiento);
            }

            return "redirect:/Usuario/listar";
        }



        @PostMapping("/update")
        public String update(Movimiento movimiento, Model model) {
            Movimiento existingMovimiento = movimientod.findById(movimiento.getIdMovimiento());
            existingMovimiento.setHoraSalida(movimiento.getHoraSalida());
            existingMovimiento.setObservaciones(movimiento.getObservaciones());
            movimientod.save(existingMovimiento);
            return "redirect:/Usuario/listar";
        }


//        // Registrar entrada formulario
//
//        @GetMapping(value = "/entrada")
//        public String entrada(@RequestParam("documento") String documento, Model model){
//            Equipo equipo = equipod.findByDocumento(documento);  // Cambio en esta línea
//            List<Vehiculo> vehiculos = vehiculod.findBydocumento(documento);
//            model.addAttribute("equipos", equipo);
//            model.addAttribute("vehiculos", vehiculos);
//            model.addAttribute("documento", documento);
//            return "movimiento/entrada.html";
//        }


//        // Registrar salida formulario
//
//        @GetMapping(value = "/salida")
//        public String salida(@RequestParam("IdMovimiento") Integer IdMovimiento, Model model){
//            Movimiento movimiento = movimientod.findById(IdMovimiento);
//            Vehiculo vehiculo = movimiento.getVehiculo();
//            model.addAttribute("movimiento", movimiento);
//            model.addAttribute("vehiculo", vehiculo);
//            return "movimiento/salida.html";
//        }

        





        // LISTAR DE MOVIMIENTOS EN GENERAL

        @GetMapping(value = "/listar")
        public String listar(Model m){

            m.addAttribute("movimiento", movimientod.findAll());

            return "Movimiento/listarMovimiento";
        }

        // LISTAR DE DETALLES DE EQUIPO EN GENERAL

        @GetMapping(value = "/listarEquipoMovimiento")
        public String listarEquipoMovimiento(Model m){
            List<Equipo_movimiento> listaEquipoMovimiento = equipo_movimientod.findAll();
            m.addAttribute("listarEquipoMovimiento", listaEquipoMovimiento);
            return "Movimiento/listarEquipoMovimiento";
        }

        // MOVIMIENTO DE UN USUARIO EN ESPECIFICO

        @GetMapping(value="/MovimientosUsuario")
        public String MovimientoUsuario(Model m, @RequestParam("documento") String documento,@RequestParam("nombre") String nombre){
            List<Movimiento> movimientosFiltrados = movimientod.findAll().stream()
                .filter(mov -> mov.getDocumento().getDocumento().equals(documento))
                .collect(Collectors.toList());
            
                
            m.addAttribute("documento", documento);
            m.addAttribute("nombre", nombre);
            m.addAttribute("movimiento", movimientosFiltrados);
            return "Movimiento/listarMovimientosUsuario.html";
        }

        // LISTAR DE DETALLES DE EQUIPO EN ESPECIFICO

        @GetMapping(value = "/listarEquipoMovimientoUsuario")
        public String listarEquipoMovimientoUsuario(Model m ,@RequestParam("documento") String documento){
            List<Equipo_movimiento> listaEquipoMovimiento = equipo_movimientod.findAll().stream()
                .filter(eq -> eq.getMovimiento().getDocumento().getDocumento().equals(documento))
                .collect(Collectors.toList());
            m.addAttribute("listarEquipoMovimiento", listaEquipoMovimiento);
            return "Movimiento/listarEquipoMovimientoUsuario.html";
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