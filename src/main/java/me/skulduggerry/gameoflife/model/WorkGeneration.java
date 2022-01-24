package me.skulduggerry.gameoflife.model;

public record WorkGeneration(Dimension dimension, Cell[][] cells) {

    public record Cell(Integer x, Integer y, Boolean alive) {
    }
}
