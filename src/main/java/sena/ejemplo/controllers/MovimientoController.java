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

import javax.servlet.http.HttpServletRequest;

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

    List<Integer> Campos = new ArrayList<>(List.of(1));

    @PostMapping("/add")
    public String add(_Movimiento movimiento, @RequestParam(value = "equipoId", required = false) Integer equipoId, HttpServletRequest request) {

    if (equipoId != 0){  

        String[] equipoIds = request.getParameterValues("equipoId");

        if (equipoIds != null && equipoIds.length > 0) {
            List<_Equipo> equipos = new ArrayList<>();
            for (String equipoIdStr : equipoIds) {
                Integer EquipoId = Integer.parseInt(equipoIdStr);
                _Equipo equipoSeleccionado = equipoService.findById(EquipoId);
            if (equipoSeleccionado != null) {
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
        }}
        } else {
            // Save the Movimiento entity without associated equipment
            movimientoService.save(movimiento);
        }

        Campos.clear();
        Campos.add(1);

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

    @PostMapping("/Agregar")
    public String agregar(@RequestParam(value = "campos") int valorCampos, @RequestParam("documento") String documento, Model model) {

        List<_Equipo> equipos = equipoService.findBydocumento(documento);
        List<_Vehiculo> vehiculos = vehiculoService.findBydocumento(documento);

        if (valorCampos > 0 && Campos.size() < equipos.size() && Campos.size() > 0){
            Campos.add(valorCampos);
        } else if (valorCampos > 0 && Campos.size() == equipos.size() && Campos.size() > 0) {
            
        } else if (valorCampos == 0 && Campos.size() > 0) {
            Campos.remove(1);
        }

        model.addAttribute("campos", Campos);
        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("equipos", equipos);
        model.addAttribute("documento", documento);

        return "movimiento/entrada.html";
    }

    @GetMapping(value = "/entrada")
    public String entrada(@RequestParam("documento") String documento, Model model) {
        List<_Equipo> equipos = equipoService.findBydocumento(documento);
        List<_Vehiculo> vehiculos = vehiculoService.findBydocumento(documento);


        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("equipos", equipos);
        model.addAttribute("documento", documento);
        model.addAttribute("campos", Campos);

        return "movimiento/entrada";
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

