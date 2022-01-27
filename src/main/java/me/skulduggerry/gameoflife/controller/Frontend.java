package me.skulduggerry.gameoflife.controller;

import static me.skulduggerry.gameoflife.controller.Binding.CURRENT_GENERATION_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.INDEX_FORWARD;
import static me.skulduggerry.gameoflife.controller.Binding.NEXT_GENERATION_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.ROOT;
import static me.skulduggerry.gameoflife.controller.Binding.UPLOAD_PATH;
import static me.skulduggerry.gameoflife.controller.ModelConstants.FILE_ID;
import static me.skulduggerry.gameoflife.controller.ModelConstants.NEXT_GEN_BUTTON;
import static me.skulduggerry.gameoflife.controller.ModelConstants.NEXT_GEN_BUTTON_ID;
import static me.skulduggerry.gameoflife.controller.ModelConstants.NEXT_GEN_TITLE;
import static me.skulduggerry.gameoflife.controller.ModelConstants.TABLE_DIV_ID;
import static me.skulduggerry.gameoflife.controller.ModelConstants.TABLE_ID;
import static me.skulduggerry.gameoflife.controller.ModelConstants.UPLOAD_BUTTON;
import static me.skulduggerry.gameoflife.controller.ModelConstants.UPLOAD_BUTTON_ID;
import static me.skulduggerry.gameoflife.controller.ModelConstants.UPLOAD_INVALID;
import static me.skulduggerry.gameoflife.controller.ModelConstants.UPLOAD_MESSAGE;
import static me.skulduggerry.gameoflife.controller.ModelConstants.UPLOAD_TITLE;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Frontend {

    @GetMapping(ROOT)
    public String gameOfLife(Model model) {
        model.addAttribute("file_id", FILE_ID);
        model.addAttribute("table_div_id", TABLE_DIV_ID);
        model.addAttribute("table_id", TABLE_ID);
        model.addAttribute("upload_button_id", UPLOAD_BUTTON_ID);
        model.addAttribute("next_gen_button_id", NEXT_GEN_BUTTON_ID);

        model.addAttribute("upload_title", UPLOAD_TITLE);
        model.addAttribute("upload_message", UPLOAD_MESSAGE);
        model.addAttribute("upload_invalid", UPLOAD_INVALID);
        model.addAttribute("upload_button", UPLOAD_BUTTON);

        model.addAttribute("next_gen_title", NEXT_GEN_TITLE);
        model.addAttribute("next_gen_button", NEXT_GEN_BUTTON);

        model.addAttribute("current_gen_endpoint", CURRENT_GENERATION_PATH);
        model.addAttribute("next_gen_endpoint", NEXT_GENERATION_PATH);
        model.addAttribute("upload_endpoint", UPLOAD_PATH);
        return INDEX_FORWARD;
    }
}
