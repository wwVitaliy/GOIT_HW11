import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * Reads a list of names and return a string of names from the odd positions in the list
 */
public class Task1 {
    public static void main(String[] args) {

        // Create a list of names
        List<String> names = Arrays.asList("Ivan", "Taras", "Peter", "Andrii", "Pavlo");

        // Create a list from names on odd position in the list "name"
        List<String> namesOnOddPosition = getOddPositionsFromList(names);

        // Print string of all elements from odd positions
        System.out.println(listToString(namesOnOddPosition));

    }

    /**
     * Creates a string of each element from given List with ", " as a delimiter
     *
     * @param list A list of strings
     * @return A single string with all lists elements separated with ", "
     */
    private static String listToString(List<String> list) {
        StringJoiner result = new StringJoiner(", ");

        for (String name : list) {
            result.add(name);
        }

        return result.toString();
    }

    /**
     * Creates a list from elements on odd positions in given list
     * Adds element number from original list
     *
     * @param list list to get names from
     * @return A list with names which were on odd positions in given list
     */
    private static List<String> getOddPositionsFromList(List<String> list) {

        // Filter elements on odd position
        return IntStream.range(0, list.size())  // Create IntStream of indexes
                .filter(i -> i % 2 != 0)    // Filter odd indexes only
                .mapToObj(index -> index + ". " + list.get(index))   // Get elements from names
                .toList();  //create a list from elements in stream
    }

}
