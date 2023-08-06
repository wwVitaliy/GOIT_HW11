import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Prints all numbers from an array ["1, 2, 0", "4, 5"], sorted from lower to bigger.
 */
public class Task3 {

    private static final String DELIMITER = ", ";    // Delimiter for elements

    public static void main(String[] args) {

        // Create a preset array
        String[] strArray = {"1, 2, 0", "4, 5"};

        // Create a sting from sorted numbers from preset array
        String sortedString = stringArrayToSortedString(strArray);

        // Print the result
        System.out.println(sortedString);
    }

    /**
     * Creates a sorted string of all elements separated by DELIMITER in all strings of given array of strings
     *
     * @param strArray An array of strings.
     *                 Each string can contain more than 1 element separated by DELIMITER
     * @return A string with sorted elements separated by DILIMITER
     */
    private static String stringArrayToSortedString(String[] strArray) {
        return Arrays.stream(strArray)
                .flatMap(str -> strToElements(str, DELIMITER).stream())
                .sorted()
                .collect(Collectors.joining(DELIMITER));
    }

    /**
     * Creates a list of all elements separated by DELIMITER in given string
     *
     * @param str       A string to separate into elements
     * @param delimiter A string for specifying the boundary between different elements
     * @return A list of all elements which were separated by DELIMITER in given string
     */
    private static ArrayList<String> strToElements(String str, String delimiter) {

        ArrayList<String> result = new ArrayList<>();

        str = str.strip();

        while (str.contains(delimiter)) {
            int separatorPosition = str.indexOf(delimiter);
            result.add(str.substring(0, separatorPosition));
            str = str.substring(separatorPosition + DELIMITER.length());
        }
        result.add(str);

        return result;
    }
}
