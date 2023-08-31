package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sena.ejemplo.model.*;
import sena.ejemplo.service.*;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/Movimiento")
public class MovimientoController {

    @Autowired
    private IMovimientoService movimientoService;

    @Autowired
    private IEquipoService equipoService;

    @Autowired
    private IVehiculoService vehiculoService;

    @Autowired
    private IEquipo_movimientoService equipoMovimientoService;

    @PostMapping("/add")
    public String add(_Movimiento movimiento, @RequestParam(value = "equipoId", required = false) Integer equipoId) {
        if (equipoId != null) {
            _Equipo equipoSeleccionado = equipoService.findById(equipoId);
            if (equipoSeleccionado != null) {
                List<_Equipo> equipos = new ArrayList<>();
                equipos.add(equipoSeleccionado);
                movimiento.setEquipos(equipos);

                // Save the Movimiento entity first
                movimientoService.save(movimiento);

                // Create Equipo_movimiento record and associate it with the Movimiento
                _Equipo_movimiento equipoMovimiento = new _Equipo_movimiento();
                equipoMovimiento.setEquipo(equipoSeleccionado);
                equipoMovimiento.setMovimiento(movimiento);
                equipoMovimientoService.save(equipoMovimiento);
            }
        } else {
            // Save the Movimiento entity without associated equipment
            movimientoService.save(movimiento);
        }
        return "redirect:/Usuario/listar";
    }

    @PostMapping("/update")
    public String update(_Movimiento movimiento) {
        Optional<_Movimiento> existingMovimiento = movimientoService.findById(movimiento.getIdMovimiento());
        existingMovimiento.ifPresent(mov -> {
            mov.setHoraSalida(movimiento.getHoraSalida());
            mov.setObservaciones(movimiento.getObservaciones());
            movimientoService.save(mov);
        });
        return "redirect:/Usuario/listar"; // Cambiar la URL a la que rediriges después de actualizar un movimiento
    }

    @GetMapping(value = "/listar")
    public String listar(Model m) {
        List<_Movimiento> movimientos = movimientoService.findAll();
        m.addAttribute("movimiento", movimientos);
        return "movimiento/listarMovimiento";
    }

    @GetMapping(value = "/listarEquipoMovimiento")
    public String listarEquipoMovimiento(Model m) {
        List<_Equipo_movimiento> listaEquipoMovimiento = equipoMovimientoService.findAll();
        m.addAttribute("listarEquipoMovimiento", listaEquipoMovimiento);
        return "movimiento/listarEquipoMovimiento.html";
    }


    @GetMapping(value = "/entrada")
    public String entrada(@RequestParam("documento") String documento, Model model) {
        _Equipo equipo = equipoService.findBydocumento(documento);
        _Vehiculo vehiculos = vehiculoService.findBydocumento(documento);


        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("equipo", equipo);
        model.addAttribute("documento", documento);


        return "movimiento/entrada"; // Ajusta la ruta según tu estructura de vistas
    }

    @GetMapping(value = "/salida")
    public String salida(@RequestParam("IdMovimiento") Integer IdMovimiento, Model model) {
        Optional<_Movimiento> movimientoOptional = movimientoService.findById(IdMovimiento);

        if (movimientoOptional.isPresent()) {
            _Movimiento movimiento = movimientoOptional.get();
            _Vehiculo vehiculo = movimiento.getVehiculo();

            model.addAttribute("movimiento", movimiento);
            model.addAttribute("vehiculo", vehiculo);

            return "movimiento/salida"; // Ajusta la ruta según tu estructura de vistas
        } else {
            // Manejar el caso en que el movimiento no se encuentre
            return "redirect:/error"; // Redirige a una página de error o manejo de excepciones
        }
    }


    @GetMapping(value = "/MovimientosUsuario")
    public String MovimientoUsuario(Model m, @RequestParam("documento") String documento, @RequestParam("nombre") String nombre) {
        List<_Movimiento> movimientosFiltrados = movimientoService.findAll().stream()
                .filter(mov -> mov.getDocumento().getDocumento().equals(documento))
                .collect(Collectors.toList());

        m.addAttribute("documento", documento);
        m.addAttribute("nombre", nombre);
        m.addAttribute("movimiento", movimientosFiltrados);
        return "Movimiento/listarMovimientosUsuario";
    }

    @GetMapping(value = "/listarEquipoMovimientoUsuario")
    public String listarEquipoMovimientoUsuario(Model m, @RequestParam("documento") String documento) {
        List<_Equipo_movimiento> listaEquipoMovimiento = equipoMovimientoService.findAll().stream()
                .filter(eq -> eq.getMovimiento().getDocumento().getDocumento().equals(documento))
                .collect(Collectors.toList());
        m.addAttribute("listarEquipoMovimiento", listaEquipoMovimiento);
        return "Movimiento/listarEquipoMovimientoUsuario";
    }

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

