package org.test;

public class TruthTable {
    int rows;
    int columns;
    boolean[][] table;

    public TruthTable(boolean[][] table){
        this.rows = table[0].length;
        this.columns = table.length;
        this.table = table;
    }
}
