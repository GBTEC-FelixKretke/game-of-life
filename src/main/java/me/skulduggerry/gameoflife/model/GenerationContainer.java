package me.skulduggerry.gameoflife.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.ArrayList;

import org.springframework.lang.NonNull;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class GenerationContainer {

    private static Generation currentGeneration;

    public static Generation getCurrentGeneration() {
        return currentGeneration != null ? currentGeneration
            : (currentGeneration = new Generation(new Dimension(0, 0), new ArrayList<>()));
    }

    public static void setCurrentGeneration(@NonNull Generation newCurrentGeneration) {
        currentGeneration = newCurrentGeneration;
    }
}
