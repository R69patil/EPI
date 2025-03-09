package String;

public class ReplaceAndRemove {
    /**
     * Replaces each 'a' with two 'd's and removes each 'b' in the array.
     * Returns the new length of the array after these operations.
     *
     * @param size The number of valid characters in the array
     * @param s The array to process (with sufficient capacity)
     * @return The new length after replacements and removals
     */
    public static int replaceAndRemove(int size, char[] s) {
        // Forward iteration: remove 'b's and count 'a's
        int writeIdx = 0;
        int aCount = 0;

        for (int i = 0; i < size; i++) {
            if (s[i] != 'b') {
                s[writeIdx++] = s[i];
            }
            if (s[i] == 'a') {
                aCount++;
            }
        }

        // Calculate the final size after replacing each 'a' with two 'd's
        // writeIdx is now the length of the array after removing 'b's
        int finalSize = writeIdx + aCount;

        // Backward iteration: replace 'a's with two 'd's
        int currentIdx = writeIdx - 1;
        writeIdx = finalSize - 1;

        // Iterate backward to avoid overwriting characters we haven't processed yet
        while (currentIdx >= 0) {
            if (s[currentIdx] == 'a') {
                s[writeIdx--] = 'd';
                s[writeIdx--] = 'd';
            } else {
                s[writeIdx--] = s[currentIdx];
            }
            currentIdx--;
        }

        return finalSize;
    }

    public static void main(String[] args) {
        // Test cases
        char[][] testArrays = {
                {'a', 'c', 'd', 'b', 'b', 'c', 'a', ' ', ' ', ' ', ' ', ' '}, // "acdbca" becomes "ddcdcdd"
                {'a', 'b', 'a', 'c', ' ', ' ', ' ', ' '}, // "abac" becomes "ddcdd"
                {'b', 'b', 'b', ' ', ' ', ' '}, // "bbb" becomes ""
                {'c', 'd', 'e', 'f', ' ', ' ', ' ', ' '}, // "cdef" remains "cdef"
                {'a', 'a', 'a', 'a', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '} // "aaaa" becomes "dddddddd"
        };

        int[] testSizes = {6, 4, 3, 4, 4};

        for (int t = 0; t < testArrays.length; t++) {
            char[] arr = testArrays[t].clone(); // Use clone to preserve original array
            int size = testSizes[t];

            System.out.print("Original array (first " + size + " characters): \"");
            printCharArray(arr, size);
            System.out.println("\"");

            int newSize = replaceAndRemove(size, arr);

            System.out.print("After replacing and removing: \"");
            printCharArray(arr, newSize);
            System.out.println("\"");
            System.out.println("New size: " + newSize);
            System.out.println();
        }
    }

    private static void printCharArray(char[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
        }
    }
}