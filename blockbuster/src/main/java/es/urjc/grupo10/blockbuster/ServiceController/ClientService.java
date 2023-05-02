package es.urjc.grupo10.blockbuster.ServiceController;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.grupo10.blockbuster.Class.Client;
import es.urjc.grupo10.blockbuster.Repository.ClientRepository;

import java.util.ArrayList;
import java.util.Arrays;
@Service

    
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @PostConstruct
    public void init()
    {
    
    }
}
