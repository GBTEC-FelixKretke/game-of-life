package me.skulduggerry.gameoflife.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.skulduggerry.gameoflife.model.Dimension;
import me.skulduggerry.gameoflife.model.Generation;
import me.skulduggerry.gameoflife.model.GenerationContainer;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenerationService {

    public void saveUpload(Generation generation) {
        GenerationContainer.setCurrentGeneration(generation);
    }

    public Generation getCurrentGeneration() {
        return GenerationContainer.getCurrentGeneration();
    }

    public Generation getNextGeneration() {
        Dimension dimension = GenerationContainer.getCurrentGeneration().dimension();
        List<List<Integer>> nextGenerationCells =
            getNextGenerationCells(dimension, GenerationContainer.getCurrentGeneration().cells());

        GenerationContainer.setCurrentGeneration(new Generation(dimension, nextGenerationCells));

        return GenerationContainer.getCurrentGeneration();
    }

    private List<List<Integer>> getNextGenerationCells(Dimension dimension, List<List<Integer>> currentGenerationCells) {
        List<List<Integer>> nextGenerationCells = new ArrayList<>(dimension.height());

        for (int y = 0; y < dimension.height(); y++) {
            nextGenerationCells.add(y, new ArrayList<>(dimension.width()));
            for (int x = 0; x < dimension.width(); x++) {
                int livingCellsAround = getLivingCellsAround(x, y, dimension.width(), dimension.height(), currentGenerationCells);

                if (livingCellsAround == 3) {
                    nextGenerationCells.get(y).add(x, 1);
                } else if (livingCellsAround == 2) {
                    nextGenerationCells.get(y).add(x, currentGenerationCells.get(y).get(x));
                } else {
                    nextGenerationCells.get(y).add(x, 0);
                }
            }
        }

        return nextGenerationCells;
    }

    private int getLivingCellsAround(int x, int y, int width, int height, List<List<Integer>> cells) {
        boolean isLeftEdge = x == 0;
        boolean isTopEdge = y == 0;
        boolean isRightEdge = x == width - 1;
        boolean isBottomEdge = y == height - 1;

        int livingCellsAround = 0;

        if (!isTopEdge && !isLeftEdge && cells.get(y - 1).get(x - 1) == 1) {
            livingCellsAround++;
        }
        if (!isTopEdge && cells.get(y - 1).get(x) == 1) {
            livingCellsAround++;
        }
        if (!isTopEdge && !isRightEdge && cells.get(y - 1).get(x + 1) == 1) {
            livingCellsAround++;
        }
        if (!isLeftEdge && cells.get(y).get(x - 1) == 1) {
            livingCellsAround++;
        }
        if (!isRightEdge && cells.get(y).get(x + 1) == 1) {
            livingCellsAround++;
        }
        if (!isBottomEdge && !isLeftEdge && cells.get(y + 1).get(x - 1) == 1) {
            livingCellsAround++;
        }
        if (!isBottomEdge && cells.get(y + 1).get(x) == 1) {
            livingCellsAround++;
        }
        if (!isBottomEdge && !isRightEdge && cells.get(y + 1).get(x + 1) == 1) {
            livingCellsAround++;
        }

        return livingCellsAround;
    }
}
