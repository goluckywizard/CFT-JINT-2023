package readers;

public interface IReader<T>{
    T readNextFromFile();
    void close();
}
