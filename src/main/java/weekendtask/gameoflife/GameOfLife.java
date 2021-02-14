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

        List<Cell> aliveCells = new ArrayList<>(inputCells);
        List<Cell> neighbouringCells;

        for (Cell active : inputCells) {
            neighbouringCells = active.getNeighbours();

            int activeNeighbours = neighbouringCells.stream()
                    .distinct()
                    .filter(inputCells::contains)
                    .collect(Collectors.toSet()).size();

            if (activeNeighbours < 2 || activeNeighbours > 3)
                aliveCells.remove(active);

            for (Cell neighbourCell : neighbouringCells) {
                List<Cell> neighbouringCellsList = neighbourCell.getNeighbours();

                int result = neighbouringCellsList.stream().distinct().filter(inputCells::contains).collect(Collectors.toSet()).size();

                if (result == 3 && !aliveCells.contains(neighbourCell))

                    aliveCells.add(neighbourCell);

            }
        }

        return aliveCells;
    }

}
