package sena.ejemplo.controllers;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sena.ejemplo.model.Usuario;
import sena.ejemplo.service.IUsuarioService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/ExportarPdf")
    public void ExportarListadoUsuarios(Model m,HttpServletResponse response) throws DocumentException, IOException {

        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        DateFormat dateFormatter2 = new SimpleDateFormat("yyyy-MM-dd");

        String fechaActual = dateFormatter.format(new Date());
        String fecha = dateFormatter2.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Usuarios_" + fechaActual + ".pdf";
        response.setHeader(cabecera, valor);

        List<Usuario> usuarios = usuariod.findAll();


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuariod.findByDocumento(auth.getName());
        String info = "El administrador " + usuario.getNombre() + " " + usuario.getApellido() + ", identificado con el número " + usuario.getDocumento() + ", generó un reporte en la fecha " + fecha + " , con la información de los usuarios que utilizan el servicio de parqueadero del CGMLTI.";



        UsuariosExporterPDF exporter = new UsuariosExporterPDF(usuarios);


        exporter.exportar(response, info);
    }


}