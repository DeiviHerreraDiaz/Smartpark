package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;

import sena.ejemplo.model.*;

@Controller
@SessionAttributes("usuario")
@RequestMapping("/usuario")
public class UsuarioController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IUsuario usuariod;

    // Agregar usuarios

    @PostMapping("/add")
    public String add(Usuario usuario, Model m) {
        usuariod.save(usuario);
        return "redirect:/usuario/listar";
    }

    // Ruta para formulario de usuarios

    @GetMapping(value = "/registrar-usuario")
    public String registrar() {

        return "usuario/registroUsuario";
    }

    // Ruta consultar / Listar

    @GetMapping(value = "/listar")
    public String listar(Model m) {

        m.addAttribute("usuario", usuariod.findAll());

        return "usuario/listar";
    }

    // Validar login

    @PostMapping("/validar")
    public String validarUsuario(Integer documento) {

        // Buscar el usuario por documento
        Usuario usuario = usuariod.findByDocumento(documento);

        if (usuario != null && (usuario.getRol().getNombre().equals("Funcionario")
                || usuario.getRol().getNombre().equals("Aprendiz"))) {
            // El usuario es un Funcionario o Aprendiz, redireccionar al menú
            // correspondiente.
            return "redirect:/menu";
        } else if (usuario == null) {
            // El usuario no es un Funcionario o no existe, redireccionar al formulario de
            // registro.
            return "login";
        }
        return "login";
    }

    // Actualizar Usuario
    @GetMapping("/ver/{documento}")
    public String ver(@PathVariable Integer documento, Model m) {
        Usuario usuario = null;
        if (documento > 0) {
            usuario = usuariod.findOne(documento);
        } else {
            return "redirect:listar";
        }
        m.addAttribute("usuario", usuario);
        m.addAttribute("accion", "Actualizar Cliente");
        return "usuario/form";
    }

    @GetMapping("/form")
    public String form(Model m) {
        Usuario usuario = new Usuario();
        m.addAttribute("usuario", usuario);
        m.addAttribute("accion", "Agregar Cliente");
        return "usuario/form";
    }

    @GetMapping("/updateUserStatus/{documento}")
    public String updateUserStatus(@PathVariable Integer documento) {
        Usuario usuario = usuariod.findByDocumento(documento);

        if (usuario != null) {
            usuariod.updateEstado(documento, usuario.isEstado());
            System.out.println("This 1 -> " + usuario.isEstado());
        }
        return "redirect:/usuario/listar";
    }

}
