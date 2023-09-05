package sena.ejemplo.service;

import sena.ejemplo.model.Equipo;
import sena.ejemplo.model.Movimiento;

import java.util.List;
import java.util.Optional;

public interface IMovimientoService {

    // LISTAR

    List<Movimiento> findAll();


    // REGISTRAR EQUIPOS

    Movimiento save(Movimiento movimiento);

    void saveMovimientoAndEquipos(Movimiento movimiento, List<Equipo> equipos);

    Optional<Movimiento> findById(Integer IdMovimiento);
}
