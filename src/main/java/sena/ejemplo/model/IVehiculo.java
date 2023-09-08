package sena.ejemplo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVehiculo extends CrudRepository<_Vehiculo, Integer> {

    @Query("SELECT u FROM _Vehiculo u WHERE u.documento.documento = :documento")
    List<_Vehiculo> findByDocumento(String documento);




}
