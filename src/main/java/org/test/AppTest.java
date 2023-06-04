package org.test;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.test.Coverage.runCoverage;
import static org.test.ReaderWriteTable.readTableFromFile;

public class AppTest {
    Coverage c = new Coverage();
    String[] paths = {"src/main/resources/Material-Aufg4/exercise1.md", "src/main/resources/Material-Aufg4/exercise2.md", "src/main/resources/Material-Aufg4/exercises/ex0.md", "src/main/resources/Material-Aufg4/exercises/ex1.md", "src/main/resources/Material-Aufg4/exercises/ex2.md"};
    List<TruthTable> tables = readTableFromFile(paths);

    public AppTest() throws IOException {
    }

    @Test
    public void exercise1_MCDC() throws IOException {
        String filepath = "/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercise1.md";
        TruthTable table = tables.get(0);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 2, 6};; //0 1 2 6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }

    @Test
    public void exercise2_MCDC() throws IOException {
        String filepath = "/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercise2.md";
        TruthTable table = tables.get(1);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {1, 4, 5, 6};; //1 4 5 6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }
@Test
    public void ex0_MCDC() throws IOException {
        String filepath = "/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercises/ex0.md";
        TruthTable table = tables.get(2);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 2, 3, 4};; //0,1,2,3,4
        Assert.assertArrayEquals(expectedTable, actualTable);
    }

@Test
    public void ex1_MCDC() throws IOException {
        String filepath = "/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercises/ex1.md";
        TruthTable table = tables.get(3);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 4, 6};; //0,1,4,6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }
@Test
    public void ex2_MCDC() throws IOException {
        String filepath = "/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercises/ex2.md";
        TruthTable table = tables.get(4);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 2, 3, 6};; //0,1,2, 3,6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }


    //TODO ex3: falsche Werte testen









}
