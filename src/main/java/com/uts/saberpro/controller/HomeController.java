package com.uts.saberpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Página de inicio en "/"
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Saber Pro UTS");
        return "index"; // busca templates/index.html
    }

    // Opcional: también disponible en "/home"
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Saber Pro UTS");
        return "index";
    }
}
