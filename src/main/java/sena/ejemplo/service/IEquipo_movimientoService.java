package sena.ejemplo.service;

import sena.ejemplo.model.Equipo_movimiento;
import sena.ejemplo.model.Movimiento;

import java.util.List;

public interface IEquipo_movimientoService {

//    LISTAR

    List<Equipo_movimiento> findAll();

    Equipo_movimiento save(Equipo_movimiento equipoMovimiento);

    Equipo_movimiento findById(Integer equipoMovimiento);


    List<Equipo_movimiento> findByMovimiento(Movimiento movimiento);
}
