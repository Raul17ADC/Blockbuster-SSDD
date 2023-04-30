package es.urjc.grupo10.blockbuster.ServiceController;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.grupo10.blockbuster.Class.Actor;
import es.urjc.grupo10.blockbuster.Class.Film;
import es.urjc.grupo10.blockbuster.Class.Review;
import es.urjc.grupo10.blockbuster.Repository.FilmRepository;
import es.urjc.grupo10.blockbuster.Repository.ReviewRepository;
import es.urjc.grupo10.blockbuster.Repository.ActorRepository;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ActorRepository actorRepository;

    @PostConstruct
    public void init() {
        Film film = new Film("Oso vicioso", "Elizabeth Banks", "Jimmy Warden",
                "https://www.youtube.com/embed/CvYGl5BESEI",
                "Cuenta la historia de un narcotraficante cuyo avión se estrella con un cargamento de cocaína que es encontrada por un oso negro, quien se la come.",
                "https://www.lahiguera.net/cinemania/pelicula/10524/oso_vicioso-cartel-10824.jpg", 6.0);

        Actor actor1 = new Actor("Keri Russell");
        Actor actor2 = new Actor("Alden Ehrenreich");
        Actor actor3 = new Actor("O'Shea Jackson Jr");
        film.setGenres(new ArrayList<String>(Arrays.asList("Comedia", "Suspense")));
        Review aux = new Review("ta chido");
        reviewRepository.save(aux);
        filmRepository.save(film);
        film.addReview(aux);
        filmRepository.save(film);

        Film film2 = new Film("John Wick 3", "Chad Stahelski", "Derek Kolstad",
                "https://www.youtube.com/embed/30R7Io_DmyU",
                "John Wick huye tras matar a un miembro del gremio internacional de asesinos, y con un precio de 14 millones de dólares por su cabeza, es el objetivo de sicarios de todo el mundo.",
                "https://www.guiadecadiz.com/sites/default/files/peliculas/2019/31-05/john_wick_chapter_3_parabellum.jpg",
                7.4);

        Actor actor11 = new Actor("Keanu Reeves");
        Actor actor12 = new Actor("Halle Berry");
        Actor actor13 = new Actor("Ian McShane");
        Actor actor4 = new Actor("Anjelica Huston");
        Actor actor5 = new Actor("Mark Dacascos");
        Actor actor6 = new Actor("Laurence Fishburne");
        Actor actor7 = new Actor("Lance Reddick");

        film2.setGenres(new ArrayList<String>(Arrays.asList("Accion", "Crimen", "Suspense")));

        filmRepository.save(film2);

        Film film3 = new Film("Karate a muerte en Torremolinos", "Pedro Temboury", "Pedro Temboury",
                "https://www.youtube.com/embed/Fova8pD_5wE",
                "Para impedir que el doctor Maldedades invoque a Jocántaro y de paso salvar a su novia, Jess y la Hermandad de Surferos Católicos deberán enfrentarse con kárate a magia negra y ninjas zombi.",
                "https://www.lavanguardia.com/peliculas-series/images/movie/poster/2003/3/w1280/o8tUXtsXdlEy2PguPWrVh88sTTN.jpg",
                3.4);

        Actor actor21 = new Actor("Curro Cruz");
        Actor actor22 = new Actor("Sonia Okomo");
        Actor actor23 = new Actor("Julio Sanjuán");
        film3.setGenres(new ArrayList<String>(Arrays.asList("Accion", "Comedia", "Fantasia")));

        filmRepository.save(film3);

        Film film4 = new Film("The Equalizer 2", "Antoine Fuqua", "Richard Wenk",
                "https://www.youtube.com/embed/IibsmbB6PXQ",
                "Robert McCall imparte una justicia inquebrantable a los explotados y oprimidos, pero eso podría cambiar cuando se trata de un ser amado.",
                "https://m.media-amazon.com/images/M/MV5BMTU2OTYzODQyMF5BMl5BanBnXkFtZTgwNjU3Njk5NTM@._V1_FMjpg_UX1000_.jpg",
                6.7);

        Actor actor31 = new Actor("Denzel Washington");
        Actor actor32 = new Actor("Pedro Pascal");
        Actor actor33 = new Actor("Bill Pullman");
        Actor actor34 = new Actor("Melissa Leo");
        Actor actor35 = new Actor("Ashton Sanders");
        Actor actor36 = new Actor("Jonathan Scarfe");
        ;
        film4.setGenres(new ArrayList<String>(Arrays.asList("Accion", "Crimen", "Suspense")));

        filmRepository.save(film4);

        Film film5 = new Film("Resacón en Las Vegas", "Todd Phillips", "Jon Lucas",
                "https://www.youtube.com/embed/_esKPsFVjsg",
                "Tres amigos se despiertan en Las Vegas después de una despedida de soltero sin memoria alguna de la noche anterior y habiendo perdido al novio. Recorren la ciudad para encontrarle antes de su boda.",
                "https://www.lavanguardia.com/peliculas-series/images/movie/poster/2009/6/w1280/rqeim09TdaflSvPNVnCTBjUHlKu.jpg",
                7.7);

        Actor actor41 = new Actor("Bradley Cooper");
        Actor actor42 = new Actor("Ed Helms");
        Actor actor43 = new Actor("Zach Galifianakis");
        Actor actor44 = new Actor("Justin Bartha");
        Actor actor45 = new Actor("Heather Graham");
        Actor actor46 = new Actor("Sasha Barrese");
        film5.setGenres(new ArrayList<String>(Arrays.asList("Drama", "Depeorte")));

        filmRepository.save(film5);

        Film film6 = new Film("AIR", "Ben Affleck", "Alex Convery",
                "https://www.youtube.com/embed/KBiw_HbryZs",
                "Sigue la historia del vendedor de calzado Sonny Vaccaro, y cómo él llevó a Nike en su búsqueda del mejor atleta en la historia del baloncesto: Michael Jordan.",
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/air-774147366-large-642c47dcdc2e3.jpeg?resize=480:*",
                7.8);

        Actor actor51 = new Actor("Matt Damon");
        Actor actor52 = new Actor("Ben Affleck");
        Actor actor53 = new Actor("Viola Davis");
        Actor actor54 = new Actor("Chris Messina");
        Actor actor55 = new Actor("Marlon Wayans");
        Actor actor56 = new Actor("Chris Tucker");
        
        film6.setGenres(new ArrayList<String>(Arrays.asList("Comedia")));

        filmRepository.save(film6);

    }
}