package me.skulduggerry.gameoflife.controller;

import static me.skulduggerry.gameoflife.controller.Binding.CURRENT_GENERATION_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.GENERATION_CREATOR_FORWARD;
import static me.skulduggerry.gameoflife.controller.Binding.GENERATION_CREATOR_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.INDEX_FORWARD;
import static me.skulduggerry.gameoflife.controller.Binding.INDEX_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.NEXT_GENERATION_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.ROOT;
import static me.skulduggerry.gameoflife.controller.Binding.UI_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.UPLOAD_PATH;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Frontend {

    @GetMapping(ROOT)
    public RedirectView root() {
        return new RedirectView(UI_PATH);
    }

    @GetMapping(INDEX_PATH)
    public String gameOfLife(Model model) {
        model.addAttribute("current_gen_endpoint", CURRENT_GENERATION_PATH);
        model.addAttribute("next_gen_endpoint", NEXT_GENERATION_PATH);
        model.addAttribute("upload_endpoint", UPLOAD_PATH);
        model.addAttribute("generation_creator", GENERATION_CREATOR_PATH);
        return INDEX_FORWARD;
    }

    @GetMapping(GENERATION_CREATOR_PATH)
    public String generationCreator(Model model) {
        model.addAttribute("index", INDEX_PATH);
        return GENERATION_CREATOR_FORWARD;
    }
}
