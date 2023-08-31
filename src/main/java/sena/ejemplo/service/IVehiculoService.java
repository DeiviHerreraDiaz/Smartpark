package sena.ejemplo.service;

import sena.ejemplo.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    // LISTAR

    public List<Vehiculo> findAll();

    // REGISTRAR VEHICULOS

    public Vehiculo save (Vehiculo vehiculo);

    public Vehiculo findBydocumento(String documento);
}
