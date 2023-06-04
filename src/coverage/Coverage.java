package coverage;

import java.util.HashSet;
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
            findRowsToMarkMMBUE(table, i, rowResult, markedRows);
        }
        return markedRows.stream().mapToInt(i -> i).toArray();
    }

    private static void findRowsToMarkMMBUE(TruthTable table, int i, boolean rowResult, Set<Integer> markedRows) {
        int differentBooleans;
        for (int j = i + 1; j < table.rows; j++) {
            differentBooleans = 0;
            // get rows that are different by one boolean
            for (int k = 0; k < table.columns - 1; k++) {
                if (rowResult == table.table[j][table.columns - 1]) {
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
        HashSet<Pair> pairs = new HashSet<>();
        HashSet<Integer> markedRows = new HashSet<>();
        boolean rowResult;
            for (int i = 0; i < table.rows; i++) {
                rowResult = table.table[i][table.columns - 1];
                findPairsToMarkMCDC(table, i, rowResult, pairs);
            }
        for (Pair pair:
             pairs) {
            markedRows.add(pair.indexFirst);
            markedRows.add(pair.indexSecond);
        }
        return markedRows.stream().sorted().mapToInt(i -> i).toArray();
    }

    private static void findPairsToMarkMCDC(TruthTable table, int i, boolean rowResult, HashSet<Pair> pairs) {
        int differentBooleans;
        int index = 0;
        for (int j = i + 1; j < table.rows; j++) {
            differentBooleans = 0;
            // get rows that are different by one boolean
            for (int k = 0; k < table.columns - 1; k++) {
                if (rowResult == table.table[j][table.columns - 1]) {
                    break;
                }
                if (table.table[i][k] != table.table[j][k]) {
                    differentBooleans++;
                    index = k;
                }
            }
            if (differentBooleans == 1) {
                Pair pair = new Pair(i, j, index);
                pairs.add(pair);
            }
        }
    }
}
