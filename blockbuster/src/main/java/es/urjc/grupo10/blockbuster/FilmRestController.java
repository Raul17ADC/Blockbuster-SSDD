package es.urjc.grupo10.blockbuster;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.urjc.grupo10.blockbuster.*;

@RestController
@RequestMapping("/api")
public class FilmRestController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/")
    public Collection<Film> getFilms() {
        return filmService.getAll();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.getFilmById(id);
    }

    @GetMapping("/genero/{genero}")
    public Collection<Film> getFilmsByGenre(@PathVariable String genero) {
        return filmService.getFilmsByGenre(genero);
    }

    
}
