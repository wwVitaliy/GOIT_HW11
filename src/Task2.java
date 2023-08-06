import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Reads a list of names and return a sorted in descending order list of names in upper case
 */
public class Task2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Taras", "Peter", "Andrii", "Pavlo");
        System.out.println(getSortedListOfUpperCaseStrings(names));

    }

    /**
     * Creates a list of sorted in descending order names in upper case from given list
     * @param names List to get names from
     * @return A sorted in descending order list of names in upper case
     */
    private static List<String> getSortedListOfUpperCaseStrings(List<String> names) {

        Stream<String> stringStream = names.stream();

        return stringStream
                .map(String::toUpperCase)    // Change each element to upper case
                .sorted(Comparator.reverseOrder())    // Sort in descending order
                .toList();    // Create a list with result
    }
}
