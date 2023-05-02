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

        actorRepository.save(actor1);
        actorRepository.save(actor2);
        actorRepository.save(actor3);

        film.setGenres(new ArrayList<String>(Arrays.asList("Comedia", "Suspense")));
        Review aux = new Review("ta chido");

        reviewRepository.save(aux);
        filmRepository.save(film);
        film.addReview(aux);

        film.addActors(actor1);
        film.addActors(actor2);
        film.addActors(actor3);
        actor1.addFilm(film);
        actor2.addFilm(film);
        actor3.addFilm(film);
        filmRepository.save(film);
        actorRepository.save(actor1);
        actorRepository.save(actor2);
        actorRepository.save(actor3);

        Film film2 = new Film("John Wick 3", "Chad Stahelski", "Derek Kolstad",
                "https://www.youtube.com/embed/30R7Io_DmyU",
                "John Wick huye tras matar a un miembro del gremio internacional de asesinos, y con un precio de 14 millones de dólares por su cabeza, es el objetivo de sicarios de todo el mundo.",
                "https://www.guiadecadiz.com/sites/default/files/peliculas/2019/31-05/john_wick_chapter_3_parabellum.jpg",
                7.4);

        Actor actor11 = new Actor("Keanu Reeves");
        Actor actor12 = new Actor("Halle Berry");
        Actor actor13 = new Actor("Ian McShane");
        Actor actor14 = new Actor("Anjelica Huston");
        Actor actor15 = new Actor("Mark Dacascos");
        Actor actor16 = new Actor("Laurence Fishburne");
        Actor actor17 = new Actor("Lance Reddick");
        actorRepository.save(actor11);
        actorRepository.save(actor12);
        actorRepository.save(actor13);
        actorRepository.save(actor14);
        actorRepository.save(actor15);
        actorRepository.save(actor16);
        actorRepository.save(actor17);
        
        film2.setGenres(new ArrayList<String>(Arrays.asList("Accion", "Crimen", "Suspense")));

        filmRepository.save(film2);
        
        film2.addActors(actor11);
        film2.addActors(actor12);
        film2.addActors(actor13);
        film2.addActors(actor14);
        film2.addActors(actor15);
        film2.addActors(actor16);
        film2.addActors(actor17);

        actor11.addFilm(film2);
        actor12.addFilm(film2);
        actor13.addFilm(film2);
        actor14.addFilm(film2);
        actor15.addFilm(film2);
        actor16.addFilm(film2);
        actor17.addFilm(film2);
        
        filmRepository.save(film2);
        actorRepository.save(actor11);
        actorRepository.save(actor12);
        actorRepository.save(actor13);
        actorRepository.save(actor14);
        actorRepository.save(actor15);
        actorRepository.save(actor16);
        actorRepository.save(actor17);

        Film film3 = new Film("Karate a muerte en Torremolinos", "Pedro Temboury", "Pedro Temboury",
                "https://www.youtube.com/embed/Fova8pD_5wE",
                "Para impedir que el doctor Maldedades invoque a Jocántaro y de paso salvar a su novia, Jess y la Hermandad de Surferos Católicos deberán enfrentarse con kárate a magia negra y ninjas zombi.",
                "https://www.lavanguardia.com/peliculas-series/images/movie/poster/2003/3/w1280/o8tUXtsXdlEy2PguPWrVh88sTTN.jpg",
                3.4);

        Actor actor21 = new Actor("Curro Cruz");
        Actor actor22 = new Actor("Sonia Okomo");
        Actor actor23 = new Actor("Julio Sanjuán");
        film3.setGenres(new ArrayList<String>(Arrays.asList("Accion", "Comedia", "Fantasia")));
        
        actorRepository.save(actor21);
        actorRepository.save(actor22);
        actorRepository.save(actor23);
        filmRepository.save(film3);
        
        film3.addActors(actor21);
        film3.addActors(actor22);
        film3.addActors(actor23);
        actor21.addFilm(film3);
        actor22.addFilm(film3);
        actor23.addFilm(film3);
        filmRepository.save(film3);
        actorRepository.save(actor21);
        actorRepository.save(actor22);
        actorRepository.save(actor23);

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
        
        film4.setGenres(new ArrayList<String>(Arrays.asList("Accion", "Crimen", "Suspense")));

        filmRepository.save(film4);

        actorRepository.save(actor31);
        actorRepository.save(actor32);
        actorRepository.save(actor33);
        actorRepository.save(actor34);
        actorRepository.save(actor35);
        film4.addActors(actor31);
        film4.addActors(actor32);
        film4.addActors(actor33);
        film4.addActors(actor34);
        film4.addActors(actor35);
        actor31.addFilm(film4);
        actor32.addFilm(film4);
        actor33.addFilm(film4);
        actor34.addFilm(film4);
        actor35.addFilm(film4);
        filmRepository.save(film4);
        actorRepository.save(actor31);
        actorRepository.save(actor32);
        actorRepository.save(actor33);
        actorRepository.save(actor34);
        actorRepository.save(actor35);

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
        actorRepository.save(actor41);
        actorRepository.save(actor42);
        actorRepository.save(actor43);
        actorRepository.save(actor44);
        actorRepository.save(actor45);
        actorRepository.save(actor46);
        film5.addActors(actor41);
        film5.addActors(actor42);
        film5.addActors(actor43);
        film5.addActors(actor44);
        film5.addActors(actor45);
        film5.addActors(actor46);
        actor41.addFilm(film5);
        actor42.addFilm(film5);
        actor43.addFilm(film5);
        actor44.addFilm(film5);
        actor45.addFilm(film5);
        actor46.addFilm(film5);
        filmRepository.save(film5);
        actorRepository.save(actor41);
        actorRepository.save(actor42);
        actorRepository.save(actor43);
        actorRepository.save(actor44);
        actorRepository.save(actor45);
        actorRepository.save(actor46);

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
        actorRepository.save(actor51);
        actorRepository.save(actor52);
        actorRepository.save(actor53);
        actorRepository.save(actor54);
        actorRepository.save(actor55);
        actorRepository.save(actor56);
        film6.addActors(actor51);
        film6.addActors(actor52);
        film6.addActors(actor53);
        film6.addActors(actor54);
        film6.addActors(actor55);
        film6.addActors(actor56);
        actor51.addFilm(film6);
        actor52.addFilm(film6);
        actor53.addFilm(film6);
        actor54.addFilm(film6);
        actor55.addFilm(film6);
        actor56.addFilm(film6);
        filmRepository.save(film6);
        actorRepository.save(actor51);
        actorRepository.save(actor52);
        actorRepository.save(actor53);
        actorRepository.save(actor54);
        actorRepository.save(actor55);
        actorRepository.save(actor56);

        Film film7 = new Film("Trasformers", "Michael Bay", "Alex Kurtzman",
        "https://www.youtube.com/embed/B_CzSjhOGzM",
        "Dos razas de robots extraterrestres transformables (los villanos decepticons y los amistosos autobots ) llegan a la Tierra en busca de una misteriosa fuente de poder.",
        "https://upload.wikimedia.org/wikipedia/en/thumb/6/66/Transformers07.jpg/220px-Transformers07.jpg",
        5.7);

        Actor actor57 = new Actor("Shia LaBeouf");
        Actor actor58 = new Actor("Megan Fox");
        Actor actor59 = new Actor("Josh Duhamel");
        Actor actor60 = new Actor("Tyrese Gibson");
        Actor actor61 = new Actor("Jon Voight");
        Actor actor62 = new Actor("John Turturro");

        film7.setGenres(new ArrayList<String>(Arrays.asList("Ciencia ficcion", "Accion")));

        filmRepository.save(film7); 
        actorRepository.save(actor57);
        actorRepository.save(actor58);
        actorRepository.save(actor59);
        actorRepository.save(actor60);
        actorRepository.save(actor61);
        actorRepository.save(actor62);
        film7.addActors(actor57);
        film7.addActors(actor58);
        film7.addActors(actor59);
        film7.addActors(actor60);
        film7.addActors(actor61);
        film7.addActors(actor62);
        actor57.addFilm(film7);
        actor58.addFilm(film7);
        actor59.addFilm(film7);
        actor60.addFilm(film7);
        actor61.addFilm(film7);
        actor62.addFilm(film7);
        filmRepository.save(film7);
        actorRepository.save(actor57);
        actorRepository.save(actor58);
        actorRepository.save(actor59);
        actorRepository.save(actor60);
        actorRepository.save(actor61);
        actorRepository.save(actor62);

        Film film8 = new Film("Tenet", "Christopher Nolan", "Christopher Nolan",
        "https://www.youtube.com/embed/QxhDXmb2O3k",
        "Armado con tan solo una palabra –Tenet– el protagonista de esta historia deberá pelear por la supervivencia del mundo entero en una misión que le lleva a viajar a través del oscuro mundo del espionaje internacional.",
        "https://www.enter.co/wp-content/uploads/2020/12/POSTER-MAIN.jpg",
        7.3);

        Actor actor67 = new Actor("John David Washington");
        Actor actor68 = new Actor("Robert Pattinson");
        Actor actor69 = new Actor("Elizabeth Debicki");
        Actor actor70 = new Actor("Dimple Kapadia");
        Actor actor71 = new Actor("Kenneth Branagh");
        Actor actor72 = new Actor("Aaron Taylor-Johnson");

        film8.setGenres(new ArrayList<String>(Arrays.asList("Ciencia ficcion", "Accion")));

        filmRepository.save(film8); 
        actorRepository.save(actor67);
        actorRepository.save(actor68);
        actorRepository.save(actor69);
        actorRepository.save(actor70);
        actorRepository.save(actor71);
        actorRepository.save(actor72);
        film8.addActors(actor67);
        film8.addActors(actor68);
        film8.addActors(actor69);
        film8.addActors(actor70);
        film8.addActors(actor71);
        film8.addActors(actor72);
        actor67.addFilm(film8);
        actor68.addFilm(film8);
        actor69.addFilm(film8);
        actor70.addFilm(film8);
        actor71.addFilm(film8);
        actor72.addFilm(film8);
        filmRepository.save(film8);
        actorRepository.save(actor67);
        actorRepository.save(actor68);
        actorRepository.save(actor69);
        actorRepository.save(actor70);
        actorRepository.save(actor71);
        actorRepository.save(actor72);

        Film film9 = new Film("La llegada", "Denis Villeneuve", "Eric Heisserer",
        "https://www.youtube.com/embed/uWs5lsWXLbo",
        "Cuando naves extraterrestres comienzan a llegar a la Tierra, los altos mandos militares piden ayuda a una experta lingüista (Amy Adams) para intentar averiguar si los alienígenas vienen en son de paz o suponen una amenaza.",
        "https://www.cinemaperaestudiants.cat/admin/web/uploaddir//pelicules/arrival.jpg",
        7.9);

        Actor actor77 = new Actor("Amy Adams");
        Actor actor78 = new Actor("Jeremy Renner");
        Actor actor79 = new Actor("Forest Whitakeri");
        Actor actor80 = new Actor("Michael Stuhlbarg");
        Actor actor81 = new Actor("Mark O'Brien");
        Actor actor82 = new Actor("Nathaly Thibault");

        film9.setGenres(new ArrayList<String>(Arrays.asList("Ciencia ficcion", "Suspense")));

        filmRepository.save(film9); 
        actorRepository.save(actor77);
        actorRepository.save(actor78);
        actorRepository.save(actor79);
        actorRepository.save(actor80);
        actorRepository.save(actor81);
        actorRepository.save(actor82);
        film9.addActors(actor77);
        film9.addActors(actor78);
        film9.addActors(actor79);
        film9.addActors(actor80);
        film9.addActors(actor81);
        film9.addActors(actor82);
        actor77.addFilm(film9);
        actor78.addFilm(film9);
        actor79.addFilm(film9);
        actor80.addFilm(film9);
        actor81.addFilm(film9);
        actor82.addFilm(film9);
        filmRepository.save(film9);
        actorRepository.save(actor77);
        actorRepository.save(actor78);
        actorRepository.save(actor79);
        actorRepository.save(actor80);
        actorRepository.save(actor81);
        actorRepository.save(actor82);

        Film film10 = new Film("El ataque del tiburon de 3 cabezas", "Christopher Ray", "Jacob Cooney",
        "https://www.youtube.com/embed/X2vZJ7tvuyw",
        "La mayor máquina de matar del mundo es tres veces más mortal cuando un mutado, de tres cabezas, tiburón blanco amenaza un crucero.",
        "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQ0wA95z1oDqahbGbOo_d0mFuDbcM75JpGOFGXrQsky7FUqvRCw",
        2.2);

        Actor actor87 = new Actor("Jena Sims");
        Actor actor88 = new Actor("Danny Trejo");
        Actor actor89 = new Actor("Jaason Simmons");
        Actor actor90 = new Actor("Kimberly Battista");
        Actor actor91 = new Actor("Dawn Hamil");
        Actor actor92 = new Actor("Cristalle C. Leonard");

        film10.setGenres(new ArrayList<String>(Arrays.asList("Ciencia ficcion", "Suspense")));

        filmRepository.save(film10); 
        actorRepository.save(actor87);
        actorRepository.save(actor88);
        actorRepository.save(actor89);
        actorRepository.save(actor90);
        actorRepository.save(actor91);
        actorRepository.save(actor92);
        film10.addActors(actor87);
        film10.addActors(actor88);
        film10.addActors(actor89);
        film10.addActors(actor90);
        film10.addActors(actor91);
        film10.addActors(actor92);
        actor87.addFilm(film10);
        actor88.addFilm(film10);
        actor89.addFilm(film10);
        actor90.addFilm(film10);
        actor91.addFilm(film10);
        actor92.addFilm(film10);
        filmRepository.save(film10);
        actorRepository.save(actor87);
        actorRepository.save(actor88);
        actorRepository.save(actor89);
        actorRepository.save(actor90);
        actorRepository.save(actor91);
        actorRepository.save(actor92);
    }
}