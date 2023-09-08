package sena.ejemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sena.ejemplo.model.Usuario;
import sena.ejemplo.service.IUsuarioService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IUsuarioService usuariod;


    // Agregar usuarios

    @PostMapping("/add")
    public String add(Usuario usuario, Model m) {
        usuariod.save(usuario);
        return "redirect:/Usuario/listar";
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

    //Actualizar Usuario
    @GetMapping("/ver/{documento}")
    public String ver(@PathVariable String documento,Model m){
        Usuario usuario=null;
        if (documento != null && !documento.isEmpty()) {
            usuario = usuariod.findByDocumento(documento);
        } else {
            // Si el documento está vacío o es nulo, puedes realizar una acción apropiada, como redirigir al usuario a una página de error o de vuelta a la lista de usuarios.
            return "redirect:/Usuario/listar"; // Cambia esto según tus necesidades.
        }
        m.addAttribute("usuario",usuario);
        m.addAttribute("accion", "Actualizar Cliente");
        return "Usuario/form";
    }

    @GetMapping("/form")     
    public String form(Model m){
        Usuario usuario=new Usuario();
        m.addAttribute("usuario", usuario);
        m.addAttribute("accion", "Agregar Cliente");
        return "Usuario/form";
    }


        @GetMapping("/updateUserStatus/{documento}")
    public String updateUserStatus(@PathVariable String documento) {
        Usuario usuario = usuariod.findByDocumento(documento);

        if (usuario != null) {
            usuariod.updateEstado(documento, usuario.isEstado());
            System.out.println("This 1 -> " + usuario.isEstado());
        }
        return "redirect:/Usuario/listar";
    }

}
