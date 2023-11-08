package sena.ejemplo.service;

import sena.ejemplo.model.Equipo;

import java.util.List;

public interface IEquipoService {

<<<<<<< HEAD
    List<Equipo> findAll();

=======
    // LISTAR

    List<Equipo> findAll();

    // REGISTRAR EQUIPOS

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    Equipo save(Equipo equipo);

    List<Equipo> findBydocumento(String documento);

<<<<<<< HEAD
    Equipo findById(Integer equipoId);

    Equipo findOne(Integer IdEquipo);
    Equipo updateEstado(Integer documento, boolean nuevoEstado);


=======
<<<<<<< HEAD

    Equipo findById(Integer equipoId);
=======
    _Equipo findById(Integer equipoId);
>>>>>>> 7979a17fed079a6407b7ad1d2cac60915ff9c44b

    Equipo findOne(Integer IdEquipo);

    Equipo updateEstado(Integer documento, boolean nuevoEstado);

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
}
