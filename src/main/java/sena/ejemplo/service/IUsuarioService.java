package sena.ejemplo.service;

import sena.ejemplo.model._Usuario;

import java.util.List;

public interface IUsuarioService {

    // LISTAR
    List<_Usuario> findAll();

    // REGISTRAR USUARIOS

    _Usuario save(_Usuario usuario);

    _Usuario findByDocumento(String documento);
}