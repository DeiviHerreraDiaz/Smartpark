package sena.ejemplo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {


    @GetMapping(value = "/")
    public String inicio() {

        return "index";
    }

    @GetMapping(value = "/loguearse")
    public String login() {

        return "/login";
    }

    @GetMapping(value = "/menu")
    public String menu() {


        return "/menu";
    }


}
