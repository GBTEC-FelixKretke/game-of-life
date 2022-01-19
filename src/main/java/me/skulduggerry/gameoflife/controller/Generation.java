package me.skulduggerry.gameoflife.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Generation {

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        log.info("Uploaded " + file.getName());
        response.sendRedirect("/");
    }
}
