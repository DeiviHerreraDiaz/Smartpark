package sena.ejemplo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVehiculo extends CrudRepository<Vehiculo,Integer> {

    @Query("SELECT u FROM Vehiculo u WHERE u.documento = :documento")
    Vehiculo findByDocumento(String documento);

}
