package es.urjc.grupo10.blockbuster;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

    @Controller

public class GreetingController {
    @GetMapping("/home")
    public String greeting(Model model) {        
        return "home_template";
    }
    @GetMapping("/series")
    public String greeting_series(Model model) {        
        return "series_template";
    }
    @GetMapping("/peliculas")
    public String greeting_peliculas(Model model) {        
        return "peliculas_template";
    }
    @GetMapping("/registro")
    public String greeting_resgistro(Model model) {        
        model.addAttribute("includeCSS", "registro.css"); // Agrega esta línea para incluir el archivo CSS
        model.addAttribute("includeJS", "registro.js");
        return "registro.html";
    }

    @GetMapping("/error")
    public String error(Model model) {        
        return "error.html";
    }

    @GetMapping("/pelicula")
    public String pelicula(Model model) {        
        return "pelicula_template";
    }
}
