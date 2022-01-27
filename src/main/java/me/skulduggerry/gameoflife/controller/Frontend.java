package me.skulduggerry.gameoflife.controller;

import static me.skulduggerry.gameoflife.controller.Binding.CURRENT_GENERATION_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.INDEX_FORWARD;
import static me.skulduggerry.gameoflife.controller.Binding.NEXT_GENERATION_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.ROOT;
import static me.skulduggerry.gameoflife.controller.Binding.UPLOAD_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Frontend {

    @GetMapping(ROOT)
    public String gameOfLife(Model model) {
        model.addAttribute("current_gen_endpoint", CURRENT_GENERATION_PATH);
        model.addAttribute("next_gen_endpoint", NEXT_GENERATION_PATH);
        model.addAttribute("upload_endpoint", UPLOAD_PATH);
        return INDEX_FORWARD;
    }
}
