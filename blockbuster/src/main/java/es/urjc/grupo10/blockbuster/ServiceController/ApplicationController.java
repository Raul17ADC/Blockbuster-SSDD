package es.urjc.grupo10.blockbuster.ServiceController;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import es.urjc.grupo10.blockbuster.Class.Client;
import es.urjc.grupo10.blockbuster.Class.Film;
import es.urjc.grupo10.blockbuster.Class.Review;

import java.util.List;

@Controller
public class ApplicationController {
    
    
    @Autowired
    private FilmService filmService;
    @Autowired
    private ClientService clientService;
    
    private Client CurrentUser ;

    @GetMapping("/home")
    public String application(Model model) {

        return "home_template";
    }
    @GetMapping("/prueba")
    public String prueba(Model model) {
        model.addAttribute("baba", filmService.filmRepository.findAll());
        return "prueba";
    }
    @GetMapping("/home_out")
    public String application_out(Model model) {   
        return "home_template";
    }
    @PostMapping("/home_login")
    public String application_home_login(Model model, @RequestParam String username) {
        model.addAttribute("name", CurrentUser.getUserName());
        List<Film> aux = filmService.filmRepository.findAll();
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("films", aux.subList(0, 5));
        return "home_login_template";
    }

    @GetMapping("/home_login/{id}")
    public String showFilm(@PathVariable Long id, @RequestParam(required = false, defaultValue = "") String username,
            Model model) {
        Film film = filmService.filmRepository.getById(id);
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @GetMapping("/films_login")
    public String films_login(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("films", filmService.filmRepository.findAll());
        return "films_login_template";
    }
    @GetMapping("/films_login/Director")
    public String films_login_director(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("films", filmService.filmRepository.findAllOrderByDirector());
        return "films_login_template";
    }
    @GetMapping("/films_login/rating")
    public String films_login_rating(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("films", filmService.filmRepository.findAllOrderByRating());
        return "films_login_template";
    }
    @GetMapping("/films_login/title")
    public String films_login_title(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("films", filmService.filmRepository.findAllOrderByTitle());
        return "films_login_template";
    }


    @GetMapping("/films_login/{id}")
    public String showFilmFilms(@PathVariable Long id,
            @RequestParam(required = false, defaultValue = "") String name, Model model) {
        Film film = filmService.filmRepository.getById(id);
        model.addAttribute("reviews", film.getReviews());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/films_login/{id}/")
    public String Postcomment(@PathVariable("id") Long id,
            @RequestParam(required = false, defaultValue = "") String name, Model model, String comment) {
        Film film = filmService.filmRepository.getById(id);
        Review aux_comment = new Review(comment);
        film.addReview(aux_comment);
        filmService.filmRepository.save(film);
        model.addAttribute("reviews", film.getReviews());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("film", film);
        return "film_login_template";

    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/home_login/")
    public String Log(
            @RequestParam(required = false, defaultValue = "") String username, @RequestParam(required = false, defaultValue = "") String password, Model model) {
            List<Client> aux = clientService.clientRepository.findByUserNameAndPassword(username, password);           
            if (aux.isEmpty()){
                return "home_template";
            }else{ 
                CurrentUser = aux.get(0);
                model.addAttribute("name", CurrentUser.getUserName());
                List<Film> aux2 = filmService.filmRepository.findAll();
                model.addAttribute("films", aux2.subList(0, 5));
                model.addAttribute("logo", CurrentUser.getLogo());
                model.addAttribute("user", CurrentUser);
                return "home_login_template";
            }               
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/home/")
    public String postUser(
        @RequestParam(required = false, defaultValue = "") String email,@RequestParam(required = false, defaultValue = "") String name,@RequestParam(required = false, defaultValue = "") String password, Model model) {   
        Client user = new Client( email, name, password); 
        clientService.clientRepository.save(user);
    return "home_template";
}

    @GetMapping("/films_login_added/{id}")
    public String addFilm(@PathVariable Long id, @RequestParam(required = false, defaultValue = "") String name,
            Model model) {
        Film film = filmService.filmRepository.getById(id);
        CurrentUser.getCart().add(film.getTitle());
        clientService.clientRepository.save(CurrentUser);
        model.addAttribute("reviews", film.getReviews());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("name", CurrentUser.getUserName());       
        model.addAttribute("film", film);
        return "film_login_template";
    }

    @GetMapping("/films")
    public String application_films(Model model) {
        model.addAttribute("films", filmService.filmRepository.findAll());
        return "films_template";
    }
    @GetMapping("/films/Director")
    public String films_director(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        
        model.addAttribute("films", filmService.filmRepository.findAllOrderByDirector());
        return "films_template";
    }
    @GetMapping("/films/rating")
    public String films_rating(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        
        model.addAttribute("films", filmService.filmRepository.findAllOrderByRating());
        return "films_template";
    }
    @GetMapping("/films/title")
    public String films_title(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        
        model.addAttribute("films", filmService.filmRepository.findAllOrderByTitle());
        return "films_template";
    }
    @GetMapping("/films/{id}")
    public String showFilm(@PathVariable("id") Long id, Model model) {
        Film film = filmService.filmRepository.getById(id);
        model.addAttribute("reviews", film.getReviews());
        model.addAttribute("film", film);
        return "film_template";

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/films/{id}/")
    public String Postcomment(@PathVariable("id") Long id, Model model, String comment) {
        Film film = filmService.filmRepository.getById(id);
        Review aux_comment = new Review(comment);
        film.addReview(aux_comment);  
        filmService.filmRepository.save(film);
        film.getReviews();
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
        model.addAttribute("cart", CurrentUser.getCart());
        model.addAttribute("name", CurrentUser.getUserName());
        model.addAttribute("logo", CurrentUser.getLogo());
        return "user_page";
    }

    @PostMapping("/user_page/")
    public String userPage(@RequestParam(required = false, defaultValue = "") String name, String logo, Model model) {
        CurrentUser.setLogo(logo);
        clientService.clientRepository.save(CurrentUser); 
        model.addAttribute("cart", CurrentUser.getCart());
        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("name", CurrentUser.getUserName());    
        return "user_page";
    }

    @GetMapping("/user_page/delete/{title}")
    public String userPaged(
            @PathVariable("title") String title, Model model) {
            CurrentUser.getCart().remove(title);
            clientService.clientRepository.save(CurrentUser);

        model.addAttribute("logo", CurrentUser.getLogo());
        model.addAttribute("cart", CurrentUser.getCart());
        model.addAttribute("name", CurrentUser.getUserName());
        return "user_page";
    }
   
}
