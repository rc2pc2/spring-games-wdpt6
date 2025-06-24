package org.lessons.java.spring.wdpt6.spring_games_wdpt6.repository;

import java.util.List;

import org.lessons.java.spring.wdpt6.spring_games_wdpt6.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
    public List<Game> findByTitleContainingIgnoreCase(String title);
}
