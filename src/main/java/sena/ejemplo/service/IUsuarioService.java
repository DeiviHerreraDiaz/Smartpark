package sena.ejemplo.service;

import sena.ejemplo.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    // LISTAR
    List<Usuario> findAll();

    // REGISTRAR USUARIOS

    Usuario save(Usuario usuario);

    Usuario findByDocumento(String documento);

    Usuario findOne(String documento);

    Usuario updateEstado(String documento, boolean nuevoEstado);
}