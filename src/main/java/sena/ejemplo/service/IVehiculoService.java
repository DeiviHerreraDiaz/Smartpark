package sena.ejemplo.service;

import sena.ejemplo.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    // LISTAR

    List<Vehiculo> findAll();

    // REGISTRAR VEHICULOS

    Vehiculo save(Vehiculo vehiculo);
    Vehiculo findOne(Integer idVehiculo);
    Vehiculo updateEstado(Integer idVehiculo, boolean nuevoEstado);
    List<Vehiculo> findBydocumento(String documento);
}
