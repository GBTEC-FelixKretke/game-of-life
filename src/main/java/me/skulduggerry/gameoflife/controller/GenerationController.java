package me.skulduggerry.gameoflife.controller;

import static me.skulduggerry.gameoflife.controller.Binding.UPLOAD_PATH;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.skulduggerry.gameoflife.exceptions.RedirectionFailedException;
import me.skulduggerry.gameoflife.model.TransferGeneration;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GenerationController {

    @NonNull
    private final ObjectMapper mapper;

    @PostMapping(UPLOAD_PATH)
    public String upload(@RequestPart("file") MultipartFile file, HttpServletResponse response) throws IOException {
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new RedirectionFailedException(e);
        }

        if (file.isEmpty()) {
            log.info("Uploaded file is empty");
            return """
                    {
                        "upload": "empty"
                    }
                    """;
        } else {
            log.info("Uploaded a valid file");

            TransferGeneration transferGeneration = mapper.readValue(file.getInputStream(), TransferGeneration.class);
            log.info(transferGeneration.toString());
            return """
                    {
                        "upload": "success"
                    }
                    """;
        }
    }
}
