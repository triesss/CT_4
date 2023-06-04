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


    public static List<TruthTable> readTableFromFile(String[] paths) throws IOException {
        List<TruthTable> tables = new ArrayList<>();
        Arrays.stream(paths).forEach(p -> {
            List<List<Boolean>> table = new ArrayList<>();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(p));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String[] columnLabels = new String[0];
            try {
                columnLabels = reader.readLine().split("\\|");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            reader.lines().skip(1).forEach(line -> {
                String[] splits = line.split("\\|");
                if (splits.length != 5){
                    throw new IllegalArgumentException("Die Datei ist fehlerhaft");
                }else {
                    List<Boolean> row = new ArrayList<>();
                    for (int i = 1; i < splits.length; i++) {
                        row.add(Objects.equals(splits[i].trim(), "1"));
                    }
                    table.add(row);
                }
            });
            // convert List to 2d array
            boolean[][] tableArray = getBooleans(table);
            tables.add(new TruthTable(tableArray, columnLabels));
        });
        return tables;

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
        String[] paths = {"/Users/thoreottenheym/Nextcloud/Uni/CT_4/src/main/resources/Material-Aufg4/exercises/ex0.md", "/Users/thoreottenheym/Nextcloud/Uni/CT_4/src/main/resources/Material-Aufg4/exercises/ex1.md"};
        List<TruthTable> table = readTableFromFile(paths);

        System.out.println(table.get(0).toString());
        System.out.println(table.get(1).toString());

    }
}
