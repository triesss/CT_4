package coverage;

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


    public static List<TruthTable> readTableFromFile(String[] paths) throws IOException, IllegalArgumentException {
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
                    throw new IllegalArgumentException("the file with the name: " + p + " is not valid (wrong number of columns)");
                }else {
                    List<Boolean> row = new ArrayList<>();
                    for (int i = 1; i < splits.length; i++) {
                        if (Objects.equals(splits[i].trim(), "1")) {
                            row.add(true);
                        } else if (Objects.equals(splits[i].trim(), "0")) {
                            row.add(false);
                        } else {
                            throw new IllegalArgumentException("the file with the name: " + p + " is not valid (illegal character)");
                        }
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
        String[] paths = {"resources/Material-Aufg4/exercises/ex0.md", "resources/Material-Aufg4/exercises/ex1.md"};
        List<TruthTable> table = readTableFromFile(paths);

        System.out.println(table.get(0).toString());
        System.out.println(table.get(1).toString());

    }
}
