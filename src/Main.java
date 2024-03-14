import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter input file name:");

        try (Scanner scanner = new Scanner(System.in)) {
            String inFileName = scanner.next();
            File inputFile = new File(inFileName);

            if (!inputFile.exists()) {
                System.out.println("File not found. Please make sure the file exists and try again.");
                return;
            }

            FreqCounter dict = new FreqCounter(inputFile);
            dict.makeDict(inputFile);

            System.out.println("Enter output file name:");
            File outputFile = new File(scanner.next());
            dict.makeFile(outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please make sure the file exists and try again.");
        } catch (IOException e) {
            System.out.println("Error: An error occurred while reading or writing the file.");
        }
    }
}
