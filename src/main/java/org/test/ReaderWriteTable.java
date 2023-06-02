package org.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReaderWriteTable {
    // read a table from a file
    // in the format to 2d array of booleans
    // | M0 | M1 | M2 | Z  |
    //| --- | --- | --- | --- |
    //|  0 |  0 |  0 |  1 |
    //|  1 |  0 |  0 |  1 |
    //|  0 |  1 |  0 |  1 |
    //|  1 |  1 |  0 |  0 |
    //|  0 |  0 |  1 |  0 |
    //|  1 |  0 |  1 |  1 |
    //|  0 |  1 |  1 |  0 |
    //|  1 |  1 |  1 |  0 |


    // TODO handle faulty tables
    public static TruthTable readTableFromFile(String paths) throws IOException {
        List<List<Boolean>> table = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(paths));
        reader.lines().skip(2).forEach(line -> {
            String[] splits = line.split("\\|");
            List<Boolean> row = new ArrayList<>();
            for (int i = 1; i < splits.length; i++) {
                row.add(Objects.equals(splits[i].trim(), "1"));
            }
            table.add(row);
        });
        // convert List to 2d array
        boolean[][] tableArray = getBooleans(table);
        return new TruthTable(tableArray);
    }

    // write a table to a file
    public static void writeTableToFile(TruthTable table, String path){
        // TODO
    }

    private static boolean[][] getBooleans(List<List<Boolean>> table) {
        boolean[][] tableArray = new boolean[table.size()][];
        for (int i = 0; i < table.size(); i++) {
            tableArray[i] = new boolean[table.get(i).size()];
            for (int j = 0; j < table.get(i).size(); j++) {
                tableArray[i][j] = table.get(i).get(j);
            }
        }
        return tableArray;
    }

    public static void main(String[] args) throws IOException {
        TruthTable table = readTableFromFile("/Users/leonbeitz/IdeaProjects/CT_4/src/main/resources/Material-Aufg4/exercise1.md");

        System.out.println(Arrays.deepToString(table.table));
    }
}
