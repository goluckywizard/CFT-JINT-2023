package writers;

import java.io.FileWriter;
import java.io.IOException;

public class StringWriter  implements IWriter<String>{
    FileWriter output;
    public StringWriter(FileWriter outputStream) {
        output = (outputStream);
    }

    @Override
    public void writeToFile(String component) throws IOException {
        output.write(component + "\n");
        output.flush();
    }
}
