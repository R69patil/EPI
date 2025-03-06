package Arrays;

import java.util.*;

public class NextPermutationList {
    /**
     * Computes the next lexicographical permutation of the given list.
     * If no larger permutation exists, it rearranges to the smallest permutation.
     * 
     * @param perm The input list of integers
     * @return The next permutation as a modified list
     */
    public static List<Integer> nextPermutation(List<Integer> perm) {
        int n = perm.size();
        int i = n - 2;

        // Step 1: Find the rightmost element that is smaller than its next element
        while (i >= 0 && perm.get(i) >= perm.get(i + 1)) {
            i--;
        }

        // Step 2: If such an element exists, find the next larger element
        if (i >= 0) {
            int j = n - 1;
            // Find the smallest element on the right that is larger than perm[i]
            while (perm.get(j) <= perm.get(i)) {
                j--;
            }
            // Swap the two elements
            swap(perm, i, j);
        }

        // Step 3: Reverse the elements to the right of i to get the next permutation
        reverse(perm, i + 1, n - 1);

        return perm; // Return the modified list
    }

    /**
     * Swaps two elements in a list.
     *
     * @param perm The list
     * @param i    The index of the first element
     * @param j    The index of the second element
     */
    private static void swap(List<Integer> perm, int i, int j) {
        int temp = perm.get(i);
        perm.set(i, perm.get(j));
        perm.set(j, temp);
    }

    /**
     * Reverses a sublist of the given list in place.
     *
     * @param perm  The list
     * @param left  The start index of the sublist
     * @param right The end index of the sublist
     */
    private static void reverse(List<Integer> perm, int left, int right) {
        while (left < right) {
            swap(perm, left, right);
            left++;
            right--;
        }
    }

    /**
     * Main function to test the nextPermutation function.
     */
    public static void main(String[] args) {
        List<Integer> perm = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("Before: " + perm);
        nextPermutation(perm);
        System.out.println("After: " + perm); // Expected Output: [1, 3, 2]

        // Additional test cases
        List<Integer> perm2 = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println("Before: " + perm2);
        nextPermutation(perm2);
        System.out.println("After: " + perm2); // Expected Output: [1, 2, 3]

        List<Integer> perm3 = new ArrayList<>(Arrays.asList(1, 1, 5));
        System.out.println("Before: " + perm3);
        nextPermutation(perm3);
        System.out.println("After: " + perm3); // Expected Output: [1, 5, 1]
    }
}
