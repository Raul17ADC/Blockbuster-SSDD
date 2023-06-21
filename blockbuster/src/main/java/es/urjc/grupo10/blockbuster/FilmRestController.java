package es.urjc.grupo10.blockbuster;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FilmRestController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private UserService userService;

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

    @GetMapping("/users")
    public Collection<User> getUsers() {
        return userService.getAll();
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        if (newUser != null) {
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("users/{username}")
    public ResponseEntity<String> deleteUserByUsername(@PathVariable String username) {
        User user = userService.getUserName(username);

        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        userService.deleteUser(user);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @PutMapping("/users/{username}/password")
    public ResponseEntity<String> updateUserPassword(@PathVariable String username, @RequestBody String newPassword) {
        User user = userService.getUserName(username);

        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        user.setPassword(newPassword);
        userService.updateUser(user);

        return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        Film newFilm = filmService.createFilm(film);
        if (newFilm != null) {
            return new ResponseEntity<>(newFilm, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("films/{id}")
    public ResponseEntity<String> deleteFilmById(@PathVariable Long id) {
        Film film = filmService.getFilmById(id);

        if (film == null) {
            return new ResponseEntity<>("Film not found", HttpStatus.NOT_FOUND);
        }

        filmService.deleteFilm(film);
        return new ResponseEntity<>("Film deleted", HttpStatus.OK);
    }

    @PutMapping("/films/{id}/name")
    public ResponseEntity<String> updateFilmName(@PathVariable Long id, @RequestBody String newName) {
        Film film = filmService.getFilmById(id);

        if (film == null) {
            return new ResponseEntity<>("Film not found", HttpStatus.NOT_FOUND);
        }

        film.setTitle(newName);
        filmService.updateFilm(film);

        return new ResponseEntity<>("Film name updated successfully", HttpStatus.OK);
    }

    @PostMapping("/addLike/{id}/")
    public ResponseEntity<Map<String, Object>> addLike(@PathVariable Long id) {
        Film film = filmService.getFilmById(id);
        Map<String, Object> response = new HashMap<>();
        if (film == null) {
            response.put("mensaje", "No se ha podido agregar un like al anuncio con ID " + id);
            return ResponseEntity.badRequest().body(response);
        }
        filmService.addLike(id);
        response.put("likes", film.getLikes());
        response.put("mensaje", "Like agreagado al anuncio con ID " + id + " correctamente");
        return ResponseEntity.ok().body(response);
    }

}
