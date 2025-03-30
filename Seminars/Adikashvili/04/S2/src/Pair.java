import java.util.Objects;

public class Pair<T, G extends Number> {

    private T first;

    private G second;

    public Pair() {

    }

    public Pair(T first, G second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public G getSecond() {
        return second;
    }

    public void setSecond(G second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(pair.first, this.first) && Objects.equals(pair.second, this.second);
    }
}
