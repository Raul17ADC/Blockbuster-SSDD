package es.urjc.grupo10.blockbuster.ServiceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.grupo10.blockbuster.Repository.ReviewRepository;
import jakarta.annotation.PostConstruct;
@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    
}
