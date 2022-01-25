package me.skulduggerry.gameoflife.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import me.skulduggerry.gameoflife.exceptions.InvalidDataException;

class TransferGenerationTest {

    @Test
    void wrong_field_data_size() {
        Dimension dimension = new Dimension(3, 3);
        List<String> fieldData = Arrays.asList("xox", "xxo");

        assertThrows(InvalidDataException.class, () -> new TransferGeneration(dimension, fieldData));
    }

    @Test
    void wrong_line_length() {
        Dimension dimension = new Dimension(3, 3);
        List<String> fieldData = Arrays.asList("xox", "oxo", "xoxo");

        assertThrows(InvalidDataException.class, () -> new TransferGeneration(dimension, fieldData));
    }

    @Test
    void null_line() {
        Dimension dimension = new Dimension(3, 3);
        List<String> fieldData = Arrays.asList("xox", "oxo", null);

        assertThrows(InvalidDataException.class, () -> new TransferGeneration(dimension, fieldData));
    }
}
