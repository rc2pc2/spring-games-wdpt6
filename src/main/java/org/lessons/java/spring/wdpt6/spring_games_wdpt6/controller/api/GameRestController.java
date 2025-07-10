package org.lessons.java.spring.wdpt6.spring_games_wdpt6.controller.api;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring.wdpt6.spring_games_wdpt6.model.Game;
import org.lessons.java.spring.wdpt6.spring_games_wdpt6.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/games")
public class GameRestController {
    
    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public List<Game> index(){
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> show(@PathVariable Integer id){
        Optional<Game> gameAttempt = gameRepository.findById(id);

        if (gameAttempt.isEmpty()){
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Game>(gameAttempt.get(), HttpStatus.OK);
    }
}
