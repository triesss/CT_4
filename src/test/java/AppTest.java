import coverage.Coverage;
import coverage.TruthTable;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static coverage.Coverage.runCoverage;
import static coverage.ReaderWriteTable.readTableFromFile;

public class AppTest {
    String[] paths = {"resources/Material-Aufg4/exercise1.md", "resources/Material-Aufg4/exercise2.md", "resources/Material-Aufg4/exercises/ex0.md", "resources/Material-Aufg4/exercises/ex1.md", "resources/Material-Aufg4/exercises/ex2.md" };
    String[] negativePaths = {"resources/Material-Aufg4/exercises/ex3.md","resources/Material-Aufg4/exercises/ex8.md"};
    List<TruthTable> tables = readTableFromFile(paths);

    public AppTest() throws IOException {
    }

    @Test
    public void readTableFromFileSuccess() {
        TruthTable table = tables.get(0);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 2, 6};; //0 1 2 6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }

    @Test
    public void readTableFromFileFailIllegalCharacter() {


           Assert.assertThrows(IllegalArgumentException.class, () -> {
               List<TruthTable> tableList= readTableFromFile(negativePaths);
               TruthTable table = tableList.get(0);
           });


    }

    @Test
    public void readTableFromFileFailWrongNumberOfArguments() {


        Assert.assertThrows(IllegalArgumentException.class, () -> {
            List<TruthTable> tableList= readTableFromFile(negativePaths);
            TruthTable table = tableList.get(1);
        });

    }


    @Test
    public void exercise1_MCDC() {
        TruthTable table = tables.get(0);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 2, 6};; //0 1 2 6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }


    @Test
    public void exercise1_MMBUE() {
        TruthTable table = tables.get(0);
        int[] actualTable = runCoverage("MMBUE", table);
        int[] expectedTable = {0, 1, 2, 4,5,6,7};; //0 1 2 6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }


    @Test
    public void exercise2_MCDC() {
        TruthTable table = tables.get(1);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {1, 4, 5, 6};; //1 4 5 6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }

    @Test
    public void exercise2_MMBUE() {
        TruthTable table = tables.get(1);
        int[] actualTable = runCoverage("MMBUE", table);
        int[] expectedTable = {1, 2, 4,5, 6,7};; //1 4 5 6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }
@Test
    public void ex0_MCDC() {
        TruthTable table = tables.get(2);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 2, 3, 4};; //0,1,2,3,4
        Assert.assertArrayEquals(expectedTable, actualTable);
    }

    @Test
    public void ex0_MMBÜ() {
        TruthTable table = tables.get(2);
        int[] actualTable = runCoverage("MMBUE", table);
        int[] expectedTable = {0, 1, 2, 3,4,5,6,7};; //0 1 2 6
        System.out.println(Arrays.toString(actualTable));
        Assert.assertArrayEquals(expectedTable, actualTable);
    }
@Test
    public void ex1_MCDC() {
        TruthTable table = tables.get(3);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 4, 6};; //0,1,4,6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }

    @Test
    public void ex1_MMBUE() {
        TruthTable table = tables.get(3);
        int[] actualTable = runCoverage("MMBUE", table);
        int[] expectedTable = {0, 1, 2,3,4,5, 6,7};; //0,1,4,6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }
@Test
    public void ex2_MCDC() {
        TruthTable table = tables.get(4);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 2, 3, 6};; //0,1,2, 3,6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }


    @Test
    public void ex2_MMBUE() {
        TruthTable table = tables.get(4);
        int[] actualTable = runCoverage("MMBUE", table);
        int[] expectedTable = {0, 1, 2, 3, 4,5, 6,7};; //0,1,2, 3,6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }











}
