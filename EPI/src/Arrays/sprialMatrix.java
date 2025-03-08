package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class sprialMatrix {

    /**
     * Problem 6.18: Print the spiral ordering of a 2D array
     * Time Complexity: O(n*m) where n,m are the dimensions of the matrix
     * Space Complexity: O(n*m) for the result
     */
    public static List<Integer> spiralOrdering(List<List<Integer>> matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.isEmpty() || matrix.get(0).isEmpty()) {
            return result;
        }

        // Define the boundaries of the current layer
        int top = 0;
        int left = 0;
        int bottom = matrix.size() - 1;
        int right = matrix.get(0).size() - 1;

        while (top <= bottom && left <= right) {
            // Add the top row (left to right)
            for (int j = left; j <= right; j++) {
                result.add(matrix.get(top).get(j));
            }
            top++;

            // Add the rightmost column (top to bottom)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix.get(i).get(right));
            }
            right--;

            // Add the bottom row (right to left) - if there is still a valid row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix.get(bottom).get(j));
                }
                bottom--;
            }

            // Add the leftmost column (bottom to top) - if there is still a valid column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix.get(i).get(left));
                }
                left++;
            }
        }

        return result;
    }

    // Helper method to print a matrix
    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            System.out.println(row);
        }
    }

    // Main method with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Problem 6.18: Spiral Ordering with User Input ---");

        // Get matrix dimensions from user
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        // Create and populate matrix with user input
        List<List<Integer>> matrix = new ArrayList<>();

        System.out.println("Enter the matrix elements row by row:");
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            System.out.println("Enter " + cols + " elements for row " + (i + 1) + ":");

            for (int j = 0; j < cols; j++) {
                row.add(scanner.nextInt());
            }

            matrix.add(row);
        }

        // Display the matrix
        System.out.println("\nYour Matrix:");
        printMatrix(matrix);

        // Get and display spiral ordering
        List<Integer> spiral = spiralOrdering(matrix);
        System.out.println("\nSpiral Order: " + spiral);

        scanner.close();
    }
}
