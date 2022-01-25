package me.skulduggerry.gameoflife.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import me.skulduggerry.gameoflife.model.Dimension;
import me.skulduggerry.gameoflife.model.TransferGeneration;
import me.skulduggerry.gameoflife.model.WorkGeneration;

@Component
public class GenerationConverter {

    public WorkGeneration toWorkGeneration(TransferGeneration transferGeneration) {
        WorkGeneration.Cell[][] cells = transferGeneration.fieldData()
                                                          .stream()
                                                          .map(line -> Arrays.stream(line.split(""))
                                                                             .map(cell -> cell.equals("x"))
                                                                             .map(WorkGeneration.Cell::new)
                                                                             .toArray(WorkGeneration.Cell[]::new))
                                                          .toArray(WorkGeneration.Cell[][]::new);

        WorkGeneration.getInstance().setCells(cells);
        return WorkGeneration.getInstance();
    }

    public TransferGeneration toTransferGeneration(WorkGeneration workGeneration) {
        Dimension dimension = workGeneration.getDimension();
        List<String> fieldData =
            Arrays.stream(workGeneration.getCells())
                  .map(cells -> Arrays.stream(cells).map(cell -> cell.alive() ? "x" : "o").collect(Collectors.joining()))
                  .toList();

        return new TransferGeneration(dimension, fieldData);
    }
}
