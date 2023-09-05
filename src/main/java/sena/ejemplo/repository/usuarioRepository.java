package sena.ejemplo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sena.ejemplo.model.Usuario;

public interface usuarioRepository extends CrudRepository<Usuario, String> {

    @Query("SELECT u FROM Usuario u WHERE u.documento = :documento")
    Usuario findByDocumento(String documento);
}
