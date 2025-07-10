package org.lessons.java.spring.wdpt6.spring_games_wdpt6.repository;

import java.util.Optional;

import org.lessons.java.spring.wdpt6.spring_games_wdpt6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
