

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

    @GetMapping("/home_login")
    public String greeting_login(Model model) {
        model.addAttribute("name", "Jorge");
        return "home_login_template";
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

    @GetMapping("/acceso")
    public String greeting_acceso(Model model) {
        model.addAttribute("includeCSS", "acceso.css"); // Agrega esta línea para incluir el archivo CSS
        model.addAttribute("includeJS", "acceso.js");
        return "acceso.html";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }

    @GetMapping("/pelicula")
    public String pelicula(Model model) {
        return "pelicula_template";
    }
}
