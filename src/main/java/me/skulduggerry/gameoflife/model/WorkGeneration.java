package me.skulduggerry.gameoflife.model;

import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = PRIVATE)
public class WorkGeneration {

    private Dimension dimension;
    private Cell[][] cells;

    private static WorkGeneration INSTANCE;

    public static WorkGeneration getInstance() {
        return INSTANCE != null ? INSTANCE : (INSTANCE = new WorkGeneration(null, null));
    }

    public record Cell(Boolean alive) {
    }
}
