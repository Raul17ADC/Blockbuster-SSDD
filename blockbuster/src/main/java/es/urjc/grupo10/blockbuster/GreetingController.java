package es.urjc.grupo10.blockbuster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/home")
    public String greeting(Model model) {
        return "home_template";
    }

    @PostMapping("/home_login")
    public String greeting_home_login(Model model, @RequestParam String username) {
        model.addAttribute("name", username);
        model.addAttribute("peliculas", peliculaService.getRecomendada(5));
        return "home_login_template";
    }

    @GetMapping("/home_login/{id}")
    public String mostrarPelicula(@PathVariable Long id,
            @RequestParam(required = false, defaultValue = "") String username, Model model) {
        Pelicula pelicula = peliculaService.getFilmById(id);
        model.addAttribute("name", username);
        model.addAttribute("pelicula", pelicula );
        return "pelicula_template";
    }

    @GetMapping("/peliculas_login")
    public String peliculas_login(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("peliculas", peliculaService.getAll());
        return "peliculas_login_template";
    }

    @GetMapping("/peliculas_login/{id}")
    public String mostrarPelicula(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("peliculas", peliculaService.getAll());
        return "pelicula_login_template";
    }

    @GetMapping("/peliculas")
    public String greeting_peliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.getAll());
        return "peliculas_template";
    }

    @GetMapping("/peliculas/{id}")
    public String mostrarPelicula( @PathVariable("id") Long id, Model model) {
        Pelicula pelicula = peliculaService.getFilmById(id);
        model.addAttribute("pelicula", pelicula);
        return "pelicula_template";

    }

    @GetMapping("/registro")
    public String greeting_resgistro(Model model) {
        model.addAttribute("includeCSS", "registro.css");
        model.addAttribute("includeJS", "registro.js");
        return "registro";
    }

    @GetMapping("/acceso")
    public String greeting_acceso(Model model) {
        model.addAttribute("includeCSS", "acceso.css");
        model.addAttribute("includeJS", "acceso.js");
        return "acceso";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }

    @GetMapping("/pagina_usuario")
    public String paginaUsuario(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        return "pagina_usuario";
    }
}
