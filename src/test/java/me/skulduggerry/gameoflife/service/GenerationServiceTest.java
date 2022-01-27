package me.skulduggerry.gameoflife.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lombok.RequiredArgsConstructor;
import me.skulduggerry.gameoflife.model.Dimension;
import me.skulduggerry.gameoflife.model.Generation;

@RequiredArgsConstructor
class GenerationServiceTest {

    private final GenerationService generationService;

    @Test
    void save_upload() {
        Generation upload = new Generation(new Dimension(3, 3),
            Arrays.asList(Arrays.asList(0, 0, 0), Arrays.asList(1, 1, 1), Arrays.asList(0, 0, 0)));

        generationService.saveUpload(upload);

        assertSame(upload, generationService.getCurrentGeneration());
    }

    @Test
    void next_generation() {
        generationService.saveUpload(new Generation(new Dimension(3, 3),
            Arrays.asList(Arrays.asList(0, 1, 0), Arrays.asList(0, 1, 0), Arrays.asList(0, 1, 0))));

        Generation expected = new Generation(new Dimension(3, 3),
            Arrays.asList(Arrays.asList(0, 0, 0), Arrays.asList(1, 1, 1), Arrays.asList(0, 0, 0)));

        assertEquals(expected, generationService.getCurrentGeneration());
    }
}
