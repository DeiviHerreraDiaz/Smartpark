package sena.ejemplo.service;

import sena.ejemplo.model.Equipo;

import java.util.List;

public interface IEquipoService {

    // LISTAR

    List<Equipo> findAll();

    // REGISTRAR EQUIPOS

    Equipo save(Equipo equipo);

    List<Equipo> findBydocumento(String documento);


    Equipo findById(Integer equipoId);

    Equipo findOne(Integer IdEquipo);
    Equipo updateEstado(Integer documento, boolean nuevoEstado);


}
