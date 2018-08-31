package ru.sdroman.carstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import ru.sdroman.carstore.domain.User;
import ru.sdroman.carstore.service.UserService;


/**
 * @author sdroman
 * @since 08.2018
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    /**
     * User service.
     */
    private UserService userService;

    /**
     * Constructor.
     *
     * @param userService UserService
     */
    @Autowired
    public UserDetailServiceImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * Locates the user based on the username.
     *
     * @param username the username identifying the user whose data is required.
     * @return populated user record
     * @throws UsernameNotFoundException if the user could not be found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByName(username);
        org.springframework.security.core.userdetails.User.UserBuilder builder;

        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
            builder.roles(user.getRole().getName());

        } else {
            throw new UsernameNotFoundException("Error. User not found.");
        }
        return builder.build();
    }
}
