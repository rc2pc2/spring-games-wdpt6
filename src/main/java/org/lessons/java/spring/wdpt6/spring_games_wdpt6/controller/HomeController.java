package org.lessons.java.spring.wdpt6.spring_games_wdpt6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    
    @GetMapping
    public String home(){
        return "pages/homepage";
    }
}
