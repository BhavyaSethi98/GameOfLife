package weekendtask.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameOfLife {

    private final List<Cell> inputCells;

    public GameOfLife(List<Cell> inputCells) {
        this.inputCells = inputCells;
    }

    public List<Cell> nextGeneration() {

        List<Cell> aliveCellsAfterRun = new ArrayList<>(inputCells);

        for (Cell activeCell : inputCells) {

            List<Cell> aliveCellsAfterRemovingDeadCells = removeDeadCells(aliveCellsAfterRun, activeCell);

            aliveCellsAfterRun = addAliveCells(aliveCellsAfterRun, aliveCellsAfterRemovingDeadCells);
        }

        return aliveCellsAfterRun;
    }

    private List<Cell> removeDeadCells(List<Cell> aliveCellsAfterRun, Cell activeCell) {
        List<Cell> neighbouringCells = activeCell.getNeighbours();

        int activeNeighbours = neighbouringCells.stream()
                .distinct()
                .filter(inputCells::contains)
                .collect(Collectors.toSet()).size();

        if (activeNeighbours < 2 || activeNeighbours > 3)
            aliveCellsAfterRun.remove(activeCell);

        return neighbouringCells;
    }

    private List<Cell> addAliveCells(List<Cell> aliveCellsAfterRun, List<Cell> neighbouringCells) {

        for (Cell neighbour : neighbouringCells) {
            List<Cell> neighbouringCellsList = neighbour.getNeighbours();

            int aliveNeighbours = neighbouringCellsList.stream()
                    .distinct()
                    .filter(inputCells::contains)
                    .collect(Collectors.toSet()).size();

            if (aliveNeighbours == 3 && !aliveCellsAfterRun.contains(neighbour))
                aliveCellsAfterRun.add(neighbour);

        }
        return aliveCellsAfterRun;
    }

}
