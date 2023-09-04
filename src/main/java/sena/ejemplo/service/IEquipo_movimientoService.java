package sena.ejemplo.service;

import sena.ejemplo.model._Equipo;
import sena.ejemplo.model._Equipo_movimiento;
import sena.ejemplo.model._Movimiento;

import java.util.List;

public interface IEquipo_movimientoService {

//    LISTAR

    List<_Equipo_movimiento> findAll();

    _Equipo_movimiento save(_Equipo_movimiento equipoMovimiento);

    _Equipo_movimiento findById(Integer equipoMovimiento);


    List<_Equipo_movimiento> findByMovimiento(_Movimiento movimiento);
}
