import java.util.HashMap;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class FreqCounter {
    private HashMap<Character, Integer> dict;
    private File inputFile;

    public FreqCounter(File inputFile) {
        this.inputFile = inputFile;
        this.dict = new HashMap<>();
    }

    public void makeDict(File inFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if (Character.isLetter(symbol)) {
                        dict.put(symbol, dict.getOrDefault(symbol, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. " + e.getMessage());
        }
    }

    public void makeFile(File outFile) {
        try (FileWriter writer = new FileWriter(outFile)) {
            for (char key : dict.keySet()) {
                String line = key + ": " + dict.get(key) + "\n";
                writer.write(line);
            }

        } catch (IOException e) {
            System.out.println("Error writing data to file: " + e.getMessage());
        }
    }
}

