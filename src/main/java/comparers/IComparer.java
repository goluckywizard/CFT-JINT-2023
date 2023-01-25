package comparers;

public interface IComparer<T extends Comparable> {
    int compare(T first, T second);
}
