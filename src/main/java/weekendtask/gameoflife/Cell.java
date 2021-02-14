package weekendtask.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell {

    private final int xCoordinate;
    private final int yCoordinate;


    public Cell(int xCoordinate, int yCoordinate) {

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public List<Cell> getNeighbours() {
        int xCoordinate = this.xCoordinate;
        int yCoordinate = this.yCoordinate;
        List<Cell> neighbours = new ArrayList<>();
        for (int row = xCoordinate - 1; row <= xCoordinate + 1; row++) {
            for (int col = yCoordinate - 1; col <= yCoordinate + 1; col++) {
                if (row != xCoordinate || col != yCoordinate)
                    neighbours.add(new Cell(row, col));
            }

        }
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return xCoordinate == cell.xCoordinate && yCoordinate == cell.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
