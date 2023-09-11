package sena.ejemplo.service;

import sena.ejemplo.model.Equipo;

import java.util.List;

public interface IEquipoService {

    // LISTAR

    List<Equipo> findAll();

    // REGISTRAR EQUIPOS

    Equipo save(Equipo equipo);

    List<Equipo> findBydocumento(String documento);

<<<<<<< HEAD

    Equipo findById(Integer equipoId);
=======
    _Equipo findById(Integer equipoId);
>>>>>>> 7979a17fed079a6407b7ad1d2cac60915ff9c44b

    Equipo findOne(Integer IdEquipo);

    Equipo updateEstado(Integer documento, boolean nuevoEstado);

}
