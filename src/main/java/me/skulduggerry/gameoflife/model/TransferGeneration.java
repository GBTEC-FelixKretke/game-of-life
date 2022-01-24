package me.skulduggerry.gameoflife.model;

import java.util.List;

public record TransferGeneration(Dimension dimension, List<String> fieldData) {
}
