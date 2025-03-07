package Arrays;

import java.util.*;

public class ReservoirSampling {
    
    // Function to perform reservoir sampling
    public static List<Integer> randomSampling(Iterator<Integer> stream, int k) {
        List<Integer> reservoir = new ArrayList<>();
        Random rand = new Random();

        // Step 1: Store the first k elements in the reservoir
        for (int i = 0; i < k && stream.hasNext(); i++) {
            reservoir.add(stream.next()); // Simply adding first k elements
        }

        // Step 2: Process the rest of the stream
        int index = k; // This tracks the current index in the stream
        while (stream.hasNext()) {
            int num = stream.next(); // Read the next number from the stream
            int randIdx = rand.nextInt(index + 1); // Generate a random index [0, index]

            if (randIdx < k) { 
                // If the random index is within the range [0, k-1], replace that element
                reservoir.set(randIdx, num);
            }

            index++; // Move to the next element in the stream
        }

        return reservoir; // Return the final k-sized random sample
    }

    public static void main(String[] args) {
        // Simulating an online data stream with a list
        List<Integer> stream = Arrays.asList(3, 7, 5, 11, 9, 2, 6, 8);
        int k = 3; // Number of elements to sample
        List<Integer> result = randomSampling(stream.iterator(), k);

        System.out.println(result); // Output will vary each time due to randomness
    }
}
