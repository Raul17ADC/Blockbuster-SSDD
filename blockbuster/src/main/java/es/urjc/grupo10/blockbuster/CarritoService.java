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
public class CarritoService {

    private Map<Long, Pelicula> peliculaHashMap = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong();

    public CarritoService() {

    }

    public Collection<Pelicula> getRecomendada(int i) {
        return peliculaHashMap.values()
                .stream()
                .limit(i)
                .collect(Collectors.toList());
    }

    public Collection<Pelicula> getAll() {
        return peliculaHashMap.values();
    }

    public Pelicula getFilmById(Long id) {
        return peliculaHashMap.get(id);
    }

    

    public Collection<Pelicula> getFilmsByGenre(String genero) {
        Collection<Pelicula> peliculas = getAll();
        Collection<Pelicula> peliculasByGenre = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getGeneros().contains(genero)) {
                peliculasByGenre.add(pelicula);
            }
        }
        return peliculasByGenre;
    }

    public Pelicula deletePeliculaById(Long id) {
        return peliculaHashMap.remove(id);
    }

    public Pelicula createPelicula(Pelicula pelicula) {
    Optional<Pelicula> optionalPelicula = peliculaHashMap.values()
            .stream()
            .filter(p -> p.equals(pelicula))
            .findFirst();
    if (optionalPelicula.isPresent()) {
        // si ya existe una película igual, no se agrega y se devuelve la que ya estaba en la colección
        return optionalPelicula.get();
    } else {
        long tem = id.incrementAndGet();
        pelicula.setId(tem);
        peliculaHashMap.put(tem, pelicula);
        return pelicula;
    }
}

}
