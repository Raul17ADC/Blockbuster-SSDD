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
    private PeliculaService peliculaService;

    /*
     * @Autowired
     * private ReviewService reviewService
     */

    @GetMapping("/")
    public Collection<Pelicula> getFilms() {
        return peliculaService.getAll();
    }

    @GetMapping("/{id}")
    public Pelicula getFilmById(@PathVariable Long id) {
        return peliculaService.getFilmById(id);
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<Object> addReview(@PathVariable Long id, @RequestBody Review review) {
        Pelicula pelicula = peliculaService.getFilmById(id);
        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }
        pelicula.getReviews().add(review.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }

}
