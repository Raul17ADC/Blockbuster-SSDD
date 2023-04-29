package es.urjc.grupo10.blockbuster;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ApplicationController {
    
    @Autowired
    private CartRepository cartService;
    @Autowired
    private FilmService filmService;
    
    
    private Client CurrentUser ;

    @GetMapping("/home")
    public String application(Model model) {

        return "home_template";
    }
    @GetMapping("/home_out")
    public String application_out(Model model) {
        cartService.deleteAll();    
        return "home_template";
    }
    @PostMapping("/home_login")
    public String application_home_login(Model model, @RequestParam String username) {
        model.addAttribute("name", CurrentUser.getName());
       // model.addAttribute("films", filmService.getNum(5));
        return "home_login_template";
    }

    @GetMapping("/home_login/{id}")
    public String showFilm(@PathVariable Long id, @RequestParam(required = false, defaultValue = "") String username,
            Model model) {
        Film film = filmService.filmRepository.getById(id);
        model.addAttribute("name", CurrentUser.getName());
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @GetMapping("/films_login")
    public String films_login(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", CurrentUser.getName());
        model.addAttribute("films", filmService.filmRepository.findAll());
        return "films_login_template";
    }

    @GetMapping("/films_login/{id}")
    public String showFilmFilms(@PathVariable Long id,
            @RequestParam(required = false, defaultValue = "") String name, Model model) {
        Film film = filmService.filmRepository.getById(id);
        model.addAttribute("name", CurrentUser.getName());
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/films_login/{id}/")
    public String Postcomment(@PathVariable("id") Long id,
            @RequestParam(required = false, defaultValue = "") String name, Model model, String comment) {
        Film film = filmService.filmRepository.getById(id);
        film.getReviews().add(comment);
        model.addAttribute("name", CurrentUser.getName());
        model.addAttribute("film", film);
        return "film_login_template";

    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/home_login/")
    public String Log(
            @RequestParam(required = false, defaultValue = "") String username, @RequestParam(required = false, defaultValue = "") String password, Model model) {
            /*List<Client> aux = filmService.userRepository.findByName(username);           
            if (aux.isEmpty()){
                return "home_template";
            }else{ */
                CurrentUser = new Client( "aaa@aaaa", "aaa", "aaa");
                model.addAttribute("name", CurrentUser.getName());
                //model.addAttribute("films", filmService.getNum(5));
                model.addAttribute("user", CurrentUser);
                return "home_login_template";
           // }               
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/home/")
    public String postUser(
        @RequestParam(required = false, defaultValue = "") String email,@RequestParam(required = false, defaultValue = "") String name,@RequestParam(required = false, defaultValue = "") String password, Model model) {   
        Client user = new Client( email, name, password); 
        filmService.userRepository.save(user);
    return "home_template";
}

    @GetMapping("/films_login_added/{id}")
    public String addFilm(@PathVariable Long id, @RequestParam(required = false, defaultValue = "") String name,
            Model model) {
        Film film = filmService.filmRepository.getById(id);
        cartService.save(film);
        model.addAttribute("name", CurrentUser.getName());       
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @GetMapping("/films")
    public String application_films(Model model) {
        model.addAttribute("films", filmService.filmRepository.findAll());
        return "films_template";
    }

    @GetMapping("/films/{id}")
    public String showFilm(@PathVariable("id") Long id, Model model) {
        Film film = filmService.filmRepository.getById(id);
        model.addAttribute("film", film);
        return "film_template";

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/films/{id}/")
    public String Postcomment(@PathVariable("id") Long id, Model model, String comment) {
        Film film = filmService.filmRepository.getById(id);
        film.getReviews().add(comment);
        filmService.filmRepository.save(film);
        model.addAttribute("film", film);
        return "film_template";

    }

    @GetMapping("/films_added/{id}")
    public String addFilm(@PathVariable("id") Long id, Model model) {
        Film film = filmService.filmRepository.getById(id);
        cartService.save(film);
        model.addAttribute("film", film);
        return "film_template";

    }

    @GetMapping("/register")
    public String application_resgister(Model model) {
        model.addAttribute("includeCSS", "register.css");
        model.addAttribute("includeJS", "register.js");
        return "register";
    }

    @GetMapping("/access")
    public String application_access(Model model) {
        model.addAttribute("includeCSS", "access.css");
        model.addAttribute("includeJS", "access.js");
        return "access";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }

    @GetMapping("/user_page")
    public String userPage(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("cart", cartService.findAll());
        model.addAttribute("name", CurrentUser.getName());
        return "user_page";
    }

    @GetMapping("/user_page/delete/{id}")
    public String userPage(@RequestParam(required = false, defaultValue = "") String name,
            @PathVariable("id") Long id, Model model) {
        cartService.deleteById(id);
        model.addAttribute("cart", cartService.findAll());
        model.addAttribute("name", name);
        return "user_page";
    }
}
