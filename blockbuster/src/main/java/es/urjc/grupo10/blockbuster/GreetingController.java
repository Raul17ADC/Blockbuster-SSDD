package es.urjc.grupo10.blockbuster;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/error")
    public String error(Model model) {        
        return "error";
    }


    

}
