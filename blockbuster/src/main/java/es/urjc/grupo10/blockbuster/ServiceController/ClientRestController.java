package es.urjc.grupo10.blockbuster.ServiceController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.urjc.grupo10.blockbuster.Class.Client;

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {

    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public ResponseEntity<List<Client>> getAllReviews() {
        return new ResponseEntity<>(clientService.clientRepository.findAll(), HttpStatus.OK);
    }
}
