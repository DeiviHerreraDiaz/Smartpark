package sena.ejemplo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IVehiculo extends CrudRepository<_Vehiculo, Integer> {

    @Query("SELECT u FROM _Vehiculo u WHERE u.documento.documento = :documento")
    _Vehiculo findByDocumento(String documento);

}
