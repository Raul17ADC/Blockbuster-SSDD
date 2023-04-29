package es.urjc.grupo10.blockbuster;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private Map<Long, Client> userHashMap = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong();

    public Collection<Client> getNum(int i) {
        return userHashMap.values()
                .stream()
                .limit(i)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return this.id.incrementAndGet();
    }

    public Collection<Client> getAll() {
        return userHashMap.values();
    }

    public Client getUserById(Long id) {
        return userHashMap.get(id);
    }

    public Client getUserByNameAndPassword(String name,String password) {
        Collection<Client> users = getAll();
        for (Client user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Client createUser(Client user) {
        Optional<Client> optionalFilm = userHashMap.values()
                .stream()
                .filter(p -> p.equals(user))                  
                .findFirst();
        if (optionalFilm.isPresent()) {
            // If a movie of the same type already exists, it is not added and the one that
            // was already in the collection is returned
            return optionalFilm.get();
        } else {
            long tem = id.incrementAndGet();
            
            userHashMap.put(tem, user);
            return user;
        }
    }
    public Map<Long, Client> getUserHashMap() {
        return userHashMap;
    }
    public void printUserHashMap() {
        System.out.println("Contenido del HashMap de usuarios: " + userHashMap.toString());
    }
}
