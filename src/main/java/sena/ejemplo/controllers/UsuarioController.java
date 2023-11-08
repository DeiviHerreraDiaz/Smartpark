package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sena.ejemplo.model.Usuario;
import sena.ejemplo.service.IUsuarioService;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuariod;

    @PostMapping("/add")
    public String add(Usuario usuario, Model m, RedirectAttributes flash) {
        usuariod.save(usuario);
        if (usuario.getRol().getIdRol() != 4) {
            flash.addFlashAttribute("success", "Usuario registrado o actualizado exitosamente");
        }
        return "redirect:/Usuario/listar";
    }

    @GetMapping(value = "/registrar-usuario")
    public String registrar(Model m) {

        Usuario usuario=new Usuario();

        m.addAttribute("usuario", usuario);

        return "usuario/registroUsuario";
    }

    @GetMapping(value = "/listar")
    public String listar(Model m) {

        m.addAttribute("usuario", usuariod.findAll());

        return "usuario/listar";
    }

    @GetMapping("/ver/{documento}")
    public String ver(@PathVariable String documento, Model m, RedirectAttributes flash) {

        Usuario usuario=null;

        if (documento != null && !documento.isEmpty()) {
            usuario = usuariod.findByDocumento(documento);
        } else {
            return "redirect:/Usuario/listar";
        }
        m.addAttribute("usuario",usuario);
        flash.addFlashAttribute("success", "Usuario registrado o actualizado exitosamente");
        return "Usuario/registroUsuario";
    }

    @GetMapping("/updateUserStatus/{documento}")
    public String updateUserStatus(@PathVariable String documento, RedirectAttributes flash) {
        Usuario usuario = usuariod.findByDocumento(documento);

        if (usuario != null) {
            usuariod.updateEstado(documento, usuario.isEstado());
            System.out.println("This 1 -> " + usuario.isEstado());
        }
        flash.addFlashAttribute("success", "Se cambio de estado exitosamente");
        return "redirect:/Usuario/listar";
    }

}