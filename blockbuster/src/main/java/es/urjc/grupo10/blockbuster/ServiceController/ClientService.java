package es.urjc.grupo10.blockbuster.Service;

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
    Client client = new Client( "aaa@aaaa", "aaa", "aaa");
    clientRepository.save(client);
    Client client2 = new Client( "bbb@bbb", "bbb", "bbb");
    clientRepository.save(client2);
    }
}
