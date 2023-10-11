package sena.ejemplo.service;

import sena.ejemplo.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    List<Vehiculo> findAll();
    Vehiculo save(Vehiculo vehiculo);
    List<Vehiculo> findBydocumento(String documento);
    Vehiculo findOne(Integer idVehiculo);
    Vehiculo updateEstado(Integer idVehiculo, boolean nuevoEstado);

}
