package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {

    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);


    private Map<Integer, User> repositoryUser = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    @Override
    public boolean delete(int id) {
        return repositoryUser.remove(id) != null;
    }

    @Override
    public User save(User user) {
        if(user.isEnabled()){
            user.setId(counter.incrementAndGet());
            repositoryUser.put(user.getId(), user);
        }
        return repositoryUser.computeIfPresent(user.getId(), (id, oldUser) -> user);
    }

    //here!!!!!!!!!
    @Override
    public User get(int id) {

        if(repositoryUser.get(id) == null){
            return null;
        }
       return repositoryUser.get(id);
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");
        return Collections.emptyList();
        //return Arrays.asList(repositoryUser.values());

      //  return repositoryUser.values();
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);
        return repositoryUser.get(email);
    }
}
