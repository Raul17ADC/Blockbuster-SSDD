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

    private Map<Long, User> userHashMap = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong();

    public Collection<User> getNum(int i) {
        return userHashMap.values()
                .stream()
                .limit(i)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return this.id.incrementAndGet();
    }

    public Collection<User> getAll() {
        return userHashMap.values();
    }

    public User getUserById(Long id) {
        return userHashMap.get(id);
    }

    public User getUserByEmail(String email) {
        Collection<User> users = getAll();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User createUser(User user) {
        userHashMap.put(user.getId(), user);
        return user;
    }
    public Map<Long, User> getUserHashMap() {
        return userHashMap;
    }
    public void printUserHashMap() {
        System.out.println("Contenido del HashMap de usuarios: " + userHashMap.toString());
    }
}
