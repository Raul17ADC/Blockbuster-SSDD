package es.urjc.grupo10.blockbuster;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.urjc.grupo10.blockbuster.*;

@RestController
@RequestMapping("/api")
public class FilmRestController {
    @Autowired
    private PeliculaService peliculaService;

    /*
     * @Autowired
     * private ReviewService reviewService
     */

    @GetMapping("/")
    public Collection<Pelicula> getFilms() {
        return peliculaService.getAll();
    }

}
