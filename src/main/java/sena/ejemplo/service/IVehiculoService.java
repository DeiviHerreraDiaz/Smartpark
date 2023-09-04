package sena.ejemplo.service;

import sena.ejemplo.model._Equipo;
import sena.ejemplo.model._Vehiculo;

import java.util.List;

public interface IVehiculoService {

    // LISTAR

    List<_Vehiculo> findAll();

    // REGISTRAR VEHICULOS

    _Vehiculo save(_Vehiculo vehiculo);

    List<_Vehiculo> findBydocumento(String documento);
}
