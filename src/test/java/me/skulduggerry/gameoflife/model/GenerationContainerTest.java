package me.skulduggerry.gameoflife.model;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;

class GenerationContainerTest {

    @Test
    void save_generation() {
        Generation newGeneration = new Generation(new Dimension(1, 1), List.of(List.of(1)));

        GenerationContainer.setCurrentGeneration(newGeneration);
        assertSame(newGeneration, GenerationContainer.getCurrentGeneration());
    }
}
