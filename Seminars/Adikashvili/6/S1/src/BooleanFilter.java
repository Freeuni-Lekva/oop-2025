public class BooleanFilter implements Filter {

    // rep invariant: if (idexes[i] == 1) i is present

    private boolean[] indexes;

    private int numPresent;

    public BooleanFilter() {
        this.indexes = new boolean[4];
        this.numPresent = 0;
    }

    @Override
    public int size() {
        return this.numPresent;
    }

    @Override
    public boolean isPresent(int index) {
        if (index >= indexes.length) {
            return false;
        }

        return indexes[index];
    }

    @Override
    public void add(int index) {
        if (isPresent(index)) {
            return;
        }

        if (index >= indexes.length) {
            grow(Math.max(index + 1, 2 * indexes.length));
        }
        indexes[index] = true;
        numPresent++;
    }

    private void grow(int newSize) {
        boolean[] newArr = new boolean[newSize];
        for (int i = 0; i < indexes.length; i++) {
            newArr[i] = indexes[i];
        }
        indexes = newArr;
    }

    @Override
    public void remove(int index) {
        if (!isPresent(index)) {
            return;
        }

        indexes[index] = false;
        numPresent--;
    }
}
