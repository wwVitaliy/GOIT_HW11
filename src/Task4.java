import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creates an infinite stream of numbers based on next linear congruential generator:
 * x[0] = seed
 * x[n + 1] = 1 (a x[n] + c) % m
 * where a, c and m are long-type numbers
 */
public class Task4 {
    public static void main(String[] args) throws InterruptedException {

        // Create linear congruential generator
        RandomGen myRandom = new RandomGen(25214903917L, 11, 2 ^ 48);

        // Create an infinite stream of numbers
        Stream<Long> myStream = getStreamOfRandomLong(myRandom);

        // Print infinite stream of numbers to console (infinite loop)
        myStream
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    /**
     * Creates an infinite stream of numbers based on random generator
     *
     * @param random A random generator
     * @return An infinite stream of numbers based on random generator
     */
    public static Stream<Long> getStreamOfRandomLong(RandomGen random) {
        return Stream.iterate(random.getC(), seed -> random.next());
    }

}

/**
 * Generates pseudo random numbers based on next linear congruential generator:
 * x[0] = seed
 * x[n + 1] = 1 (a x[n] + c) % m
 * where a, c and m are long-type numbers
 */

class RandomGen {

    // Parameters of linear congruential generator
    private long a;
    private long c;
    private long m;

    private long x;    // the first element of the sequence

    public long getC() {
        return c;
    }

    /**
     * Set parameters of linear congruential generator
     *
     * @param a, b, c Parameters of linear congruential generator
     */
    public RandomGen(long a, long c, long m) {
        this.a = a;
        this.c = c;
        this.m = m;

        this.x = c;
    }

    /**
     * Calculate next pseudo random number
     *
     * @return A pseudo random number
     */
    public long next() {
        return (a * x++ + c) % m;
    }
}