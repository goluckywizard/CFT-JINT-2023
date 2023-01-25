package writers;

import java.io.FileWriter;
import java.io.IOException;

public class IntWriter implements IWriter<Integer>{
    FileWriter output;
    public IntWriter(FileWriter outputStream) {
        output = (outputStream);
    }

    @Override
    public void writeToFile(Integer component) throws IOException {
        output.write(component.toString() + "\n");
        output.flush();
    }

}
