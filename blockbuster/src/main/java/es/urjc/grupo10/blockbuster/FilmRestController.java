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

    /*
     * @Autowired
     * private ReviewService reviewService
     */

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

    @GetMapping("/{id}/reviews")
    public ResponseEntity<Object> getReviewsByFilmId(@PathVariable Long id) {
        Film film = filmService.getFilmById(id);
        if (film == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(film.getReviews());
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<Film> addReview(@PathVariable Long id, @RequestBody Review review) {
        Film film = filmService.getFilmById(id);
        if (film == null) {
            return ResponseEntity.notFound().build();
        }
        film.getReviews().add(review.toStringReview());
        return ResponseEntity.ok(film);
    }

    /*
     * @DeleteMapping("/{id}/reviews/{reviewId}")
     * public ResponseEntity<Film> deleteReview(@PathVariable("id") Long id,
     * 
     * @PathVariable("reviewId") Long reviewId) {
     * Film film = filmService.getFilmById(id);
     * if (film == null) {
     * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     * }
     * boolean result = filmService.deleteReview(film, reviewId);
     * if (result) {
     * return new ResponseEntity<>(film, HttpStatus.OK);
     * } else {
     * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     * }
     * }
     * 
     * @GetMapping("/{id}/reviews/{reviewId}")
     * public ResponseEntity<String> getReview(@PathVariable Long id, @PathVariable
     * Long reviewId) {
     * Film film = filmService.getFilmById(id);
     * if (film == null) {
     * return ResponseEntity.notFound().build();
     * }
     * String review = film.getReviewById(reviewId);
     * if (review == null) {
     * return ResponseEntity.notFound().build();
     * }
     * return ResponseEntity.ok(review);
     * }
     */
}
