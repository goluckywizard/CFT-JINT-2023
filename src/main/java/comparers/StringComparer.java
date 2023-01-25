package comparers;

public class StringComparer implements IComparer<String>{
    int mode;

    public StringComparer(int mode) {
        this.mode = mode;
    }

    @Override
    public int compare(String first, String second) {
        if (first == null) {
            return 1;
        }
        if (second == null) {
            return -1;
        }
        return mode * first.compareTo(second);
    }
}
