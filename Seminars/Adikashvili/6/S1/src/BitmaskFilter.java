public class BitmaskFilter implements Filter {

    // rep invariant: mask[number % 32] == 1 iff number % 32 bit position = 1

    private int[] masks;

    private int numPresents;

    public BitmaskFilter() {
        masks = new int[1]; // [0]
        this.numPresents = 0;
    }

    @Override
    public int size() {
        return this.numPresents;
    }

    @Override
    public boolean isPresent(int index) {
        int maskGroup = index / 32;
        int bitPosition = index % 32;

        if (maskGroup >= masks.length) {
            return false;
        }

        return (masks[maskGroup] & (1 << bitPosition)) != 0;
    }

    @Override
    public void add(int index) {
        if (isPresent(index)) {
            return;
        }

        int maskGroup = index / 32;
        int bitPosition = index % 32;

        if (maskGroup >= masks.length) {
            grow(Math.max(2 * masks.length, maskGroup + 1));
        }

        masks[maskGroup] |= (1 << bitPosition);
        this.numPresents++;
    }

    private void grow(int newSize) {
        int[] newArr = new int[newSize];
        System.arraycopy(masks, 0, newArr, 0, masks.length);
        masks = newArr;
    }

    @Override
    public void remove(int index) {
        if (!isPresent(index)) {
            return;
        }

        int maskGroup = index / 32;
        int bitPosition = index % 32;

        masks[maskGroup] ^= (1 << bitPosition);
        this.numPresents--;
    }
}
