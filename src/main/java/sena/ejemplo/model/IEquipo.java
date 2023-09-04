package sena.ejemplo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEquipo extends CrudRepository<_Equipo, Integer> {
    @Query("SELECT e FROM _Equipo e WHERE e.documento.documento = :documento")
    List<_Equipo> findByDocumento(String documento);
}

