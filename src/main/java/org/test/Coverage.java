package org.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coverage {

    public static int[] runCoverage(String coverageMode, TruthTable table) {
        switch (coverageMode) {
            case "MMBUE":
                return MMBUE(table);
            case "MCDC":
                return MCDC(table);
            default:
                return null;
        }
    }


    // list of integers that are the indices of the rows that have to be tested
    private static int[] MMBUE(TruthTable table) {
        Set<Integer> markedRows = new HashSet<>();
        boolean rowResult;
        for (int i = 0; i < table.rows; i++) {
            rowResult = table.table[i][table.columns - 1];
            findRowsToMark(table, i, rowResult, markedRows);
        }
        return markedRows.stream().mapToInt(i -> i).toArray();
    }

    private static void findRowsToMark(TruthTable table, int i, boolean rowResult, Set<Integer> markedRows) {
        int differentBooleans;
        for (int j = i + 1; j < table.rows; j++) {
            differentBooleans = 0;
            // get rows that are different by one boolean
            for (int k = 0; k < table.columns - 1; k++) {
                if (rowResult == table.table[j][table.columns - 1]){
                    break;
                }
                if (table.table[i][k] != table.table[j][k]) {
                    differentBooleans++;
                }
            }
            if (differentBooleans == 1) {
                markedRows.add(i);
                markedRows.add(j);
            }
        }
    }

    // list of integers that are the indices of the rows that have to be tested
    private static int[] MCDC(TruthTable table) {
        int rows = table.rows;
        int columns = table.columns;
        boolean[][] truthTable = table.table;


        return null;
    }
}
