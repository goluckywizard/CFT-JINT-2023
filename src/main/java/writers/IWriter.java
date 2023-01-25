package writers;

import java.io.IOException;

public interface IWriter<T>{
    void writeToFile(T component) throws IOException;
}
