package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    
    /**
     * Problem 6.20: Generate the first numRows of Pascal's triangle
     * Time Complexity: O(numRows²)
     * Space Complexity: O(numRows²) for storing all elements of the triangle
     */
    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (numRows <= 0) {
            return result;
        }
        
        // First row is always [1]
        result.add(new ArrayList<>(Collections.singletonList(1)));
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> prevRow = result.get(i - 1);
            
            // First element of each row is always 1
            currentRow.add(1);
            
            // Middle elements are sum of elements above
            for (int j = 1; j < i; j++) {
                // Add element from previous row at j-1 and j positions
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            // Last element of each row is always 1
            currentRow.add(1);
            
            result.add(currentRow);
        }
        
        return result;
    }
    
    // Helper method to print Pascal's Triangle in a nicer format
    public static void printPascalTriangle(List<List<Integer>> triangle) {
        int numRows = triangle.size();
        
        // Calculate max width for formatting
        int maxWidth = String.valueOf(triangle.get(numRows - 1).get(numRows / 2)).length();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = triangle.get(i);
            
            // Print leading spaces for centering
            for (int s = 0; s < (numRows - i - 1) * (maxWidth + 1) / 2; s++) {
                System.out.print(" ");
            }
            
            // Print row elements
            for (int num : row) {
                System.out.printf("%-" + (maxWidth + 1) + "d", num);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Problem 6.20: Pascal's Triangle ---");
        System.out.print("Enter number of rows to generate: ");
        int numRows = scanner.nextInt();
        
        if (numRows <= 0) {
            System.out.println("Number of rows must be positive!");
        } else {
            List<List<Integer>> pascalTriangle = generatePascalTriangle(numRows);
            
            System.out.println("\nPascal's Triangle (" + numRows + " rows):");
            printPascalTriangle(pascalTriangle);
            
            // Also print the raw list format for verification
            System.out.println("\nAs List of Lists:");
            for (List<Integer> row : pascalTriangle) {
                System.out.println(row);
            }
        }
        
        scanner.close();
    }
}