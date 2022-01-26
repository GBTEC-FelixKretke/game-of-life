package me.skulduggerry.gameoflife.controller;

import static me.skulduggerry.gameoflife.controller.Binding.CURRENT_GENERATION_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.INDEX_FORWARD;
import static me.skulduggerry.gameoflife.controller.Binding.NEXT_GENERATION_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.ROOT;
import static me.skulduggerry.gameoflife.controller.Binding.UPLOAD_PATH;
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
        model.addAttribute("file", FILE);
        model.addAttribute("uploadEndpoint", UPLOAD_PATH);
        model.addAttribute("currentGenEndpoint", CURRENT_GENERATION_PATH);
        model.addAttribute("nextGenEndpoint", NEXT_GENERATION_PATH);
        return INDEX_FORWARD;
    }
}
