package Arrays;

import java.util.*;

public class NonUniformRandom {
    private final List<Double> prefixSums;  // Stores cumulative probabilities
    private final List<Integer> values;  // Stores the given values
    private final Random rand = new Random();  // Random number generator

    // Constructor to initialize the prefix sum array from given values and probabilities
    public NonUniformRandom(List<Integer> values, List<Double> probabilities) {
        this.values = values;
        this.prefixSums = new ArrayList<>();
        
        double sum = 0;
        for (double prob : probabilities) {
            sum += prob;
            prefixSums.add(sum);  // Creating cumulative sum list
        }
    }

    // Method to generate a non-uniform random number based on probabilities
    public int generate() {
        double r = rand.nextDouble();  // Generate a random number in the range [0,1)

        // Use binary search to find the first index where prefixSums[i] >= r
        int index = Collections.binarySearch(prefixSums, r);
        
        // If exact match is not found, convert negative index to correct insertion point
        if (index < 0) {
            index = -index - 1;
        }

        return values.get(index);  // Return the corresponding value
    }

    public static void main(String[] args) {
        // Define the values and their corresponding probabilities
        List<Integer> values = Arrays.asList(3, 5, 7, 11);
        List<Double> probabilities = Arrays.asList(0.2, 0.5, 0.2, 0.1);  // Probabilities must sum to 1

        // Create an instance of NonUniformRandom with the given values and probabilities
        NonUniformRandom generator = new NonUniformRandom(values, probabilities);

        // Generate 10 random samples and print them
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }
    }
}
