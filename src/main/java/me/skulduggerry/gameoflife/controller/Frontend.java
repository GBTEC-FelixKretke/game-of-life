package me.skulduggerry.gameoflife.controller;

import static me.skulduggerry.gameoflife.controller.Binding.*;
import static me.skulduggerry.gameoflife.controller.ModelConstants.FILE;
import static me.skulduggerry.gameoflife.controller.ModelConstants.MESSAGE;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Frontend {

    @GetMapping(ROOT)
    public String gameOfLife(Model model) {
        model.addAttribute("message", MESSAGE);
        model.addAttribute("uploadEndpoint", UPLOAD_PATH);
        model.addAttribute("file", FILE);
        return INDEX_FORWARD;
    }
}
