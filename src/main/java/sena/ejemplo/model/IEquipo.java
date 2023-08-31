package sena.ejemplo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEquipo extends CrudRepository<Equipo, Integer> {
    @Query("SELECT e FROM Equipo e WHERE e.documento.documento = :documento")
    Equipo findByDocumento(String documento);
}

