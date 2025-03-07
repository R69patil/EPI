package Arrays;

import java.util.*;

public class RandomPermutation {
    public static List<Integer> computeRandomPermutation(int n) {
        List<Integer> permutation = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            permutation.add(i);
        }
        Collections.shuffle(permutation); // Randomly shuffles the list
        return permutation;
    }

    public static void main(String[] args) {
        int n = 5; // Example input size
        System.out.println(computeRandomPermutation(n));
    }
}
