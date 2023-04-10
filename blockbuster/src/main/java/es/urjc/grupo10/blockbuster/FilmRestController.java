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

    @GetMapping("/genero/{genero}")
    public Collection<Pelicula> getFilmsByGenre(@PathVariable String genero) {
        return peliculaService.getFilmsByGenre(genero);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<Object> getReviewsByFilmId(@PathVariable Long id) {
        Pelicula pelicula = peliculaService.getFilmById(id);
        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pelicula.getReviews());
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<Pelicula> addReview(@PathVariable Long id, @RequestBody Review review) {
        Pelicula pelicula = peliculaService.getFilmById(id);
        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }
        pelicula.getReviews().add(review.toStringReview());
        return ResponseEntity.ok(pelicula);
    }

    /*@DeleteMapping("/{id}/reviews/{reviewId}")
    public ResponseEntity<Pelicula> deleteReview(@PathVariable("id") Long id,
            @PathVariable("reviewId") Long reviewId) {
        Pelicula pelicula = peliculaService.getFilmById(id);
        if (pelicula == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean result = peliculaService.deleteReview(pelicula, reviewId);
        if (result) {
            return new ResponseEntity<>(pelicula, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/reviews/{reviewId}")
    public ResponseEntity<String> getReview(@PathVariable Long id, @PathVariable Long reviewId) {
        Pelicula pelicula = peliculaService.getFilmById(id);
        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }
        String review = pelicula.getReviewById(reviewId);
        if (review == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(review);
    }*/

}
