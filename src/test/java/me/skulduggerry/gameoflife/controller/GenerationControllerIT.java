package me.skulduggerry.gameoflife.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(GenerationController.class)
class GenerationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void upload_empty_file_should_work() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "".getBytes());
        ResultActions result = mockMvc.perform(multipart("/upload").file(file));
        result.andExpect(status().is3xxRedirection()).andExpect(content().string("""
                {
                    "upload": "failed"
                }
                """));
    }

    @Test
    void upload_valid_generation_should_work() throws Exception {
        String content = """
                {
                    "dimension": {
                        "width": 5,
                        "height": 5
                    },
                    "fieldData": [
                        "xoxox",
                        "xoxox",
                        "xoxox",
                        "xoxox",
                        "xoxox"
                    ]
                }
                """;

        MockMultipartFile file = new MockMultipartFile("file", content.getBytes());
        ResultActions result = mockMvc.perform(multipart("/upload").file(file));
        result.andExpect(status().is3xxRedirection()).andExpect(content().string("""
                {
                    "upload": "success"
                }
                """));
    }
}
