package encryptdecrypt.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReaderWriter {

    public final String readFile(final String fileName) {
        String fileData = "";
        try (Scanner scanner = new Scanner(new File(fileName))) {
            fileData = scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
        }
        return  fileData;
    }

    public final void writeToFile(final String fileName, final String input) {
        final File file = new File(fileName);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.print(input);
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
        }
    }
}
