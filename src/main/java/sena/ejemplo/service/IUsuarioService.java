package sena.ejemplo.service;

<<<<<<< HEAD
import org.springframework.security.core.userdetails.UserDetailsService;
=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
import sena.ejemplo.model.Usuario;

import java.util.List;

<<<<<<< HEAD
public interface IUsuarioService extends UserDetailsService {

    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    Usuario findByDocumento(String documento);
    Usuario findOne(String documento);
=======
public interface IUsuarioService {

    // LISTAR
    List<Usuario> findAll();

    // REGISTRAR USUARIOS

    Usuario save(Usuario usuario);

    Usuario findByDocumento(String documento);

    Usuario findOne(String documento);

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    Usuario updateEstado(String documento, boolean nuevoEstado);
}