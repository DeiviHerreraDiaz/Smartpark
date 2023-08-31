package sena.ejemplo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends CrudRepository<_Usuario, String> {

    @Query("SELECT u FROM _Usuario u WHERE u.documento = :documento")
    _Usuario findByDocumento(String documento);
}
