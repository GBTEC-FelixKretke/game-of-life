package me.skulduggerry.gameoflife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Frontend {

    @GetMapping("/")
    public String gameOfLife() {
        return "index";
    }
}
