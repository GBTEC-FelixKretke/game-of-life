package me.skulduggerry.gameoflife.model;

import java.util.List;

import lombok.Data;

@Data
public class Generation {

    private Dimension dimension;
    private List<String> fieldData;
}
