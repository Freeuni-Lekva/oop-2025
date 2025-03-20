public class BooleanFilter implements Filter {

    private boolean[] indexes;

    private int currSize; // number of trues

    public BooleanFilter() {
        indexes = new boolean[4];
        this.currSize = 0;
    }

    @Override
    public int size() {
        return currSize;
    }

    @Override
    public boolean isPresent(int index) {
        return index < indexes.length && indexes[index];
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
        currSize++;
    }

    @Override
    public void remove(int index) {
        if (!isPresent(index)) {
            return;
        }

        indexes[index] = false;
        currSize--;
    }

    private void grow(int newSize) {
        boolean[] newIndexes = new boolean[newSize];
        for (int i = 0; i < indexes.length; i++) {
            newIndexes[i] = indexes[i];
        }
        indexes = newIndexes;
    }
}
