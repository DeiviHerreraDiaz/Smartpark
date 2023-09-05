package sena.ejemplo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sena.ejemplo.model._Equipo;

import java.util.List;

public interface equipoRepository extends CrudRepository<_Equipo, Integer> {
    @Query("SELECT e FROM _Equipo e WHERE e.documento.documento = :documento")
    List<_Equipo> findByDocumento(String documento);
}

