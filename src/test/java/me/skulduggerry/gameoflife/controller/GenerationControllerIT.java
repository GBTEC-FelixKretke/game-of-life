package me.skulduggerry.gameoflife.controller;

import static me.skulduggerry.gameoflife.controller.Binding.UPLOAD_PATH;
import static me.skulduggerry.gameoflife.controller.ModelConstants.FILE;
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
        getResult("").andExpect(status().is3xxRedirection()).andExpect(content().string("""
                {
                    "upload": "empty"
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

        getResult(content).andExpect(status().is3xxRedirection()).andExpect(content().string("""
                {
                    "upload": "success"
                }
                """));
    }

    public MockMultipartFile getFile(String content) {
        return new MockMultipartFile(FILE, content.getBytes());
    }

    public ResultActions getResult(MockMultipartFile file) throws Exception {
        return mockMvc.perform(multipart(UPLOAD_PATH).file(file));
    }

    public ResultActions getResult(String content) throws Exception {
        return mockMvc.perform(multipart(UPLOAD_PATH).file(getFile(content)));
    }

}
