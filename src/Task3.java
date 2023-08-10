import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Prints all numbers from an array ["1, 2, 0", "4, 5"], sorted from lower to bigger.
 */
public class Task3 {

    private static final String DELIMITER = ", ";    // Delimiter for elements

    public static void main(String[] args) {

        // Create a preset array
        String[] strArray = {"1, 2, 0", "4, 5"};

        // Creates a sorter string of all numbers from teh array
        String sortedString = Arrays.stream(strArray)
                .flatMap(str -> str
                        .chars()
                        .mapToObj(i -> (char) i))
                .filter(Character::isDigit)
                .sorted()
                .map(el -> "" + el)
                .collect(Collectors.joining(DELIMITER));

        // Print sorted string to console
        System.out.println(sortedString);
    }

}