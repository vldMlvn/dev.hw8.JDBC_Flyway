package write_to_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer implements AutoCloseable {
    private static final String PATH_TO_FILE = "src/main/resources/file.txt";
    private BufferedWriter bufferedWriter;

    public Writer() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(PATH_TO_FILE));
    }

    public void write(String input) throws IOException {
        bufferedWriter.write(input + "\n");
    }

    @Override
    public void close() throws IOException {
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }
}


