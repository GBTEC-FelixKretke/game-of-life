package me.skulduggerry.gameoflife.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import me.skulduggerry.gameoflife.exception.InvalidDataException;

class GenerationTest {

    @Test
    void wrong_field_data_size() {
        Dimension dimension = new Dimension(3, 3);
        List<List<Integer>> fieldData = Arrays.asList(
        // @formatter:off
                Arrays.asList(0, 1, 0),
                Arrays.asList(0, 1, 0)
                // @formatter:on
        );

        assertThrows(InvalidDataException.class, () -> new Generation(dimension, fieldData).isWellFormattedOrThrow());
    }

    @Test
    void wrong_line_length() {
        Dimension dimension = new Dimension(3, 3);
        List<List<Integer>> fieldData = Arrays.asList(
        // @formatter:off
                Arrays.asList(0, 1, 0),
                Arrays.asList(0, 1, 0),
                Arrays.asList(0, 1, 0, 1)
                // @formatter:on
        );

        assertThrows(InvalidDataException.class, () -> new Generation(dimension, fieldData).isWellFormattedOrThrow());
    }

    @Test
    void null_line() {
        Dimension dimension = new Dimension(3, 3);
        List<List<Integer>> fieldData = Arrays.asList(
                // @formatter:off
                Arrays.asList(0, 1, 0),
                Arrays.asList(0, 1, 0),
                null
                // @formatter:on
        );

        assertThrows(InvalidDataException.class, () -> new Generation(dimension, fieldData).isWellFormattedOrThrow());
    }
}
