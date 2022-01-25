package me.skulduggerry.gameoflife.converter;

import static me.skulduggerry.gameoflife.model.WorkGeneration.Cell;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import me.skulduggerry.gameoflife.model.Dimension;
import me.skulduggerry.gameoflife.model.TransferGeneration;
import me.skulduggerry.gameoflife.model.WorkGeneration;

class GenerationConverterTest {

    private final GenerationConverter generationConverter = new GenerationConverter();

    @Test
    void convert_transfer_generation_to_work_generation() {
        Dimension dimension = new Dimension(5, 1);
        List<String> cells = List.of("xoxox");
        TransferGeneration transferGeneration = new TransferGeneration(dimension, cells);
        WorkGeneration workGeneration = generationConverter.toWorkGeneration(transferGeneration);

        assertEquals(workGeneration.getDimension(), dimension);

        Cell[] cellFirstLine = workGeneration.getCells()[0];
        assertTrue(cellFirstLine[0].alive());
        assertFalse(cellFirstLine[1].alive());
        assertTrue(cellFirstLine[2].alive());
        assertFalse(cellFirstLine[3].alive());
        assertTrue(cellFirstLine[4].alive());
    }

    @Test
    void convert_work_generation_to_transfer_generation() {
        Dimension dimension = new Dimension(3, 1);
        Cell[][] cells = new Cell[][] { { new Cell(true), new Cell(false), new Cell(true) } };
        WorkGeneration.getInstance().setNewData(dimension, cells);
        TransferGeneration transferGeneration = generationConverter.toTransferGeneration(WorkGeneration.getInstance());

        assertEquals(dimension, transferGeneration.dimension());

        String cellsFirstLine = transferGeneration.fieldData().get(0);
        assertEquals('x', cellsFirstLine.charAt(0));
        assertEquals('o', cellsFirstLine.charAt(1));
        assertEquals('x', cellsFirstLine.charAt(2));
    }
}
