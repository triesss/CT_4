package org.test;

public class TruthTable {
    int rows;
    int columns;
    boolean[][] table;

    public TruthTable(boolean[][] table){
        this.rows = table.length;
        this.columns = table[0].length;
        this.table = table;
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
}
