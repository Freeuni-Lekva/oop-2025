package filter;

import java.util.ArrayList;

public class BitmaskFilter implements Filter{


    /*
    RI: An array of integers where each bit represents the presence of a number.
    - Only non-negative integers can be stored.

    AF: The bitmask array represents a set of integers.
    - Each integer in the array acts as a bucket containing 32 bits.
    - The i-th smallest bit in the j-th bucket corresponds to the number (j * BUCKET_SIZE + i).
    - If the bit is 1, the number is in the filter; if 0, it is not.
    */

    private static final int BUCKET_SIZE = 32;

    private final ArrayList<Integer> filter;
    private int size;

    public BitmaskFilter(){
        filter = new ArrayList<>();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isPresent(int index) {
        if (index < 0 || index / BUCKET_SIZE >= filter.size()) {
            return false;
        }

        return (filter.get(index / BUCKET_SIZE) & (1 << (index % BUCKET_SIZE))) != 0;
    }

    @Override
    public void add(int index) {
        if (index < 0) {
            return;
        }

        int bucketIdx = index / BUCKET_SIZE;
        while (filter.size() <= bucketIdx) {
            filter.add(0);
        }

        int bucketVal = filter.get(bucketIdx);
        if ((bucketVal & (1 << (index % BUCKET_SIZE))) != 0) { // Already present
            return;
        }

        bucketVal |= (1 << (index % BUCKET_SIZE));
        filter.set(bucketIdx, bucketVal);
        size++;
    }

    @Override
    public void remove(int index) {
        if (!isPresent(index)) {
            return;
        }

        int bucketIdx = index / BUCKET_SIZE;
        int bucketVal = filter.get(bucketIdx);
        filter.set(bucketIdx,  bucketVal ^ (1<<(index % BUCKET_SIZE)));
        size--;
    }
}
