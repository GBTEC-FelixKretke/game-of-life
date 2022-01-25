package me.skulduggerry.gameoflife.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.skulduggerry.gameoflife.model.Dimension;
import me.skulduggerry.gameoflife.model.WorkGeneration;

@Service
@RequiredArgsConstructor
public class GenerationService {

    private final WorkGeneration currentGeneration = WorkGeneration.getInstance();

    public WorkGeneration getNextGeneration() {
        Dimension dimension = currentGeneration.getDimension();
        WorkGeneration.Cell[][] nextGenerationCells = getNextGenerationCells(dimension, currentGeneration.getCells());

        currentGeneration.setCells(nextGenerationCells);

        return currentGeneration;
    }

    private WorkGeneration.Cell[][] getNextGenerationCells(Dimension dimension, WorkGeneration.Cell[][] currentGenerationCells) {
        WorkGeneration.Cell[][] nextGenerationCells = new WorkGeneration.Cell[dimension.height()][dimension.width()];

        for (int y = 0; y < dimension.height(); y++)
            for (int x = 0; x < dimension.width(); x++) {
                int livingCellsAround =
                    getLivingCellsAround(x, y, dimension.width(), dimension.height(), currentGeneration.getCells());

                if (livingCellsAround == 3) {
                    nextGenerationCells[y][x] = new WorkGeneration.Cell(true);
                } else if (livingCellsAround == 2) {
                    nextGenerationCells[y][x] = new WorkGeneration.Cell(currentGenerationCells[y][x].alive());
                } else {
                    nextGenerationCells[y][x] = new WorkGeneration.Cell(false);
                }
            }

        return nextGenerationCells;
    }

    private int getLivingCellsAround(int x, int y, int width, int height, WorkGeneration.Cell[][] cells) {
        boolean isLeftEdge = x == 0;
        boolean isTopEdge = y == 0;
        boolean isRightEdge = x == width - 1;
        boolean isBottomEdge = y == height - 1;

        int livingCellsAround = 0;

        if (!isTopEdge && !isLeftEdge && cells[y - 1][x - 1].alive()) {
            livingCellsAround++;
        }
        if (!isTopEdge && cells[y - 1][x].alive()) {
            livingCellsAround++;
        }
        if (!isTopEdge && !isRightEdge && cells[y - 1][x + 1].alive()) {
            livingCellsAround++;
        }
        if (!isLeftEdge && cells[y][x - 1].alive()) {
            livingCellsAround++;
        }
        if (!isRightEdge && cells[y][x + 1].alive()) {
            livingCellsAround++;
        }
        if (!isBottomEdge && !isLeftEdge && cells[y + 1][x - 1].alive()) {
            livingCellsAround++;
        }
        if (!isBottomEdge && cells[y + 1][x].alive())
            livingCellsAround++;
        if (!isBottomEdge && !isRightEdge && cells[y + 1][x + 1].alive()) {
            livingCellsAround++;
        }

        return livingCellsAround;
    }
}