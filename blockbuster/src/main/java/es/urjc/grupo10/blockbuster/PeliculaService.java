package es.urjc.grupo10.blockbuster;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PeliculaService {

    private Map<Long, Pelicula> peliculaHashMap = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong();

    public PeliculaService() {
        long tem = id.incrementAndGet();
        Pelicula pelicula = new Pelicula(null, "Pelicula1", "Director1", "Guionista1", "Trailer1", "Descripcion1",5.0);
        pelicula.setActores(new ArrayList<String>(Arrays.asList("Actor1", "Actor2")));
        pelicula.setGeneros(new ArrayList<String>(Arrays.asList("Genero1", "Genero2")));
        peliculaHashMap.put(tem, pelicula);
    }

    public Collection<Pelicula> getAll() {
        return peliculaHashMap.values();
    }

    public Pelicula createPelicula(Pelicula pelicula) {
        long tem = id.incrementAndGet();
        pelicula.setId(tem);
        peliculaHashMap.put(tem, pelicula);
        return pelicula;
    }
}
