package sena.ejemplo.model;

import java.util.List;

public interface IVehiculo {
    
    // LISTAR

    public List<Vehiculo> findAll();

    // REGISTRAR VEHICULOS
    
    public void save (Vehiculo vehiculo);

    List<Vehiculo> findBydocumento(String documento);
    public Vehiculo findOne(Integer idVehiculo);

}
