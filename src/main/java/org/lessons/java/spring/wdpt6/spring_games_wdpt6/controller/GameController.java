package org.lessons.java.spring.wdpt6.spring_games_wdpt6.controller;

import org.lessons.java.spring.wdpt6.spring_games_wdpt6.model.Game;
import org.lessons.java.spring.wdpt6.spring_games_wdpt6.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/games")
public class GameController {
    
    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("games", gameRepository.findAll());
        return "games/index";
    }

    @GetMapping("/{id}")
    public String show( @PathVariable Integer id,Model model){

        model.addAttribute("game", gameRepository.findById(id).get());
        return "games/show";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("game", new Game());
        return "games/create";
    }

    @PostMapping
    public String store( @Valid @ModelAttribute("game") Game formGame, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "games/create";
        }

        gameRepository.save(formGame);
        return "redirect:/games";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("game", gameRepository.findById(id).get());
        return "games/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("game") Game formGame, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "games/edit";
        }

        gameRepository.save(formGame);
        return "redirect:/games";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        gameRepository.deleteById(id);
        return "redirect:/games";
    }

}
