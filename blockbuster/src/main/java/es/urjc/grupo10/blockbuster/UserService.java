package es.urjc.grupo10.blockbuster;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Objects;
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

    public User getUserName(String name) {
        Collection<User> users = getAll();
        for (User user : users) {
            if (user.getUserName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByNameAndPassword(String name, String password) {
        Collection<User> users = getAll();
        for (User user : users) {
            if (user.getUserName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User createUser(User user) {
        Optional<User> optionalFilm = userHashMap.values()
                .stream()
                .filter(p -> p.equals(user))
                .findFirst();
        if (optionalFilm.isPresent()) {
            // If a movie of the same type already exists, it is not added and the one that
            // was already in the collection is returned
            return optionalFilm.get();
        } else {
            long tem = id.incrementAndGet();
            user.setUserCode(tem);
            userHashMap.put(tem, user);
            return user;
        }
    }

    public void deleteUser(User user) {
        userHashMap.values().removeIf(u -> u.getUserName().equals(user.getUserName()));
    }

    public void updateUser(User user) {
        User existingUser = userHashMap.values()
                .stream()
                .filter(u -> u.getUserName().equals(user.getUserName()))
                .findFirst()
                .orElse(null);

        if (existingUser != null) {
            Long userCode = userHashMap.entrySet()
                    .stream()
                    .filter(entry -> Objects.equals(entry.getValue(), existingUser))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);

            if (userCode != null) {
                userHashMap.remove(userCode);
                user.setUserCode(userCode);
                userHashMap.put(userCode, user);
            }
        }
    }

    public Map<Long, User> getUserHashMap() {
        return userHashMap;
    }

    public void printUserHashMap() {
        System.out.println("Contenido del HashMap de usuarios: " + userHashMap.toString());
    }
}
