import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListFilter implements Filter {

    // rep invariant: indexes is sorted

    private final List<Integer> indexes;

    public ListFilter() {
        indexes = new ArrayList<>();
    }

    @Override
    public int size() {
        return indexes.size();
    }

    @Override
    public boolean isPresent(int index) {
        return indexes.contains(index);
    }

    @Override
    public void add(int index) {
        if (isPresent(index)) {
            return;
        }

        // -(insertion point) - 1
        int foundIndex = Collections.binarySearch(indexes, index);
        indexes.add(-foundIndex - 1, index);
    }

    @Override
    public void remove(int index) {
        indexes.remove((Integer) index);
    }
}
