package sena.ejemplo.service;

import sena.ejemplo.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

<<<<<<< HEAD
    List<Vehiculo> findAll();
    Vehiculo save(Vehiculo vehiculo);
    List<Vehiculo> findBydocumento(String documento);
    Vehiculo findOne(Integer idVehiculo);
=======
    // LISTAR

    List<Vehiculo> findAll();

    // REGISTRAR VEHICULOS

    Vehiculo save(Vehiculo vehiculo);

    List<Vehiculo> findBydocumento(String documento);

    Vehiculo findOne(Integer idVehiculo);

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    Vehiculo updateEstado(Integer idVehiculo, boolean nuevoEstado);

}
