package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.Usuario;

import java.util.Collection;
=======
import org.springframework.stereotype.Service;
import sena.ejemplo.model.Usuario;

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
import java.util.List;

@Service
public class _UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private sena.ejemplo.repository.usuarioRepository usuarioRepository;

<<<<<<< HEAD
=======
    // Obtencion de datos para la consulta (Listar)
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

<<<<<<< HEAD
    // Obtencion de datos para registrar un Usuario
    @Override
    public Usuario save(Usuario usuario) {return usuarioRepository.save(usuario);}
=======
    // Obtencion de datos para registrar un Usuario 
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09

    @Override
    public Usuario findByDocumento(String documento) {
        return usuarioRepository.findByDocumento(documento);
<<<<<<< HEAD

}
=======
}

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @Override
    public Usuario findOne(String documento) {
        return usuarioRepository.findById(documento).orElse(null);
    }

    @Override
    public Usuario updateEstado(String documento, boolean estado) {
        Usuario usuarioEncontrado = findByDocumento(documento);
        if (usuarioEncontrado != null) {
            boolean nuevoEstado = !estado;
            usuarioEncontrado.setEstado(nuevoEstado);
            System.out.println("This 2 -> " + nuevoEstado);
<<<<<<< HEAD
            usuarioRepository.save(usuarioEncontrado);
        }
        return usuarioRepository.findByDocumento(documento);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByDocumento(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con documento: " + username);
        }

        if (!usuario.getRol().getNombre().equals("Administrador")) {
            throw new UsernameNotFoundException("Acceso denegado para usuarios que no sean Administradores.");
        }

        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) usuario.getAuthorities();

        System.out.println("Roles asignados al usuario: " + authorities);

        return new User(usuario.getDocumento(), usuario.getPassword(), authorities);
    }


}
=======
            usuarioRepository.save(usuarioEncontrado); // Guarda el usuario actualizado en el repositorio
        }
        return usuarioRepository.findByDocumento(documento); // Retorna el usuario actualizado o null si no se encontró
    }

    }
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
