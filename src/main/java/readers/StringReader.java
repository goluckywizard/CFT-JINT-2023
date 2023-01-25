package readers;

import java.io.FileInputStream;
import java.util.Scanner;

public class StringReader implements IReader<String>{
    Scanner scanner;

    public StringReader(FileInputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public String readNextFromFile() {
        if (scanner.hasNext())
            return scanner.nextLine();
        else
            return null;
    }

    @Override
    public void close() {
        scanner.close();
    }
}
