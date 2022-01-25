package me.skulduggerry.gameoflife.model;

import static me.skulduggerry.gameoflife.model.WorkGeneration.Cell;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import me.skulduggerry.gameoflife.exceptions.InvalidDataException;

class WorkGenerationTest {

    @Test
    void wrong_cell_2d_array_size_should_throw_exception() {
        Dimension dimension = new Dimension(3, 3);
        Cell[][] cells = {
                // @formatter:off
                { new Cell(true), new Cell(true), new Cell(true) },
                { new Cell(true), new Cell(true), new Cell(true) }
                // @formatter:on
        };

        assertThrows(InvalidDataException.class, () -> WorkGeneration.getInstance().setNewData(dimension, cells));
    }

    @Test
    void wrong_cell_line_size_should_throw_exception() {
        Dimension dimension = new Dimension(3, 3);
        Cell[][] cells = {
                // @formatter:off
                { new Cell(true), new Cell(true), new Cell(true) },
                { new Cell(true), new Cell(true) },
                { new Cell(true), new Cell(true), new Cell(true) }
                // @formatter:on
        };

        assertThrows(InvalidDataException.class, () -> WorkGeneration.getInstance().setNewData(dimension, cells));
    }
}
