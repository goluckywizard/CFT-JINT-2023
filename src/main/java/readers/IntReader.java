package readers;

import java.io.FileInputStream;
import java.util.Scanner;

public class IntReader implements IReader<Integer>{
    Scanner scanner;

    public IntReader(FileInputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    @Override
    public Integer readNextFromFile() {
        if (scanner.hasNextInt())
            return scanner.nextInt();
        else
            return null;
    }

    @Override
    public void close() {
        scanner.close();
    }

}
