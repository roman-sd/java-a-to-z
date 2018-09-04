package ru.sdroman.carstore.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sdroman.carstore.domain.User;
import ru.sdroman.carstore.repository.UserRepository;
import ru.sdroman.carstore.service.UserService;

import java.util.List;
import java.util.Optional;

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
        Optional<User> optional = this.userRepo.findById(id);
        return optional.isPresent() ? optional.get() : new User();
    }

    @Override
    public User saveUser(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return Lists.newArrayList(this.userRepo.findAll());
    }

    @Override
    public User getUserByName(String name) {
        return this.userRepo.findByName(name);
    }
}
