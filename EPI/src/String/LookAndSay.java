package String;

/**
 * Solution for the Look-and-Say sequence problem
 * Time Complexity: O(n * L) where n is the number of iterations and L is the length of the string
 * Space Complexity: O(L) where L is the length of the result string
 */
public class LookAndSay {
    
    /**
     * Computes the nth number in the Look-and-Say sequence
     * starting with the seed value
     * 
     * @param n the term number to compute (1-based indexing)
     * @param seed the starting value (default is "1")
     * @return the nth term in the Look-and-Say sequence
     */
    public static String lookAndSay(int n, String seed) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be a positive integer");
        }
        
        String current = seed;
        
        // Generate the sequence n-1 times (since we already have the first term)
        for (int i = 1; i < n; i++) {
            current = nextTerm(current);
        }
        
        return current;
    }
    
    /**
     * Overloaded method that uses "1" as the default seed
     */
    public static String lookAndSay(int n) {
        return lookAndSay(n, "1");
    }
    
    /**
     * Generates the next term in the Look-and-Say sequence
     * 
     * @param current the current term
     * @return the next term in the sequence
     */
    private static String nextTerm(String current) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char currentDigit = current.charAt(0);
        
        // Iterate through the string starting from the second character
        for (int i = 1; i < current.length(); i++) {
            // If the current digit is the same as the previous one, increment count
            if (current.charAt(i) == currentDigit) {
                count++;
            } else {
                // Otherwise, append the count and the digit to the result
                result.append(count).append(currentDigit);
                // Reset count and update the current digit
                count = 1;
                currentDigit = current.charAt(i);
            }
        }
        
        // Append the count and digit for the last group
        result.append(count).append(currentDigit);
        
        return result.toString();
    }
    
    /**
     * Sample usage of the Look-and-Say sequence generator
     */
    public static void main(String[] args) {
        // Generate the first 10 terms of the Look-and-Say sequence
        System.out.println("First 10 terms of the Look-and-Say sequence:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Term " + i + ": " + lookAndSay(i));
        }
        
        // Example with a different seed
        System.out.println("\nLook-and-Say sequence with seed '22':");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Term " + i + ": " + lookAndSay(i, "22"));
        }
    }
}