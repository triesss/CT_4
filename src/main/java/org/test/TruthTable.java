package org.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TruthTable {
    int rows;
    int columns;
    boolean[][] table;
    String[] columnLabels;

    public TruthTable(boolean[][] table, String[] columnLabels){
        this.rows = table.length;
        this.columns = table[0].length;
        this.table = table;
        this.columnLabels = columnLabels;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append("[");
            for (int j = 0; j < columns; j++) {
                sb.append(table[i][j]);
                if (j != columns - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
    public String toMarkdown() {
        StringBuilder sb = new StringBuilder();

        // Table header with column labels
        sb.append("|");
        for (int i = 1; i < columnLabels.length; i++) {
            sb.append(" ").append(columnLabels[i]).append(" |");
        }
        sb.append("\n");

        // Separator line
        sb.append("|");
        for (int i = 0; i < columnLabels.length - 1; i++) {
            sb.append(" --- |");
        }
        sb.append("\n");

        // Table data
        for (int i = 0; i < rows; i++) {
            sb.append("|");
            for (int j = 0; j < columns; j++) {
                sb.append(" ").append(table[i][j] ? "1" : "0").append(" |");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public void saveToMarkdownFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(toMarkdown());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
