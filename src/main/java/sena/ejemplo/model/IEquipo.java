package sena.ejemplo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IEquipo extends CrudRepository<_Equipo, Integer> {
    @Query("SELECT e FROM _Equipo e WHERE e.documento.documento = :documento")
    _Equipo findByDocumento(String documento);
}

