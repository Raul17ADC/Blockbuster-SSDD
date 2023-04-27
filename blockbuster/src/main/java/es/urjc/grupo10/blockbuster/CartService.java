package es.urjc.grupo10.blockbuster;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CartService {

    private Map<Long, Film> filmHashMap = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong();

    public CartService() {
    }

    public Collection<Film> getRecomendada(int i) {
        return filmHashMap.values()
                .stream()
                .limit(i)
                .collect(Collectors.toList());
    }

    public Collection<Film> getAll() {
        return filmHashMap.values();
    }

    public Film getFilmById(Long id) {
        return filmHashMap.get(id);
    }
     public void deleteAllFilms() {
        filmHashMap.clear();
    }
    public Collection<Film> getFilmsByGenre(String genero) {
        Collection<Film> films = getAll();
        Collection<Film> filmsByGenre = new ArrayList<>();
        for (Film film : films) {
            if (film.getGenres().contains(genero)) {
                filmsByGenre.add(film);
            }
        }
        return filmsByGenre;
    }
    
    public Film deleteFilmById(Long id) {
        return filmHashMap.remove(id);
    }

    public Film createFilm(Film film) {
        Optional<Film> optionalFilm = filmHashMap.values()
                .stream()
                .filter(p -> p.equals(film))
                .findFirst();
        if (optionalFilm.isPresent()) {
            // If a movie of the same type already exists, it is not added and the one that
            // was already in the collection is returned
            return optionalFilm.get();
        } else {
            long tem = id.incrementAndGet();
            film.setId(tem);
            filmHashMap.put(tem, film);
            return film;
        }
    }
}
