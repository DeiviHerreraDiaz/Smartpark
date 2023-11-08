package sena.ejemplo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
<<<<<<< HEAD
=======

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
import sena.ejemplo.model.Vehiculo;

import java.util.List;

public interface vehiculoRepository extends CrudRepository<Vehiculo, Integer> {

    @Query("SELECT u FROM Vehiculo u WHERE u.documento.documento = :documento")
    List<Vehiculo> findByDocumento(String documento);

<<<<<<< HEAD

=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
}
