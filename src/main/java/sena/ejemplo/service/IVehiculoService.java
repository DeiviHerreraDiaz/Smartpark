package sena.ejemplo.service;

import sena.ejemplo.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    // LISTAR

    List<Vehiculo> findAll();

    // REGISTRAR VEHICULOS

    Vehiculo save(Vehiculo vehiculo);

    List<Vehiculo> findBydocumento(String documento);
}
