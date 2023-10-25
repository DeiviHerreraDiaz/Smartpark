package sena.ejemplo.service;

import sena.ejemplo.model.Equipo;
import sena.ejemplo.model.Movimiento;

import java.util.List;
import java.util.Optional;

public interface IMovimientoService {

    List<Movimiento> findAll();
    Movimiento save(Movimiento movimiento);
    void saveMovimientoAndEquipos(Movimiento movimiento, List<Equipo> equipos);
    Optional<Movimiento> findById(Integer IdMovimiento);



}
