package me.skulduggerry.gameoflife.controller;

import static me.skulduggerry.gameoflife.controller.Binding.NEXT_GENERATION_PATH;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class NextGenController {

    @GetMapping(NEXT_GENERATION_PATH)
    public String getNextGeneration() {
        log.info("Request for next generation.");
        return "Test";
    }
}
