package write_to_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private static BufferedWriter writer;
    private final static String PATH_TO_FILE = "src/main/resources/file.txt";

    public static void openFile() throws IOException {
        writer = new BufferedWriter(new FileWriter(PATH_TO_FILE));
    }

    public static void write(String input) throws IOException {
        if (writer != null) {
            writer.write(input + "\n");
        } else {
            throw new IOException("File not opened.");
        }
    }

    public static void closeFile() throws IOException {
        if (writer != null) {
            writer.close();
        } else {
            throw new IOException("File not opened.");
        }
    }
}

