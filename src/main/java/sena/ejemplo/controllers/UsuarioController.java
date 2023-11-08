package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
import sena.ejemplo.model.Usuario;
import sena.ejemplo.service.IUsuarioService;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuariod;

<<<<<<< HEAD
    @PostMapping("/add")
    public String add(Usuario usuario, Model m, RedirectAttributes flash) {
        usuariod.save(usuario);
        if (usuario.getRol().getIdRol() != 4) {
            flash.addFlashAttribute("success", "Usuario registrado o actualizado exitosamente");
        }
        return "redirect:/Usuario/listar";
    }

=======

    // Agregar usuarios

    @PostMapping("/add")
    public String add(Usuario usuario, Model m) {

        usuariod.save(usuario);
        
        return "redirect:/Usuario/listar";
    }

    // Ruta para formulario de usuarios

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @GetMapping(value = "/registrar-usuario")
    public String registrar(Model m) {

        Usuario usuario=new Usuario();

        m.addAttribute("usuario", usuario);

        return "usuario/registroUsuario";
    }

<<<<<<< HEAD
=======
    // Ruta consultar / Listar

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @GetMapping(value = "/listar")
    public String listar(Model m) {

        m.addAttribute("usuario", usuariod.findAll());

        return "usuario/listar";
    }

<<<<<<< HEAD
    @GetMapping("/ver/{documento}")
    public String ver(@PathVariable String documento, Model m, RedirectAttributes flash) {

=======
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

//    BRIGITHE

    //Actualizar Usuario
    @GetMapping("/ver/{documento}")
    public String ver(@PathVariable String documento, Model m){
        
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        Usuario usuario=null;

        if (documento != null && !documento.isEmpty()) {
            usuario = usuariod.findByDocumento(documento);
        } else {
            return "redirect:/Usuario/listar";
        }
        m.addAttribute("usuario",usuario);
<<<<<<< HEAD
        flash.addFlashAttribute("success", "Usuario registrado o actualizado exitosamente");
=======

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        return "Usuario/registroUsuario";
    }

    @GetMapping("/updateUserStatus/{documento}")
<<<<<<< HEAD
    public String updateUserStatus(@PathVariable String documento, RedirectAttributes flash) {
=======
    public String updateUserStatus(@PathVariable String documento) {
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
        Usuario usuario = usuariod.findByDocumento(documento);

        if (usuario != null) {
            usuariod.updateEstado(documento, usuario.isEstado());
            System.out.println("This 1 -> " + usuario.isEstado());
        }
<<<<<<< HEAD
        flash.addFlashAttribute("success", "Se cambio de estado exitosamente");
        return "redirect:/Usuario/listar";
    }

}
=======
        return "redirect:/Usuario/listar";
    }

}




>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
