package sena.ejemplo.service;

import sena.ejemplo.model._Equipo;
import sena.ejemplo.model._Usuario;

import java.util.List;

public interface IEquipoService {

    // LISTAR

    List<_Equipo> findAll();

    // REGISTRAR EQUIPOS

    _Equipo save(_Equipo equipo);

    List<_Equipo> findBydocumento(String documento);
    _Equipo findById(Integer equipoId);
    _Equipo findOne(Integer IdEquipo);
    _Equipo updateEstado(Integer documento, boolean nuevoEstado);



}
