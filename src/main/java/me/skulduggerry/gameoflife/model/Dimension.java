package me.skulduggerry.gameoflife.model;

import org.springframework.lang.NonNull;

public record Dimension(@NonNull Integer width, @NonNull Integer height) {
}
