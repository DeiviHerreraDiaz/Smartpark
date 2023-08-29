package sena.ejemplo.service;
import sena.ejemplo.model.Usuario;
import sena.ejemplo.model.IUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    
    @Autowired
    private IUsuario usuarioRepository;

    // Obtencion de datos para la consulta (Listar)
    @Override
    public List<Usuario> findAll(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    // METODOS SIN MODIFICAR

    // Obtencion de datos para registrar un Usuario 
    @Override
    public Usuario save (Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findByDocumento(String documento) {
        return usuarioRepository.findByDocumento(documento);
    }
}
