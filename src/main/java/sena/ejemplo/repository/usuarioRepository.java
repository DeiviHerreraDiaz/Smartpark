package sena.ejemplo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sena.ejemplo.model._Usuario;

public interface usuarioRepository extends CrudRepository<_Usuario, String> {

    @Query("SELECT u FROM _Usuario u WHERE u.documento = :documento")
    _Usuario findByDocumento(String documento);
}
