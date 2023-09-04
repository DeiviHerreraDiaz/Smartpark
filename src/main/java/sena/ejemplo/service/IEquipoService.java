package sena.ejemplo.service;

import sena.ejemplo.model._Equipo;

import java.util.List;

public interface IEquipoService {

    // LISTAR

    List<_Equipo> findAll();

    // REGISTRAR EQUIPOS

    _Equipo save(_Equipo equipo);

    List<_Equipo> findBydocumento(String documento);


    _Equipo findById(Integer equipoId);
    _Equipo findOne(Integer idEquipo);


}
