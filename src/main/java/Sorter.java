import comparers.IComparer;
import comparers.IntComparer;
import comparers.StringComparer;
import readers.IReader;
import readers.IntReader;
import readers.StringReader;
import writers.IWriter;
import writers.IntWriter;
import writers.StringWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Sorter<T extends Comparable> {
    private IComparer<T> comparer;
    private IWriter<T> writer;
    private Map<IReader<T>, T> readers;

    public Sorter(List<String> inputFiles, String out, Class<T> tClass, int mode) {
        try {
            readers = new HashMap<>();
            for (var in : inputFiles) {
                if (tClass == Integer.class)
                    readers.put((IReader<T>) new IntReader(new FileInputStream(in)), null);
                if (tClass == String.class) {
                    readers.put((IReader<T>) new StringReader(new FileInputStream(in)), null);
                }
            }
            if (tClass == Integer.class){
                writer = (IWriter<T>) new IntWriter(new FileWriter(out));
                comparer = (IComparer<T>) new IntComparer(mode);
            }
            if (tClass == String.class) {
                writer = (IWriter<T>) new StringWriter(new FileWriter(out));
                comparer = (IComparer<T>) new StringComparer(mode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Sort() {
        readers.replaceAll((k, v) -> k.readNextFromFile());
        T previous = null;
        try {
            //Optional<Map.Entry<IReader<T>, T>> entry;
            while (!readers.values().stream().allMatch(Objects::isNull)) {
                var entry = readers.entrySet().stream().min((x, y) -> comparer.compare(x.getValue(), y.getValue()));

                if (entry.get().getValue() == null) {
                    break;
                }
                T thisComponent = entry.get().getValue();
                readers.put(entry.get().getKey(), entry.get().getKey().readNextFromFile());
                if (comparer.compare(thisComponent, previous) < 0 && previous != null) {
                    continue;
                }
                previous = thisComponent;
                writer.writeToFile(thisComponent);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            for (var k : readers.keySet()) {
                k.close();
            }
        }
    }
}
