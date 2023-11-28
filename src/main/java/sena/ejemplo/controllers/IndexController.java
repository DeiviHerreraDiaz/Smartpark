package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sena.ejemplo.model.Usuario;
import sena.ejemplo.service.IUsuarioService;


@Controller
public class IndexController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping(value = "/")
    public String inicio(Model m) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        m.addAttribute("usuarioAutenticado", auth.getName()); // Esto asume que el nombre del usuario es relevante para tu caso
        Usuario usuario = usuarioService.findByDocumento(auth.getName());


        if (usuario != null) {
            m.addAttribute("nombreUsuario", usuario.getNombre());
            m.addAttribute("apellidoUsuario", usuario.getApellido());

        } else {

            m.addAttribute("nombreUsuario", "Invitado");

        }

        return "index";
    }


    @GetMapping(value = "/login")
    public String login() {

        return "/login";
    }

    @GetMapping(value = "/menu")
    public String menu(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("usuarioAutenticado", auth.getName()); // Esto asume que el nombre del usuario es relevante para tu caso
        Usuario usuario = usuarioService.findByDocumento(auth.getName());

        model.addAttribute("nombreUsuario", usuario.getNombre());
        model.addAttribute("apellidoUsuario", usuario.getApellido());

        return "/menu";
    }


}