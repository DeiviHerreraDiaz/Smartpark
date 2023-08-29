package sena.ejemplo.service;

import sena.ejemplo.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    
    // LISTAR
    public List<Usuario> findAll();

    // REGISTRAR USUARIOS
    
    public Usuario save (Usuario usuario);

    public Usuario findByDocumento(String documento);
}