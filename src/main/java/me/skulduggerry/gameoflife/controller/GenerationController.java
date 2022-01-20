package me.skulduggerry.gameoflife.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import me.skulduggerry.gameoflife.model.Generation;

@RestController
@Slf4j
public class GenerationController {

    @Autowired
    ObjectMapper mapper;

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {

        log.info("Uploaded " + file.getName());

        if (file.isEmpty()) {
            log.info("Uploaded file is empty");
        } else {
            log.info("Uploaded a valid file");

            Generation generation = mapper.readValue(file.getInputStream(), Generation.class);
            log.info(generation.toString());
        }

        response.sendRedirect("/");
    }
}
