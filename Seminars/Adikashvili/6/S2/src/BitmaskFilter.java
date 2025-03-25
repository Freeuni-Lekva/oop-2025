
public class BitmaskFilter implements Filter {

    private int[] masks;

    private int numPresents;

    public BitmaskFilter() {
        this.numPresents = 0;
        this.masks = new int[1]; // [0000....00]
    }

    @Override
    public int size() {
        return this.numPresents;
    }

    @Override
    public boolean isPresent(int index) {
        // 31 (1 << 31)  10000000000000000000

        int mask = index / 32;
        int position = index % 32;

        if (mask >= masks.length) {
            return false;
        }

        return (masks[mask] & (1 << position)) != 0;
    }

    @Override
    public void add(int index) {
        if (isPresent(index)) {
            return;
        }

        int mask = index / 32;
        int position = index % 32;

        if (mask >= masks.length) {
            grow(Math.max(2 * masks.length, mask + 1));
        }

        masks[mask] |= (1 << position);
        this.numPresents++;
    }

    private void grow(int newSize) {
        int[] newMasks = new int[newSize];
        System.arraycopy(masks, 0, newMasks, 0, masks.length);
        masks = newMasks;
    }

    @Override
    public void remove(int index) {
        if (!isPresent(index)) {
            return;
        }

        int mask = index / 32;
        int position = index % 32;

        masks[mask] &= ~(1 << position);
        this.numPresents--;
    }
}
