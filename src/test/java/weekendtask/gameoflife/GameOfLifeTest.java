package weekendtask.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameOfLifeTest {

    @Test
    void shouldTestBlockPattern() {
        List<Cell> inputLiveCells=new ArrayList<>();
        inputLiveCells.add(new Cell(1, 1));
        inputLiveCells.add( new Cell(1, 2));
        inputLiveCells.add(new Cell(2, 1));
        inputLiveCells.add(new Cell(2, 2));

        GameOfLife gameOfLife = new GameOfLife(inputLiveCells);
        List<Cell> result=gameOfLife.nextGeneration();

        List<Cell> expectedResult=new ArrayList<>();
        expectedResult.add(new Cell(1, 1));
        expectedResult.add(new Cell(1, 2));
        expectedResult.add(new Cell(2, 1));
        expectedResult.add(new Cell(2, 2));

        assertTrue(expectedResult.containsAll(result) && result.containsAll(expectedResult));
    }

    @Test
    void shouldTestBlinkerPattern() {
        List<Cell> inputList=new ArrayList<>();
        inputList.add(new Cell(1, 1));
        inputList.add( new Cell(1, 0));
        inputList.add(new Cell(1, 2));


        GameOfLife gameOfLife = new GameOfLife(inputList);
        List<Cell> result=gameOfLife.nextGeneration();

        List<Cell> expectedResult=new ArrayList<>();
        expectedResult.add(new Cell(1, 1));
        expectedResult.add(new Cell(0, 1));
        expectedResult.add(new Cell(2, 1));

        assertTrue(expectedResult.containsAll(result) && result.containsAll(expectedResult));
    }

    @Test
    void shouldTestBoatPattern() {
        List<Cell> inputLiveCells=new ArrayList<>();
        inputLiveCells.add(new Cell(0, 1));
        inputLiveCells.add( new Cell(1, 0));
        inputLiveCells.add(new Cell(2, 1));
        inputLiveCells.add(new Cell(0, 2));
        inputLiveCells.add(new Cell(1, 2));

        GameOfLife gameOfLife = new GameOfLife(inputLiveCells);
        List<Cell> result=gameOfLife.nextGeneration();

        List<Cell> expectedResult=new ArrayList<>();
        expectedResult.add(new Cell(0, 1));
        expectedResult.add(new Cell(1, 0));
        expectedResult.add(new Cell(2, 1));
        expectedResult.add(new Cell(0, 2));
        expectedResult.add(new Cell(1, 2));

        assertTrue(expectedResult.containsAll(result) && result.containsAll(expectedResult));
    }
    @Test
    void shouldTestToadPattern() {
        List<Cell> inputLiveCells=new ArrayList<>();
        inputLiveCells.add(new Cell(1, 1));
        inputLiveCells.add( new Cell(1, 2));
        inputLiveCells.add(new Cell(1, 3));
        inputLiveCells.add(new Cell(2, 2));
        inputLiveCells.add(new Cell(2, 3));
        inputLiveCells.add(new Cell(2, 4));


        GameOfLife gameOfLife = new GameOfLife(inputLiveCells);
        List<Cell> result=gameOfLife.nextGeneration();

        List<Cell> expectedResult=new ArrayList<>();
        expectedResult.add(new Cell(0, 2));
        expectedResult.add(new Cell(1, 1));
        expectedResult.add(new Cell(1, 4));
        expectedResult.add(new Cell(2, 1));
        expectedResult.add(new Cell(2, 4));
        expectedResult.add(new Cell(3, 3));

        assertTrue(expectedResult.containsAll(result) && result.containsAll(expectedResult));

    }
}
