package me.skulduggerry.gameoflife.controller;

import static me.skulduggerry.gameoflife.controller.Binding.UPLOAD_PATH;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import me.skulduggerry.gameoflife.service.GenerationService;

@WebMvcTest(GenerationController.class)
class GenerationControllerIT {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GenerationService generationService;

    @Test
    void upload_valid_generation_should_work() throws Exception {
        String content = """
                {
                    "dimension": {
                        "width": 5,
                        "height": 5
                    },
                    "cells": [
                        [1, 0, 1, 0, 1],
                        [1, 0, 1, 0, 1],
                        [1, 0, 1, 0, 1],
                        [1, 0, 1, 0, 1],
                        [1, 0, 1, 0, 1]
                    ]
                }
                """;

        getResult(content).andExpect(content().string("""
                {
                    "upload": "success"
                }
                """));
    }

    private ResultActions getResult(String content) throws Exception {
        return mockMvc.perform(post(UPLOAD_PATH).contentType("application/json").content(content));
    }

}
