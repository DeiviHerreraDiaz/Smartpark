package sena.ejemplo.model;

import java.util.List;

public interface IUsuario {
    
    // LISTAR
    public List<Usuario> findAll();

    // REGISTRAR USUARIOS
    
    public void save (Usuario usuario);

    public Usuario findByDocumento(String documento);

}
