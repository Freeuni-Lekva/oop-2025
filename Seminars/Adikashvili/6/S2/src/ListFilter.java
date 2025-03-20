import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListFilter implements Filter {

    // rep invariant: indexes is sorted
    private List<Integer> indexes;

    public ListFilter() {
        indexes = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.indexes.size();
    }

    @Override
    public boolean isPresent(int index) {
        return Collections.binarySearch(indexes, index) >= 0;
    }

    @Override
    public void add(int index) {
        if (isPresent(index)) {
            return;
        }

        // if not found - -(insertion point) - 1 --> (insertion + 1)
        int foundIndex = Collections.binarySearch(indexes, index);
        indexes.add(Math.abs(foundIndex) - 1, index);
    }

    @Override
    public void remove(int index) {
        if (!isPresent(index)) {
            return;
        }

        indexes.remove((Integer) index);
    }
}
