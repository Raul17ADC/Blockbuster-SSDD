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
public class FilmService {

        private Map<Long, Film> filmHashMap = new ConcurrentHashMap<>();
        private AtomicLong id = new AtomicLong();

        public FilmService() {
                long tem = id.incrementAndGet();
                Film film = new Film(tem, "Oso vicioso", "Elizabeth Banks", "Jimmy Warden",
                                "https://www.youtube.com/embed/CvYGl5BESEI",
                                "Cuenta la historia de un narcotraficante cuyo avión se estrella con un cargamento de cocaína que es encontrada por un oso negro, quien se la come.",
                                "https://www.lahiguera.net/cinemania/pelicula/10524/oso_vicioso-cartel-10824.jpg", 6.0);
                film.setActors(
                                new ArrayList<String>(Arrays.asList("Keri Russell", "Alden Ehrenreich",
                                                "O'Shea Jackson Jr")));
                film.setGenres(new ArrayList<String>(Arrays.asList("Comedia", "Suspense")));
                film.setReviews(new ArrayList<String>(Arrays.asList("Me encanta")));
                filmHashMap.put(tem, film);

                Film film2 = new Film(null, "John Wick 3", "Chad Stahelski", "Derek Kolstad",
                                "https://www.youtube.com/embed/30R7Io_DmyU",
                                "John Wick huye tras matar a un miembro del gremio internacional de asesinos, y con un precio de 14 millones de dólares por su cabeza, es el objetivo de sicarios de todo el mundo.",
                                "https://www.guiadecadiz.com/sites/default/files/peliculas/2019/31-05/john_wick_chapter_3_parabellum.jpg",
                                7.4);
                film2.setActors(new ArrayList<String>(Arrays.asList("Keanu Reeves", "Halle Berry", "Ian McShane",
                                "Anjelica Huston", "Mark Dacascos", "Laurence Fishburne", "Lance Reddick")));
                film2.setGenres(new ArrayList<String>(Arrays.asList("Accion", "Crimen", "Suspense")));
                film2.setReviews(new ArrayList<String>(Arrays.asList("Me encanta")));
                createFilm(film2);

                Film film3 = new Film(null, "Karate a muerte en Torremolinos", "Pedro Temboury", "Pedro Temboury",
                                "https://www.youtube.com/embed/Fova8pD_5wE",
                                "Para impedir que el doctor Maldedades invoque a Jocántaro y de paso salvar a su novia, Jess y la Hermandad de Surferos Católicos deberán enfrentarse con kárate a magia negra y ninjas zombi.",
                                "https://www.lavanguardia.com/peliculas-series/images/movie/poster/2003/3/w1280/o8tUXtsXdlEy2PguPWrVh88sTTN.jpg",
                                3.4);
                film3.setActors(new ArrayList<String>(Arrays.asList("Curro Cruz", "Sonia Okomo", "Julio Sanjuán")));
                film3.setGenres(new ArrayList<String>(Arrays.asList("Accion", "Comedia", "Fantasia")));
                film3.setReviews(new ArrayList<String>(Arrays.asList("Me encanta")));
                createFilm(film3);

                Film film4 = new Film(null, "The Equalizer 2", "Antoine Fuqua", "Richard Wenk",
                                "https://www.youtube.com/embed/IibsmbB6PXQ",
                                "Robert McCall imparte una justicia inquebrantable a los explotados y oprimidos, pero eso podría cambiar cuando se trata de un ser amado.",
                                "https://m.media-amazon.com/images/M/MV5BMTU2OTYzODQyMF5BMl5BanBnXkFtZTgwNjU3Njk5NTM@._V1_FMjpg_UX1000_.jpg",
                                6.7);
                film4.setActors(new ArrayList<String>(Arrays.asList("Denzel Washington", "Pedro Pascal", "Bill Pullman",
                                "Melissa Leo", "Ashton Sanders", "Jonathan Scarfe")));
                film4.setGenres(new ArrayList<String>(Arrays.asList("Accion", "Crimen", "Suspense")));
                film4.setReviews(new ArrayList<String>(Arrays.asList("Me encanta")));
                createFilm(film4);

                Film film5 = new Film(null, "Resacón en Las Vegas", "Todd Phillips", "Jon Lucas",
                                "https://www.youtube.com/embed/_esKPsFVjsg",
                                "Tres amigos se despiertan en Las Vegas después de una despedida de soltero sin memoria alguna de la noche anterior y habiendo perdido al novio. Recorren la ciudad para encontrarle antes de su boda.",
                                "https://www.lavanguardia.com/peliculas-series/images/movie/poster/2009/6/w1280/rqeim09TdaflSvPNVnCTBjUHlKu.jpg",
                                7.7);
                film5.setActors(new ArrayList<String>(Arrays.asList("Bradley Cooper", "Ed Helms", "Zach Galifianakis",
                                "Justin Bartha", "Heather Graham", "Sasha Barrese", "Jeffrey Tambor")));
                film5.setGenres(new ArrayList<String>(Arrays.asList("Drama", "Depeorte")));
                film5.setReviews(new ArrayList<String>(Arrays.asList("Me encanta")));
                createFilm(film5);

                Film film6 = new Film(null, "AIR", "Ben Affleck", "Alex Convery",
                                "https://www.youtube.com/embed/KBiw_HbryZs",
                                "Sigue la historia del vendedor de calzado Sonny Vaccaro, y cómo él llevó a Nike en su búsqueda del mejor atleta en la historia del baloncesto: Michael Jordan.",
                                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/air-774147366-large-642c47dcdc2e3.jpeg?resize=480:*",
                                7.8);
                film6.setActors(new ArrayList<String>(Arrays.asList("Matt Damon", "Ben Affleck", "Viola Davis",
                                "Chris Messina", "Marlon Wayans", "Chris Tucker", "Jason Bateman")));
                film6.setGenres(new ArrayList<String>(Arrays.asList("Comedia")));
                film6.setReviews(new ArrayList<String>(Arrays.asList("Me encanta")));
                createFilm(film6);

        }

        public Collection<Film> getNum(int i) {
                return filmHashMap.values()
                                .stream()
                                .limit(i)
                                .collect(Collectors.toList());
        }

        public Collection<Film> getAll() {
                return filmHashMap.values();
        }

        public void addLike(Long id){
                Film film = filmHashMap.get(id);
                film.addLike();
            } 

        public Film getFilmById(Long id) {
                return filmHashMap.get(id);
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

        public Film createFilm(Film film) {
                long tem = id.incrementAndGet();
                film.setId(tem);
                filmHashMap.put(tem, film);
                return film;
        }

        public void deleteFilm(Film film) {
                filmHashMap.remove(film.getId());
            }           
            
        public void updateFilm(Film film) {
                filmHashMap.put(film.getId(), film);
        }
            
}
