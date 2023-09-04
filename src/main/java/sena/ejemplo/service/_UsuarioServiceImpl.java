package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.IUsuario;
import sena.ejemplo.model._Usuario;

import java.util.List;

@Service
public class _UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuario usuarioRepository;

    // Obtencion de datos para la consulta (Listar)
    @Override
    public List<_Usuario> findAll() {
        return (List<_Usuario>) usuarioRepository.findAll();
    }

    // Obtencion de datos para registrar un Usuario 
    @Override
    public _Usuario save(_Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    @Override
    public _Usuario findByDocumento(String documento) {
        return usuarioRepository.findByDocumento(documento);
}

@Override
public _Usuario findOne(String documento) {
    return usuarioRepository.findById(documento).orElse(null);
}

@Override
public _Usuario updateEstado(String documento, boolean estado) {
    _Usuario usuarioEncontrado = findByDocumento(documento);
    if (usuarioEncontrado != null) {
        boolean nuevoEstado = !estado;
        usuarioEncontrado.setEstado(nuevoEstado);
        System.out.println("This 2 -> " + nuevoEstado);
        usuarioRepository.save(usuarioEncontrado); // Guarda el usuario actualizado en el repositorio
    }
    return usuarioRepository.findByDocumento(documento); // Retorna el usuario actualizado o null si no se encontró
}


    }
