package org.test;

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
        // TODO
        return null;
    }

    // list of integers that are the indices of the rows that have to be tested
    private static int[] MCDC(TruthTable table) {
        int rows = table.rows;
        int columns = table.columns;
        boolean[][] truthTable = table.table;


        return null;
    }
}
