package me.skulduggerry.gameoflife.model;

import java.util.List;

import org.springframework.lang.NonNull;

import me.skulduggerry.gameoflife.exception.InvalidDataException;

public record Generation(@NonNull Dimension dimension, @NonNull List<List<Integer>> cells) {

    public Generation {
        if (dimension.height() != cells.size()) {
            throw new InvalidDataException("fieldData has not the same size as dimension height");
        }

        cells.forEach(row -> {
            if (row == null || row.size() != dimension.width()) {
                throw new InvalidDataException("row is null or has not the right length");
            }
        });
    }
}
