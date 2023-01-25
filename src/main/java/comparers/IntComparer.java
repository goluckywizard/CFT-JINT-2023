package comparers;

public class IntComparer implements IComparer<Integer>{
    int mode;

    public IntComparer(int mode) {
        this.mode = mode;
    }

    @Override
    public int compare(Integer first, Integer second) {
        if (first == null) {
            return 1;
        }
        if (second == null) {
            return -1;
        }
        return mode * (first - second);
    }
}
