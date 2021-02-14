package weekendtask.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameOfLife {

    private final List<Cell> inputCells;

    public GameOfLife(List<Cell> inputCells) {
        this.inputCells = inputCells;
    }

    public List<Cell> nextGeneration() {

        List<Cell> aliveCells = new ArrayList<>(inputCells);

        nextTick(aliveCells);

        return aliveCells;
    }

    private void nextTick(List<Cell> aliveCells) {

        for (Cell active : inputCells) {

            List<Cell> activeCells = removeDeadCells(aliveCells, active);

            addAliveCells(aliveCells, activeCells);
        }
    }

    private List<Cell> removeDeadCells(List<Cell> aliveCells, Cell active) {
        List<Cell> neighbouringCells = active.getNeighbours();

        int activeNeighbours = neighbouringCells.stream()
                .distinct()
                .filter(inputCells::contains)
                .collect(Collectors.toSet()).size();

        if (activeNeighbours < 2 || activeNeighbours > 3)
            aliveCells.remove(active);
        return neighbouringCells;
    }

    private void addAliveCells(List<Cell> aliveCells, List<Cell> neighbouringCells) {
        for (Cell neighbour : neighbouringCells) {
            List<Cell> neighbouringCellsList = neighbour.getNeighbours();

            int result = neighbouringCellsList.stream()
                    .distinct()
                    .filter(inputCells::contains)
                    .collect(Collectors.toSet()).size();

            if (result == 3 && !aliveCells.contains(neighbour))
                aliveCells.add(neighbour);

        }
    }

}
