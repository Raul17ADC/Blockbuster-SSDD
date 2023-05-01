package es.urjc.grupo10.blockbuster.ServiceController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.urjc.grupo10.blockbuster.Class.Actor;

@RestController
@RequestMapping("/api/actors")
public class ActorRestController {

    @Autowired
    ActorService actorService;

    @GetMapping("/")
    public ResponseEntity<List<Actor>> getAllActors() {
        return new ResponseEntity<>(actorService.actorRepository.findAll(), HttpStatus.OK);
    }
}
