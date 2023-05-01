package es.urjc.grupo10.blockbuster.ServiceController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.urjc.grupo10.blockbuster.Class.Film;

@RestController
@RequestMapping("/api/films")
public class FilmRestController {

    @Autowired
    FilmService filmService;

    @GetMapping("/")
    public ResponseEntity<List<Film>> getAllFilms() {
        return new ResponseEntity<>(filmService.filmRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/director")
    public ResponseEntity<List<Film>> getAllFilmsOrderByDirector() {
        return new ResponseEntity<List<Film>>(filmService.filmRepository.findAllOrderByDirector(), HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<List<Film>> getAllFilmsOrderByTitle() {
        return new ResponseEntity<List<Film>>(filmService.filmRepository.findAllOrderByTitle(), HttpStatus.OK);
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Film>> getAllFilmsOrderByRating() {
        return new ResponseEntity<List<Film>>(filmService.filmRepository.findAllOrderByRating(), HttpStatus.OK);
    }
}
