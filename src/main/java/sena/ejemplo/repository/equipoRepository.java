package sena.ejemplo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sena.ejemplo.model.Equipo;

import java.util.List;

public interface equipoRepository extends CrudRepository<Equipo, Integer> {
    @Query("SELECT e FROM Equipo e WHERE e.documento.documento = :documento")
    List<Equipo> findByDocumento(String documento);
}

