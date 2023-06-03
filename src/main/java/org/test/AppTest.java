package org.test;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.test.Coverage.runCoverage;
import static org.test.ReaderWriteTable.readTableFromFile;

public class AppTest {
    Coverage c = new Coverage();


    @Test
    public void exercise1_MCDC() throws IOException {
        String filepath = "/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercise1.md";
        TruthTable table = readTableFromFile(filepath);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 2, 6};; //0 1 2 6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }

    @Test
    public void exercise2_MCDC() throws IOException {
        String filepath = "/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercise2.md";
        TruthTable table = readTableFromFile(filepath);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {1, 4, 5, 6};; //1 4 5 6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }
@Test
    public void ex0_MCDC() throws IOException {
        String filepath = "/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercises/ex0.md";
        TruthTable table = readTableFromFile(filepath);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 2, 3, 4};; //0,1,2,3,4
        Assert.assertArrayEquals(expectedTable, actualTable);
    }

@Test
    public void ex1_MCDC() throws IOException {
        String filepath = "/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercises/ex1.md";
        TruthTable table = readTableFromFile(filepath);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 4, 6};; //0,1,4,6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }
@Test
    public void ex2_MCDC() throws IOException {
        String filepath = "/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercises/ex2.md";
        TruthTable table = readTableFromFile(filepath);
        int[] actualTable = runCoverage("MCDC", table);
        int[] expectedTable = {0, 1, 2, 3, 6};; //0,1,2, 3,6
        Assert.assertArrayEquals(expectedTable, actualTable);
    }


    //TODO ex3: falsche Werte testen









}
