package es.urjc.grupo10.blockbuster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return "home_login_template";
    }

    @GetMapping("/home_login/{id}")
    public String mostrarPelicula(@PathVariable Long id,
            @RequestParam(required = false, defaultValue = "") String username, Model model) {
        Pelicula pelicula = peliculaService.getFilmById(id);
        model.addAttribute("name", username);
        model.addAttribute("pelicula", pelicula);
        return "pelicula_template";
    }

    @GetMapping("/series_login")
    public String series_login(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        return "series_login_template";
    }

    @GetMapping("/peliculas_login")
    public String peliculas_login(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        return "peliculas_login_template";
    }

    @GetMapping("/series")
    public String greeting_series(Model model) {
        return "series_template";
    }

    @GetMapping("/peliculas")
    public String greeting_peliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.getAll());
        return "peliculas_template";
    }

    @GetMapping("/peliculas/{id}")
    public ModelAndView mostrarPelicula(@PathVariable("id") String id,Model model) {
        // Aquí debes obtener la película correspondiente al id de la película
        model.addAttribute("peliculas", peliculaService.getAll());
        Pelicula pelicula = model.getFilmById(id);
        // Creas un nuevo objeto ModelAndView para la nueva página HTML
        ModelAndView modelAndView = new ModelAndView("nueva_plantilla");
        // Agregas la película al objeto ModelAndView para que esté disponible en la
        // plantilla
        modelAndView.addObject("pelicula", pelicula);

        return modelAndView;
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

    @GetMapping("/pagina_usuario")
    public String paginaUsuario(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        return "pagina_usuario";
    }
}
