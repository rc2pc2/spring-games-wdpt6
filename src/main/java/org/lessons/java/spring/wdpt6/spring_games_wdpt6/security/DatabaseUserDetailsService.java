package org.lessons.java.spring.wdpt6.spring_games_wdpt6.security;

import java.util.Optional;

import org.lessons.java.spring.wdpt6.spring_games_wdpt6.model.User;
import org.lessons.java.spring.wdpt6.spring_games_wdpt6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userAttempt = userRepository.findByUsername(username);

        if (userAttempt.isEmpty()){
            throw new UsernameNotFoundException(username + " cannot be found");
        }

        return new DatabaseUserDetails(userAttempt.get());
    }
    
}
