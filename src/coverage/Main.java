package coverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static coverage.ReaderWriteTable.readTableFromFile;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello User what do you want to do?");
        System.out.println("You can choose input files and a test coverage mode/s.");
        System.out.println("You can choose between MMBUE and MCDC.");
        System.out.println("Enter the path to a file and enter done when you are finished.");
        String path = "";
        List<String> paths = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (!path.equals("done")) {
            path = reader.readLine();
            if (!path.equals("done")) {
                paths.add(path);
            }
        }
        System.out.println("Enter the test coverage mode/s you want to use.");
        System.out.println("\"MCDC\" \"MMBUE\" or \"both\" for both.");
        String mode = "";
        mode = reader.readLine();
        String[] pathsArray = paths.toArray(new String[0]);
        List<TruthTable> table = null;
        try {
            table = readTableFromFile(pathsArray);
        } catch
        (IOException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
        String finalMode = mode;
        for (int i = 0; i < table.size(); i++) {
            TruthTable t = table.get(i);
            String resultPath = pathsArray[i].replace(".md", "result.md");
            int[] mcdcMarks = new int[0];
            int[] mmbueMarks = new int[0];
            switch (finalMode) {
                case "MCDC" -> mcdcMarks = Coverage.runCoverage("MCDC", t);
                case "MMBUE" -> mmbueMarks = Coverage.runCoverage("MMBUE", t);
                case "both" -> {
                    mcdcMarks = Coverage.runCoverage("MCDC", t);
                    mmbueMarks = Coverage.runCoverage("MMBUE", t);
                }
            }
            t.saveToMarkdownFile(resultPath, mcdcMarks, mmbueMarks);
        }
    }

    // console application
}
