package me.skulduggerry.gameoflife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Frontend {

    @GetMapping("/")
    public String gameOfLife(Model model) {
        model.addAttribute("message", "Upload a file.");
        return "index";
    }
}
