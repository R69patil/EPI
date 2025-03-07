package Arrays;

import java.util.*;

public class RandomSubset {
    public static List<Integer> computeRandomSubset(int n, int k) {
        Map<Integer, Integer> swapped = new HashMap<>();
        Random rand = new Random();

        for (int i = 0; i < k; i++) {
            int randIndex = i + rand.nextInt(n - i);
            
            // Get the mapped value if exists; otherwise, use randIndex itself
            int valAtRand = swapped.getOrDefault(randIndex, randIndex);
            int valAtI = swapped.getOrDefault(i, i);

            // Swap elements in our virtual array
            swapped.put(randIndex, valAtI);
            swapped.put(i, valAtRand);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(swapped.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10; // Total elements
        int k = 4;  // Subset size

        System.out.println(computeRandomSubset(n, k)); // Example output: [7, 1, 4, 8]
    }
}
