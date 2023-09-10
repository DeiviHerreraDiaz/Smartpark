package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.Usuario;

import java.util.List;

@Service
public class _UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private sena.ejemplo.repository.usuarioRepository usuarioRepository;

    // Obtencion de datos para la consulta (Listar)
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    // Obtencion de datos para registrar un Usuario 
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findByDocumento(String documento) {
        return usuarioRepository.findByDocumento(documento);



}

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
            usuarioRepository.save(usuarioEncontrado); // Guarda el usuario actualizado en el repositorio
        }
        return usuarioRepository.findByDocumento(documento); // Retorna el usuario actualizado o null si no se encontró
    }

    }
