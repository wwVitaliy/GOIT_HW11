import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * Reads a list of names and return a string of names from the odd positions in the list
 */
public class Task1 {
    public static void main(String[] args) {

        // Create a list of names
        List<String> names = Arrays.asList("1. Ivan", "2. Taras", "3. Peter", "4. Andrii", "5. Pavlo");

        // Create a new list of names from odd positions of created list
        List<String> oddNamesList = getOddPositionsFromList(names);

        // Create a string from all elements from the list
        String oddNamesString = listToString(oddNamesList);

        System.out.println(oddNamesString);

    }

    /**
     * Creates a string of each element from given List with ", " as a separator
     *
     * @param oddNamesList A list of strings
     * @return A single string with all lists elements separated with ", "
     */
    private static String listToString(List<String> oddNamesList) {
        StringJoiner result = new StringJoiner(", ");

        for (String name : oddNamesList) {
            result.add(name);
        }

        return result.toString();
    }

    /**
     * Creates a list from names on odd positions in given list
     *
     * @param names list to get names from
     * @return A list with names which were on odd positions in given list
     */
    private static List<String> getOddPositionsFromList(List<String> names) {
        // Create a stream from given list
        Stream<String> namesString = names.stream();

        return namesString
                .filter((name) -> {    // Filter names on odd positions in the list
                    int number = Integer.parseInt(name.substring(0, name.indexOf(". ")));
                    return number % 2 != 0;
                })
                .toList();    // Create a list with result
    }
}
