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

        private Map<Long, User> UserHashMap = new ConcurrentHashMap<>();
        private AtomicLong id = new AtomicLong();

        public UserService() {
                long tem = id.incrementAndGet();
                User user = new User();           
        }

        public Collection<User> getNum(int i) {
                return UserHashMap.values()
                                .stream()
                                .limit(i)
                                .collect(Collectors.toList());
        }
        public Long getId(){
                return this.id.incrementAndGet();
        }

        public Collection<User> getAll() {
                return UserHashMap.values();
        }

        public User getUserById(Long id) {
                return UserHashMap.get(id);
        }

        public User getUserByEmail(String name) {
                Collection<User> users = getAll();
                for (User user : users) {
                        if (user.getName().equals(name)) {
                            return user;
                        }
                }
                return null;
        }

        public User createFilm(User user) {
                long tem = id.incrementAndGet();
                user.setId(tem);
                UserHashMap.put(tem, user);
                return user;
        }
}
