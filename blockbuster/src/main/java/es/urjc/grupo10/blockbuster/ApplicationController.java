package es.urjc.grupo10.blockbuster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

    @Autowired
    private FilmService filmService;
    @Autowired
    private CartService cartservice;

    @GetMapping("/home")
    public String application(Model model) {
        return "home_template";
    }

    @PostMapping("/home_login")
    public String application_home_login(Model model, @RequestParam String username) {
        model.addAttribute("name", username);
        model.addAttribute("films", filmService.getNum(5));
        return "home_login_template";
    }

    @GetMapping("/home_login/{id}")
    public String mostrarFilm(@PathVariable Long id, @RequestParam(required = false, defaultValue = "") String username,
            Model model) {
        Film film = filmService.getFilmById(id);
        model.addAttribute("name", username);
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @GetMapping("/films_login")
    public String films_login(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("films", filmService.getAll());
        return "films_login_template";
    }

    @GetMapping("/films_login/{id}")
    public String mostrarFilmFilms(@PathVariable Long id,
            @RequestParam(required = false, defaultValue = "") String name, Model model) {
        Film film = filmService.getFilmById(id);
        cartservice.createFilm(film);
        model.addAttribute("name", name);
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/films_login/{id}/")
    public String Postcomment(@PathVariable("id") Long id,
            @RequestParam(required = false, defaultValue = "") String name, Model model, String comment) {
        Film film = filmService.getFilmById(id);
        film.getReviews().add(comment);
        model.addAttribute("name", name);
        model.addAttribute("film", film);
        return "film_login_template";

    }

    @GetMapping("/films_login_added/{id}")
    public String AñadirFilm(@PathVariable Long id, @RequestParam(required = false, defaultValue = "") String name,
            Model model) {
        Film film = filmService.getFilmById(id);
        model.addAttribute("name", name);
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @GetMapping("/films")
    public String application_films(Model model) {
        model.addAttribute("films", filmService.getAll());
        return "films_template";
    }

    @GetMapping("/films/{id}")
    public String mostrarFilm(@PathVariable("id") Long id, Model model) {
        Film film = filmService.getFilmById(id);
        model.addAttribute("film", film);
        return "film_template";

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/films/{id}/")
    public String Postcomment(@PathVariable("id") Long id, Model model, String comment) {
        Film film = filmService.getFilmById(id);
        film.getReviews().add(comment);
        model.addAttribute("film", film);
        return "film_template";

    }

    @GetMapping("/films_added/{id}")
    public String AñadirFilm(@PathVariable("id") Long id, Model model) {
        Film film = filmService.getFilmById(id);
        cartservice.createFilm(film);
        model.addAttribute("film", film);
        return "film_template";

    }

    @GetMapping("/register")
    public String application_resgistro(Model model) {
        model.addAttribute("includeCSS", "register.css");
        model.addAttribute("includeJS", "register.js");
        return "register";
    }

    @GetMapping("/access")
    public String application_acceso(Model model) {
        model.addAttribute("includeCSS", "access.css");
        model.addAttribute("includeJS", "access.js");
        return "access";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }

    @GetMapping("/user_page")
    public String paginaUsuario(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("films", cartservice.getAll());
        model.addAttribute("name", name);
        return "user_page";
    }

    @GetMapping("/user_page/delete/{id}")
    public String paginaUsuario(@RequestParam(required = false, defaultValue = "") String name,
            @PathVariable("id") Long id, Model model) {
        cartservice.deleteFilmById(id);
        model.addAttribute("films", cartservice.getAll());
        model.addAttribute("name", name);
        return "user_page";
    }
}
