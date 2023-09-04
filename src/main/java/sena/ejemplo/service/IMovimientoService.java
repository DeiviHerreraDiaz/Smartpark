package sena.ejemplo.service;

import sena.ejemplo.model._Equipo;
import sena.ejemplo.model._Movimiento;

import java.util.List;
import java.util.Optional;

public interface IMovimientoService {

    // LISTAR

    List<_Movimiento> findAll();


    // REGISTRAR EQUIPOS

    _Movimiento save(_Movimiento movimiento);

    void saveMovimientoAndEquipos(_Movimiento movimiento, List<_Equipo> equipos);

    Optional<_Movimiento> findById(Integer IdMovimiento);
}
