package es.urjc.grupo10.blockbuster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    
}
