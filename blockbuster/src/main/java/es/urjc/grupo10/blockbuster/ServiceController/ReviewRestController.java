package es.urjc.grupo10.blockbuster.ServiceController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.urjc.grupo10.blockbuster.Class.Review;

@RestController
@RequestMapping("/api/reviews")
public class ReviewRestController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/")
    public ResponseEntity<List<Review>> getAllReviews() {
        return new ResponseEntity<>(reviewService.reviewRepository.findAll(), HttpStatus.OK);
    }

}
