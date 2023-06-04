package org.test;

import java.io.IOException;
import java.util.List;

import static org.test.Coverage.runCoverage;
import static org.test.ReaderWriteTable.readTableFromFile;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] paths = {"/Users/thoreottenheym/Nextcloud/Uni/CT_4/src/main/resources/Material-Aufg4/exercises/ex0.md", "/Users/thoreottenheym/Nextcloud/Uni/CT_4/src/main/resources/Material-Aufg4/exercises/ex1.md"};
        List<TruthTable> table = readTableFromFile(paths);
        System.out.println(table);
        table.forEach(t -> {
            int[] resultRows = runCoverage("MCDC", t);
            System.out.println("Rows to test: ");
            for (int i = 0; i < resultRows.length; i++) {
                System.out.println(resultRows[i]);
            }
            t.saveToMarkdownFile("src/main/resources/Material-Aufg4/exercises/ex10.md");
        });



    }

    // console application
}
