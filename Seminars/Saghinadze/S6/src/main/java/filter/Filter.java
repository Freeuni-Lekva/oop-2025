package filter;

// No negative indexes are allowed.
public interface Filter {

    // Returns total number of objects present.
    int size();

    // Returns true if object at given position is present.
    boolean isPresent(int index);

    // Marks object with given index as present.
    void add(int index);

    // Removes object with given index from filter.
    void remove(int index);
}
