package pair;
public class PairIncorrectEquals<T1, T2> {
    private T1 first;
    private T2 second;

    public PairIncorrectEquals(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public boolean equals(Object pair) {
        if (pair == this) return true;

        if (!(pair instanceof PairIncorrectEquals<?, ?> p)) return false;

        return p.first.equals(this.first) && p.second.equals(this.second);
    }
}
