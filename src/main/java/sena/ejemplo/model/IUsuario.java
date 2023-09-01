package sena.ejemplo.model;

import java.util.List;

public interface IUsuario {
    // LISTAR
    public List<Usuario> findAll();

    // REGISTRAR USUARIOS
    public void save(Usuario usuario);

    public Usuario findByDocumento(Integer documento);

    public Usuario findOne(Integer documento);

    // MODIFICAR ESTADO DEL USUARIO
    public void updateEstado(Integer documento, boolean nuevoEstado);

}
