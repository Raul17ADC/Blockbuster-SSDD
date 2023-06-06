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

import es.urjc.grupo10.blockbuster.UserService;

@Controller
public class ApplicationController {

    @Autowired
    private FilmService filmService;
    
    @Autowired
    private UserService userService;
    private User CurrentUser ;

    @GetMapping("/home")
    public String application(Model model) {

        return "home_template";
    }

    @GetMapping("/home_out")
    public String application_out(Model model) {    
        return "/home_template";
    }

    @PostMapping("/home_login")
    public String application_home_login(Model model, @RequestParam String username) {
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("films", filmService.getNum(5));
        return "home_login_template";
    }

    @GetMapping("/home_login/{id}")
    public String showFilm(@PathVariable Long id, @RequestParam(required = false, defaultValue = "") String username,
            Model model) {
        Film film = filmService.getFilmById(id);
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @GetMapping("/films_login")
    public String films_login(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("films", filmService.getAll());
        return "films_login_template";
    }

    @GetMapping("/films_login/{id}")
    public String showFilmFilms(@PathVariable Long id,
            @RequestParam(required = false, defaultValue = "") String name, Model model) {
        Film film = filmService.getFilmById(id);
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/films_login/{id}/")
    public String Postcomment(@PathVariable("id") Long id,
            @RequestParam(required = false, defaultValue = "") String name, Model model, String comment) {
        Film film = filmService.getFilmById(id);
        film.getReviews().add(comment);
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("film", film);
        return "film_login_template";

    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/home_login/")
    public String Log(
            @RequestParam(required = false, defaultValue = "") String username, @RequestParam(required = false, defaultValue = "") String password, Model model) {
            model.addAttribute("users", userService.getAll());
            User aux = userService.getUserByNameAndPassword(username,password);           
            if (aux == null){
                return "home_template";
            }else{
                CurrentUser = aux ;
                model.addAttribute("name", CurrentUser.getUserName());
                model.addAttribute("films", filmService.getNum(5));
                model.addAttribute("logo", CurrentUser.getLogo());
                model.addAttribute("user", CurrentUser);
                return "home_login_template";
            }               
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/home/")
    public String postUser(
        @RequestParam(required = false, defaultValue = "") String email,@RequestParam(required = false, defaultValue = "") String name,@RequestParam(required = false, defaultValue = "") String password, Model model) {
    
    User user = new User(email, name, password); 
    userService.createUser(user);
    return "home_template";
}

    @GetMapping("/films_login_added/{id}")
    public String addFilm(@PathVariable Long id, @RequestParam(required = false, defaultValue = "") String name,
            Model model) {
        Film film = filmService.getFilmById(id);
        CurrentUser.getCart().add(film.getTitle());
        model.addAttribute("reviews", film.getReviews());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("name", CurrentUser.getUserName());       
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @GetMapping("/films")
    public String application_films(Model model) {
        model.addAttribute("films", filmService.getAll());
        return "films_template";
    }

    @GetMapping("/films/{id}")
    public String showFilm(@PathVariable("id") Long id, Model model) {
        Film film = filmService.getFilmById(id);
        model.addAttribute("film", film);
        return "film_template";

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/films/{id}/")
    public String Postcomment(@PathVariable("id") Long id, Model model, String comment) {
        Film film = filmService.getFilmById(id);
        film.getReviews().add(comment); 
        model.addAttribute("reviews", film.getReviews());
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
        model.addAttribute("films", CurrentUser.getCart());
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        return "user_page";
    }

    @GetMapping("/user_page/delete/{id}")
    public String userPage(@RequestParam(required = false, defaultValue = "") String name,
            @PathVariable("id") Long id, Model model) {
            CurrentUser.getCart().remove( id.intValue() - 1);
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("films", CurrentUser.getCart());
        model.addAttribute("name", name);
        return "user_page";
    }
    @PostMapping("/user_page/")
    public String userPage(@RequestParam(required = false, defaultValue = "") String name, String logo, Model model) {
        CurrentUser.setLogo(logo);
        model.addAttribute("cart", CurrentUser.getCart());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("name", CurrentUser.getUserName());    
        return "user_page";
    }
}
