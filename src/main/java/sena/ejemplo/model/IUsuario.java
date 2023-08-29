package sena.ejemplo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends CrudRepository<Usuario,Integer> {
    
    @Query("SELECT u FROM Usuario u WHERE u.documento = :documento")
    public Usuario findByDocumento(String documento);
}
