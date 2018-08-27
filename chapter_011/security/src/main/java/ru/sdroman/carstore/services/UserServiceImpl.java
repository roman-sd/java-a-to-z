package ru.sdroman.carstore.services;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sdroman.carstore.models.User;
import ru.sdroman.carstore.repositories.UserRepository;

import java.util.List;

/**
 * @author sdroman
 * @since 08.2018
 */
@Component
public class UserServiceImpl implements UserService {

    /**
     * User repository.
     */
    private UserRepository userRepo;

    /**
     * Constructor.
     *
     * @param userRepo UserRepository
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUser(int id) {
        return this.userRepo.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return Lists.newArrayList(this.userRepo.findAll());
    }

    /**
     * Returns user by name.
     *
     * @param name String
     * @return User
     */
    @Override
    public User getUserByName(String name) {
        return this.userRepo.findByName(name);
    }
}
