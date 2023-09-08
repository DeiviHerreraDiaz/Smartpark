package sena.ejemplo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sena.ejemplo.model.Vehiculo;

import java.util.List;

public interface vehiculoRepository extends CrudRepository<Vehiculo, Integer> {

    @Query("SELECT u FROM Vehiculo u WHERE u.documento.documento = :documento")
    List<Vehiculo> findByDocumento(String documento);



}
