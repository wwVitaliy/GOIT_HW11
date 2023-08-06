import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Shuffles elements from two streams and stops when one of the streams is run out of elements
 */
public class Task5 {
    public static void main(String[] args) {
        List<String> first = Arrays.asList("Ivan", "Taras", "Peter", "Andrii", "Pavlo");
        List<String> second = Arrays.asList("1", "2", "3");

        zip(first.stream(), second.stream())
                .peek(System.out::println)
                .toList();

    }

    /**
     * Shuffles elements from two streams and stops when one of the streams is run out of elements
     *
     * @param first  First stream to shuffle
     * @param second Second stream to shuffle
     * @return A stream which contain equal quantity of elements from two streams.
     */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first
                .toList();

        List<T> secondList = second
                .toList();

        List<T> resList = new ArrayList<>();

        int resLen = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < resLen; i++) {
            resList.add(firstList.get(i));
            resList.add(secondList.get(i));
        }

        return resList.stream();
    }
}
