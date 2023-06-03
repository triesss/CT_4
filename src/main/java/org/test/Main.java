package org.test;

import java.io.IOException;

import static org.test.Coverage.runCoverage;
import static org.test.ReaderWriteTable.readTableFromFile;

public class Main {
    public static void main(String[] args) throws IOException {
        TruthTable table = readTableFromFile("/Users/marmar/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercises/ex2.md");
        System.out.println(table);
        int[] resultRows = runCoverage("MCDC", table);
        System.out.println("Rows to test: ");
        for (int i = 0; i < resultRows.length; i++) {
            System.out.println(resultRows[i]);
        }

    }

    // console application
}
