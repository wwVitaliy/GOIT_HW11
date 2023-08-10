import java.util.*;
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
     * Shuffles elements from two streams one by one and stops when one of the streams is run out of elements
     *
     * @param first  First stream to shuffle
     * @param second Second stream to shuffle
     * @return A stream which contain equal quantity of elements from two streams.
     */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Stream<T> result = Stream.empty();

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            result = Stream.concat(result, Stream.of(firstIterator.next()));
            result = Stream.concat(result, Stream.of(secondIterator.next()));

        }

        return result;
    }


}
