package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;

import sena.ejemplo.model.*;
import sena.ejemplo.service.IUsuarioService;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {
    
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IUsuarioService usuariod;
    
    
    // Agregar usuarios

    @PostMapping("/add")
    public String add(Usuario usuario, Model m){
        usuariod.save(usuario);
        return "redirect:/Usuario/listar";
    }

    // Ruta para formulario de usuarios

    @GetMapping(value="/registrar-usuario")
    public String registrar(){
        

        return "usuario/registroUsuario";
    }

    // Ruta consultar / Listar

    @GetMapping(value="/listar")
    public String listar(Model m){

        m.addAttribute("usuario", usuariod.findAll());

        return "usuario/listar";
    }

   // Validar login

   @PostMapping("/validar")
public String validarUsuario(String documento) {
    
    // Buscar el usuario por documento
    Usuario usuario = usuariod.findByDocumento(documento);

    if (usuario != null && (usuario.getRol().getNombre().equals("Funcionario") || usuario.getRol().getNombre().equals("Aprendiz"))) {
        // El usuario es un Funcionario o Aprendiz, redireccionar al menú correspondiente.
        return "redirect:/menu";
    } else if (usuario == null) {
        // El usuario no es un Funcionario o no existe, redireccionar al formulario de registro.
        return "login";
    }
    return "login";
}






   
    

}
