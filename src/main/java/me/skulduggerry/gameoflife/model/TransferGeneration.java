package me.skulduggerry.gameoflife.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransferGeneration {

    @JsonProperty("dimension")
    private TransferDimension transferDimension;
    private List<String> fieldData;
}
