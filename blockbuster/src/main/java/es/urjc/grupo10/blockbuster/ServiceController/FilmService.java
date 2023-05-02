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
        
    }
}