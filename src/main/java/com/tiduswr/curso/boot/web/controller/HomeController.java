package com.tiduswr.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Acessa o Template home.html
    @GetMapping("/")
    public String home(){
        return "/home";
    }

}
