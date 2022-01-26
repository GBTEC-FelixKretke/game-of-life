package me.skulduggerry.gameoflife.controller;

import static me.skulduggerry.gameoflife.controller.Binding.NEXT_GENERATION_PATH;
import static me.skulduggerry.gameoflife.controller.Binding.UPLOAD_PATH;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.skulduggerry.gameoflife.converter.GenerationConverter;
import me.skulduggerry.gameoflife.model.TransferGeneration;
import me.skulduggerry.gameoflife.model.WorkGeneration;
import me.skulduggerry.gameoflife.service.GenerationService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GenerationController {

    @NonNull
    private final ObjectMapper mapper;
    @NonNull
    private final GenerationService generationService;
    @NonNull
    private final GenerationConverter generationConverter;

    @PostMapping(value = UPLOAD_PATH, consumes = "application/json", produces = "application/json")
    public String upload(@RequestBody TransferGeneration transferGeneration) {
        log.debug("Uploaded a valid file");
        log.debug("Send json:\n" + transferGeneration.toString());
        generationConverter.toWorkGeneration(transferGeneration);

        return """
                {
                    "upload": "success"
                }
                """;
    }

    @GetMapping(NEXT_GENERATION_PATH)
    public TransferGeneration getNextGeneration() {
        log.debug("Request for next generation.");
        WorkGeneration currentGeneration = generationService.getNextGeneration();
        TransferGeneration transferGeneration = generationConverter.toTransferGeneration(currentGeneration);
        log.debug("Send json:\n" + transferGeneration.toString());
        return transferGeneration;
    }

    @GetMapping()
    public TransferGeneration getCurrentGeneration() {
        log.debug("Request for current generation.");
        TransferGeneration trsTransferGeneration = generationConverter.toTransferGeneration(WorkGeneration.getInstance());
        log.debug("Send json:\n" + trsTransferGeneration.toString());
        return trsTransferGeneration;
    }
}
