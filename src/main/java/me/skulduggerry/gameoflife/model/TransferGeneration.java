package me.skulduggerry.gameoflife.model;

import java.util.List;

import org.springframework.lang.NonNull;

import me.skulduggerry.gameoflife.exceptions.InvalidDataException;

public record TransferGeneration(@NonNull Dimension dimension, @NonNull List<String> fieldData) {

    public TransferGeneration {
        if (dimension.height() != fieldData.size()) {
            throw new InvalidDataException("fieldData has not the same size as dimension");
        }

        fieldData.forEach(line -> {
            if (line == null || line.length() != dimension.width()) {
                throw new InvalidDataException("line is null or has not the right length.");
            }
        });
    }
}
