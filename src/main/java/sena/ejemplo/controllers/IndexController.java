package sena.ejemplo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {


    @GetMapping(value = "/")
    public String inicio() {

        return "index";
    }

<<<<<<< HEAD
    @GetMapping(value = "/login")
=======
    @GetMapping(value = "/loguearse")
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    public String login() {

        return "/login";
    }

    @GetMapping(value = "/menu")
    public String menu() {


        return "/menu";
    }


}
