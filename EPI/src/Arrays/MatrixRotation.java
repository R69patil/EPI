package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixRotation {
    
    /**
     * Problem 6.19: Rotate a square matrix by 90 degrees clockwise
     * Time Complexity: O(n²) where n is the dimension of the matrix
     * Space Complexity: O(1) - in-place rotation
     */
    public static void rotateMatrix(List<List<Integer>> matrix) {
        int n = matrix.size();
        
        if (n == 0 || n != matrix.get(0).size()) {
            // Not a square matrix, can't rotate
            System.out.println("Error: Matrix must be square to rotate!");
            return;
        }
        
        // Step 1: Transpose the matrix (swap along the main diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, temp);
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            // Reverse the current row
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(i).get(n - 1 - j));
                matrix.get(i).set(n - 1 - j, temp);
            }
        }
    }
    
    // Helper method to print a matrix
    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            System.out.println(row);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Problem 6.19: Matrix Rotation (90° Clockwise) ---");
        
        // Get matrix size from user (must be square)
        System.out.print("Enter size of square matrix (n): ");
        int n = scanner.nextInt();
        
        // Create and populate matrix with user input
        List<List<Integer>> matrix = new ArrayList<>();
        
        System.out.println("Enter the matrix elements row by row:");
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            System.out.println("Enter " + n + " elements for row " + (i+1) + ":");
            
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextInt());
            }
            
            matrix.add(row);
        }
        
        // Display original matrix
        System.out.println("\nOriginal Matrix:");
        printMatrix(matrix);
        
        // Rotate the matrix
        rotateMatrix(matrix);
        
        // Display rotated matrix
        System.out.println("\nAfter 90° Clockwise Rotation:");
        printMatrix(matrix);
        
        scanner.close();
    }
}