package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sena.ejemplo.model.Equipo;
import sena.ejemplo.model.Equipo_movimiento;
import sena.ejemplo.model.Movimiento;
import sena.ejemplo.model.Vehiculo;
import sena.ejemplo.service.IEquipoService;
import sena.ejemplo.service.IEquipo_movimientoService;
import sena.ejemplo.service.IMovimientoService;
import sena.ejemplo.service.IVehiculoService;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/Movimiento")
public class MovimientoController {

    List<Integer> Campos = new ArrayList<>(List.of(1));
    @Autowired
    private IMovimientoService movimientoService;
    @Autowired
    private IEquipoService equipoService;
    @Autowired
    private IVehiculoService vehiculoService;
    @Autowired
    private IEquipo_movimientoService equipoMovimientoService;

    @PostMapping("/add")
    public String add(Movimiento movimiento, @RequestParam(value = "equipoId", required = false) List<Integer> equipoIds, RedirectAttributes flash) {

        if (equipoIds != null && !equipoIds.isEmpty()) {
            List<Equipo> equipos = new ArrayList<>();
            for (Integer equipoId : equipoIds) {
                Equipo equipoSeleccionado = equipoService.findById(equipoId);
                if (equipoSeleccionado != null) {
                    equipos.add(equipoSeleccionado);
                    movimiento.setEquipos(equipos);


                    movimientoService.save(movimiento);


                    Equipo_movimiento equipoMovimiento = new Equipo_movimiento();
                    equipoMovimiento.setEquipo(equipoSeleccionado);
                    equipoMovimiento.setMovimiento(movimiento);
                    equipoMovimientoService.save(equipoMovimiento);
                }
            }
        } else {

            movimientoService.save(movimiento);

        }

        Campos.clear();
        Campos.add(1);
        flash.addFlashAttribute("success", "Movimiento registrado  exitosamente");

        return "redirect:/Usuario/listar";
    }

    @PostMapping("/update")
    public String update(Movimiento movimiento, RedirectAttributes flash) {
        Optional<Movimiento> existingMovimiento = movimientoService.findById(movimiento.getIdMovimiento());
        existingMovimiento.ifPresent(mov -> {
            mov.setHoraSalida(movimiento.getHoraSalida());
            mov.setObservaciones(movimiento.getObservaciones());
            movimientoService.save(mov);
        });
        flash.addFlashAttribute("success", "Movimiento actualizado exitosamente");

        return "redirect:/Usuario/listar";
    }

    @GetMapping(value = "/listar")
    public String listar(Model m) {
        List<Movimiento> movimientos = movimientoService.findAll();
        m.addAttribute("movimiento", movimientos);
        return "movimiento/listarMovimiento";
    }

    @GetMapping(value = "/listarEquipoMovimiento")
    public String listarEquipoMovimiento(Model m) {
        List<Equipo_movimiento> listaEquipoMovimiento = equipoMovimientoService.findAll();
        m.addAttribute("listarEquipoMovimiento", listaEquipoMovimiento);
        return "movimiento/listarEquipoMovimiento.html";
    }

    @PostMapping("/Agregar")
    public String agregar(@RequestParam(value = "campos") int valorCampos, @RequestParam("documento") String documento, Model model, RedirectAttributes flash) {

        List<Equipo> equipos = equipoService.findBydocumento(documento);
        List<Vehiculo> vehiculos = vehiculoService.findBydocumento(documento);

        if (valorCampos > 0 && Campos.size() < equipos.size() && Campos.size() > 0) {
            Campos.add(valorCampos);
        } else if (valorCampos > 0 && Campos.size() == equipos.size() && Campos.size() > 0) {

        } else if (valorCampos == 0 && Campos.size() > 0) {
            Campos.remove(1);
        }

        model.addAttribute("campos", Campos);
        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("equipos", equipos);
        model.addAttribute("documento", documento);

        flash.addFlashAttribute("success", "Entrada registrada exitosamente");

        return "movimiento/entrada.html";
    }

    @GetMapping(value = "/entrada")
    public String entrada(@RequestParam("documento") String documento, Model model, RedirectAttributes flash) {
        List<Equipo> equipos = equipoService.findBydocumento(documento);
        List<Vehiculo> vehiculos = vehiculoService.findBydocumento(documento);


        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("equipos", equipos);
        model.addAttribute("documento", documento);
        model.addAttribute("campos", Campos);
        return "movimiento/entrada";
    }

    @GetMapping(value = "/salida")
    public String salida(@RequestParam("IdMovimiento") Integer IdMovimiento, Model model, RedirectAttributes flash) {
        Optional<Movimiento> movimientoOptional = movimientoService.findById(IdMovimiento);

        if (movimientoOptional.isPresent()) {
            Movimiento movimiento = movimientoOptional.get();
            Vehiculo vehiculo = movimiento.getVehiculo();
            List<Equipo_movimiento> equipoMovimientoList = equipoMovimientoService.findByMovimiento(movimiento);

            model.addAttribute("equipoMovimientoList", equipoMovimientoList);
            model.addAttribute("movimiento", movimiento);
            model.addAttribute("vehiculo", vehiculo);
            flash.addFlashAttribute("success", "Salida registrada exitosamente");

            return "movimiento/salida";
        } else {

            return "redirect:/error";
        }
    }

    @GetMapping(value = "/MovimientosUsuario")
    public String MovimientoUsuario(Model m, @RequestParam("documento") String documento, @RequestParam("nombre") String nombre, RedirectAttributes flash) {
        List<Movimiento> movimientosFiltrados = movimientoService.findAll().stream()
                .filter(mov -> mov.getDocumento().getDocumento().equals(documento) && mov.getHoraSalida() == null)
                .collect(Collectors.toList());

        m.addAttribute("documento", documento);
        m.addAttribute("nombre", nombre);
        m.addAttribute("movimiento", movimientosFiltrados);


        return "Movimiento/listarMovimientosUsuario";
    }

    @GetMapping(value = "/listarEquipoMovimientoUsuario")
    public String listarEquipoMovimientoUsuario(Model m, @RequestParam("documento") String documento,@RequestParam("nombre") String nombre, @RequestParam("IdMovimiento") Integer IdMovimiento) {
        List<Equipo_movimiento> listaEquipoMovimiento = equipoMovimientoService.findAll().stream()
                .filter(eq -> eq.getMovimiento().getDocumento().getDocumento().equals(documento) && eq.getMovimiento().getIdMovimiento() == IdMovimiento)
                .collect(Collectors.toList());

        m.addAttribute("Mensaje", "MENSAJE");
        m.addAttribute("IdMovimiento", IdMovimiento);
        m.addAttribute("nombre", nombre);
        m.addAttribute("listarEquipoMovimiento", listaEquipoMovimiento);
        return "Movimiento/listarEquipoMovimientoUsuario";
    }



    @GetMapping(value = "/listarMovimientosCompletados")
    public String listarMovimientosCompletados(Model m, @RequestParam("documento") String documento, @RequestParam("nombre") String nombre) {

        List<Movimiento> movimientosFiltrados = movimientoService.findAll().stream()
                .filter(mov -> mov.getDocumento().getDocumento().equals(documento) && mov.getHoraSalida() != null)
                .collect(Collectors.toList());

        m.addAttribute("documento", documento);
        m.addAttribute("nombre", nombre);
        m.addAttribute("movimiento", movimientosFiltrados);

        // Retorna la vista
        return "Movimiento/listarMovimientosUsuarioCompleto";
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