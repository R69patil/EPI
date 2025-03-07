package Arrays;

import java.util.*;

public class SudokuChecker {
    
    public static boolean isValidSudoku(char[][] board) {
        // List of sets for rows and columns
        List<Set<Character>> rowList = new ArrayList<>();
        List<Set<Character>> colList = new ArrayList<>();

        // 3x3 grid list of sets
        List<List<Set<Character>>> subgridList = new ArrayList<>();

        // Initialize the lists
        for (int i = 0; i < 9; i++) {
            rowList.add(new HashSet<>());
            colList.add(new HashSet<>());
        }

        for (int i = 0; i < 3; i++) {
            subgridList.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                subgridList.get(i).add(new HashSet<>());
            }
        }

        // Iterate over the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];

                if (num == '.') continue; // Ignore empty cells

                // Find subgrid index
                int subRow = row / 3;
                int subCol = col / 3;

                // Check for duplicates
                if (hasDuplicate(rowList.get(row), num) || 
                    hasDuplicate(colList.get(col), num) || 
                    hasDuplicate(subgridList.get(subRow).get(subCol), num)) {
                    return false; // Found duplicate
                }
            }
        }
        return true; // No duplicates found
    }

    // Helper method to check for duplicates
    private static boolean hasDuplicate(Set<Character> set, char num) {
        if (set.contains(num)) return true; // Duplicate found
        set.add(num);
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board) ? "Valid Sudoku" : "Invalid Sudoku");
    }
}
