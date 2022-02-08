package me.skulduggerry.gameoflife.model;

import me.skulduggerry.gameoflife.exception.InvalidDataException;
import org.springframework.lang.NonNull;

import java.util.List;

public record Generation(@NonNull Dimension dimension, @NonNull List<List<Integer>> cells) {

    public void isWellFormattedOrThrow() {
        if (dimension.height() != cells.size()) {
            throw new InvalidDataException("fieldData has not the same size as dimension height");
        }

        cells.forEach(row -> {
            if (row == null || row.size() != dimension.width()) {
                throw new InvalidDataException("row is null or has not the right length");
            }

            row.forEach(integer -> {
                if (integer == null){
                    throw new InvalidDataException("integer is null");
                }
            });
        });
    }
}
