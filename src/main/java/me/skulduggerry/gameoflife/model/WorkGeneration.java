package me.skulduggerry.gameoflife.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.Arrays;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.skulduggerry.gameoflife.exceptions.InvalidDataException;

@Getter
@AllArgsConstructor(access = PRIVATE)
public class WorkGeneration {

    private Dimension dimension;
    private Cell[][] cells;

    private static WorkGeneration INSTANCE;

    public static WorkGeneration getInstance() {
        return INSTANCE != null ? INSTANCE : (INSTANCE = new WorkGeneration(new Dimension(0, 0), new Cell[0][0]));
    }

    public record Cell(@NonNull Boolean alive) {
    }

    private void isValid(Integer width, Integer height, Cell[][] cells) {
        if (height != cells.length) {
            throw new InvalidDataException("cell[][] has not the same size as dimension");
        }

        Arrays.stream(cells).forEach(line -> {
            if (line == null || line.length != width) {
                throw new InvalidDataException("line is null or has not the right length.");
            }
        });
    }

    public void setNewData(Dimension newDimension, Cell[][] newCells) {
        isValid(newDimension.width(), newDimension.height(), newCells);
        this.dimension = newDimension;
        this.cells = newCells;
    }
}
