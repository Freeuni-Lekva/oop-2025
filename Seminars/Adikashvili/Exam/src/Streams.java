import java.util.*;
import java.util.Comparator;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates(Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4).stream(), Integer::compareTo));
    }

    public static <T> List<T> removeConsecutiveDuplicates(Stream<T> items, Comparator<T> cmp) {
        return items.reduce(
                new ArrayList<>(),
                (acc, element) -> {
                    if (acc.isEmpty() || cmp.compare(acc.get(acc.size() - 1), element) != 0) {
                        acc.add(element);
                    }

                    return acc;
                },
                (left, right) -> left.isEmpty() ? right : left
        );
    }
}