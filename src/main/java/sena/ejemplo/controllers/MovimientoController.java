package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
import sena.ejemplo.model.Equipo;
import sena.ejemplo.model.Equipo_movimiento;
import sena.ejemplo.model.Movimiento;
import sena.ejemplo.model.Vehiculo;
import sena.ejemplo.service.IEquipoService;
import sena.ejemplo.service.IEquipo_movimientoService;
import sena.ejemplo.service.IMovimientoService;
import sena.ejemplo.service.IVehiculoService;

<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletRequest;
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletRequest;

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
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

<<<<<<< HEAD
    @PostMapping("/add")
    public String add(Movimiento movimiento, @RequestParam(value = "equipoId", required = false) List<Integer> equipoIds, RedirectAttributes flash) {
=======
    List<Integer> Campos = new ArrayList<>(List.of(1));

    @PostMapping("/add")
<<<<<<< HEAD
    public String add(Movimiento movimiento, @RequestParam(value = "equipoId", required = false) List<Integer> equipoIds) {
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09

        if (equipoIds != null && !equipoIds.isEmpty()) {
            List<Equipo> equipos = new ArrayList<>();
            for (Integer equipoId : equipoIds) {
                Equipo equipoSeleccionado = equipoService.findById(equipoId);
<<<<<<< HEAD
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

=======
=======
    public String add(_Movimiento movimiento, @RequestParam(value = "equipoId", required = false) Integer equipoId, HttpServletRequest request) {

    if (equipoId != 0){  

        String[] equipoIds = request.getParameterValues("equipoId");

        if (equipoIds != null && equipoIds.length > 0) {
            List<_Equipo> equipos = new ArrayList<>();
            for (String equipoIdStr : equipoIds) {
                Integer EquipoId = Integer.parseInt(equipoIdStr);
                _Equipo equipoSeleccionado = equipoService.findById(EquipoId);
>>>>>>> 7979a17fed079a6407b7ad1d2cac60915ff9c44b
            if (equipoSeleccionado != null) {
                equipos.add(equipoSeleccionado);
                movimiento.setEquipos(equipos);

                // Save the Movimiento entity first
                movimientoService.save(movimiento);

                // Create Equipo_movimiento record and associate it with the Movimiento
                Equipo_movimiento equipoMovimiento = new Equipo_movimiento();
                equipoMovimiento.setEquipo(equipoSeleccionado);
                equipoMovimiento.setMovimiento(movimiento);
                equipoMovimientoService.save(equipoMovimiento);
            }
<<<<<<< HEAD
        }
=======
        }}
>>>>>>> 7979a17fed079a6407b7ad1d2cac60915ff9c44b
        } else {
            // Save the Movimiento entity without associated equipment
            movimientoService.save(movimiento);
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        }

        Campos.clear();
        Campos.add(1);
<<<<<<< HEAD
        flash.addFlashAttribute("success", "Movimiento registrado  exitosamente");
=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09

        return "redirect:/Usuario/listar";
    }

<<<<<<< HEAD
    @PostMapping("/update")
    public String update(Movimiento movimiento, RedirectAttributes flash) {
=======

    @PostMapping("/update")
    public String update(Movimiento movimiento) {
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        Optional<Movimiento> existingMovimiento = movimientoService.findById(movimiento.getIdMovimiento());
        existingMovimiento.ifPresent(mov -> {
            mov.setHoraSalida(movimiento.getHoraSalida());
            mov.setObservaciones(movimiento.getObservaciones());
            movimientoService.save(mov);
        });
<<<<<<< HEAD
        flash.addFlashAttribute("success", "Movimiento actualizado exitosamente");

        return "redirect:/Usuario/listar";
=======
        return "redirect:/Usuario/listar"; // Cambiar la URL a la que rediriges después de actualizar un movimiento
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
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
<<<<<<< HEAD
    public String agregar(@RequestParam(value = "campos") int valorCampos, @RequestParam("documento") String documento, Model model, RedirectAttributes flash) {

=======
    public String agregar(@RequestParam(value = "campos") int valorCampos, @RequestParam("documento") String documento, Model model) {

<<<<<<< HEAD
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        List<Equipo> equipos = equipoService.findBydocumento(documento);
        List<Vehiculo> vehiculos = vehiculoService.findBydocumento(documento);

        if (valorCampos > 0 && Campos.size() < equipos.size() && Campos.size() > 0) {
            Campos.add(valorCampos);
        } else if (valorCampos > 0 && Campos.size() == equipos.size() && Campos.size() > 0) {

<<<<<<< HEAD
=======
=======
        List<_Equipo> equipos = equipoService.findBydocumento(documento);
        List<_Vehiculo> vehiculos = vehiculoService.findBydocumento(documento);

        if (valorCampos > 0 && Campos.size() < equipos.size() && Campos.size() > 0){
            Campos.add(valorCampos);
        } else if (valorCampos > 0 && Campos.size() == equipos.size() && Campos.size() > 0) {
            
>>>>>>> 7979a17fed079a6407b7ad1d2cac60915ff9c44b
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        } else if (valorCampos == 0 && Campos.size() > 0) {
            Campos.remove(1);
        }

        model.addAttribute("campos", Campos);
        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("equipos", equipos);
        model.addAttribute("documento", documento);

<<<<<<< HEAD
        flash.addFlashAttribute("success", "Entrada registrada exitosamente");

=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        return "movimiento/entrada.html";
    }

    @GetMapping(value = "/entrada")
<<<<<<< HEAD
    public String entrada(@RequestParam("documento") String documento, Model model, RedirectAttributes flash) {
=======
    public String entrada(@RequestParam("documento") String documento, Model model) {
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        List<Equipo> equipos = equipoService.findBydocumento(documento);
        List<Vehiculo> vehiculos = vehiculoService.findBydocumento(documento);


        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("equipos", equipos);
        model.addAttribute("documento", documento);
        model.addAttribute("campos", Campos);
<<<<<<< HEAD
=======

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        return "movimiento/entrada";
    }

    @GetMapping(value = "/salida")
<<<<<<< HEAD
    public String salida(@RequestParam("IdMovimiento") Integer IdMovimiento, Model model, RedirectAttributes flash) {
=======
    public String salida(@RequestParam("IdMovimiento") Integer IdMovimiento, Model model) {
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        Optional<Movimiento> movimientoOptional = movimientoService.findById(IdMovimiento);

        if (movimientoOptional.isPresent()) {
            Movimiento movimiento = movimientoOptional.get();
            Vehiculo vehiculo = movimiento.getVehiculo();
            List<Equipo_movimiento> equipoMovimientoList = equipoMovimientoService.findByMovimiento(movimiento);

            model.addAttribute("equipoMovimientoList", equipoMovimientoList);
            model.addAttribute("movimiento", movimiento);
            model.addAttribute("vehiculo", vehiculo);
<<<<<<< HEAD
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
=======

            return "movimiento/salida"; // Ajusta la ruta según tu estructura de vistas
        } else {
            // Manejar el caso en que el movimiento no se encuentre
            return "redirect:/error"; // Redirige a una página de error o manejo de excepciones
        }
    }



    @GetMapping(value = "/MovimientosUsuario")
    public String MovimientoUsuario(Model m, @RequestParam("documento") String documento, @RequestParam("nombre") String nombre) {
        List<Movimiento> movimientosFiltrados = movimientoService.findAll().stream()
                .filter(mov -> mov.getDocumento().getDocumento().equals(documento))
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
                .collect(Collectors.toList());

        m.addAttribute("documento", documento);
        m.addAttribute("nombre", nombre);
        m.addAttribute("movimiento", movimientosFiltrados);
<<<<<<< HEAD


=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        return "Movimiento/listarMovimientosUsuario";
    }

    @GetMapping(value = "/listarEquipoMovimientoUsuario")
<<<<<<< HEAD
    public String listarEquipoMovimientoUsuario(Model m, @RequestParam("documento") String documento, @RequestParam("IdMovimiento") Integer IdMovimiento) {
        List<Equipo_movimiento> listaEquipoMovimiento = equipoMovimientoService.findAll().stream()
                .filter(eq -> eq.getMovimiento().getDocumento().getDocumento().equals(documento) && eq.getMovimiento().getIdMovimiento() == IdMovimiento)
                .collect(Collectors.toList());

        m.addAttribute("Mensaje", "MENSAJE");
        m.addAttribute("IdMovimiento", IdMovimiento);
=======
    public String listarEquipoMovimientoUsuario(Model m, @RequestParam("documento") String documento) {
        List<Equipo_movimiento> listaEquipoMovimiento = equipoMovimientoService.findAll().stream()
                .filter(eq -> eq.getMovimiento().getDocumento().getDocumento().equals(documento))
                .collect(Collectors.toList());
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        m.addAttribute("listarEquipoMovimiento", listaEquipoMovimiento);
        return "Movimiento/listarEquipoMovimientoUsuario";
    }

<<<<<<< HEAD


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




=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
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