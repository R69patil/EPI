package ALL_Sorting_Algorithm;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindAllDuplicates {

    // Method to find all duplicates in the array
    public List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                ans.add(arr[index]);
            }
        }

        return ans;
    }

    // Swap method to swap elements in the array
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // Main method for testing
    public static void main(String[] args) {
        FindAllDuplicates obj = new FindAllDuplicates();
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1}; // Example input
        List<Integer> duplicates = obj.findDuplicates(arr);

        System.out.println("Duplicates in the array: " + duplicates);
    }
}
