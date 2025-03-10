package String;

/**
 * Implementation for EPI Problem 7.13: Finding the first occurrence of a substring
 * This problem involves finding the starting index of the first occurrence of a pattern
 * string within a text string, or returning -1 if the pattern is not found.
 */
public class SubstringSearch {
    
    /**
     * Finds the first occurrence of a pattern string within a text string.
     * 
     * @param text The text string to search within
     * @param pattern The pattern string to search for
     * @return The index of the first occurrence of pattern in text, or -1 if not found
     */
    public static int findSubstring(String text, String pattern) {
        // Handle edge cases
        if (text == null || pattern == null) {
            return -1;
        }
        
        if (pattern.isEmpty()) {
            return 0;  // Empty pattern is found at index 0
        }
        
        if (text.isEmpty() || pattern.length() > text.length()) {
            return -1;  // Pattern can't be found in an empty text or if pattern is longer than text
        }
        
        // Brute-force approach: check each possible starting position
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j;
            
            // Try to match the pattern starting at position i
            for (j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;  // Mismatch found, break inner loop
                }
            }
            
            // If j reached the pattern length, we found a complete match
            if (j == pattern.length()) {
                return i;  // Return the starting index of the match
            }
        }
        
        // Pattern not found in text
        return -1;
    }
    
    /**
     * A more efficient implementation using the Rabin-Karp algorithm.
     * This algorithm uses hashing to avoid checking every character for potential matches.
     * 
     * @param text The text string to search within
     * @param pattern The pattern string to search for
     * @return The index of the first occurrence of pattern in text, or -1 if not found
     */
    public static int findSubstringRabinKarp(String text, String pattern) {
        // Handle edge cases
        if (text == null || pattern == null) {
            return -1;
        }
        
        if (pattern.isEmpty()) {
            return 0;
        }
        
        if (text.isEmpty() || pattern.length() > text.length()) {
            return -1;
        }
        
        // Choose a prime number for the hash calculation
        final int PRIME = 101;
        
        int patternLength = pattern.length();
        int textLength = text.length();
        
        // Calculate hash value for pattern and first window of text
        int patternHash = 0;
        int textHash = 0;
        int highestPowerOfPrime = 1;
        
        // Calculate the highest power of PRIME we'll need
        for (int i = 0; i < patternLength - 1; i++) {
            highestPowerOfPrime = (highestPowerOfPrime * PRIME) % Integer.MAX_VALUE;
        }
        
        // Calculate initial hash values
        for (int i = 0; i < patternLength; i++) {
            patternHash = ((patternHash * PRIME) + pattern.charAt(i)) % Integer.MAX_VALUE;
            textHash = ((textHash * PRIME) + text.charAt(i)) % Integer.MAX_VALUE;
        }
        
        // Slide the pattern over text one by one
        for (int i = 0; i <= textLength - patternLength; i++) {
            // Check if hash values match
            if (patternHash == textHash) {
                // Check for actual character match
                int j;
                for (j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                
                if (j == patternLength) {
                    return i;  // Match found at index i
                }
            }
            
            // Calculate hash value for next window by removing leading digit
            // and adding trailing digit
            if (i < textLength - patternLength) {
                textHash = (PRIME * (textHash - text.charAt(i) * highestPowerOfPrime) + 
                          text.charAt(i + patternLength)) % Integer.MAX_VALUE;
                
                // We might get negative value, converting it to positive
                if (textHash < 0) {
                    textHash += Integer.MAX_VALUE;
                }
            }
        }
        
        return -1;  // Pattern not found
    }
    
    /**
     * Main method to demonstrate the substring search functions.
     */
    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"Hello World", "World"},
            {"Programming Interview", "gram"},
            {"abcabcabc", "cab"},
            {"aaaaa", "aaa"},
            {"Needle in a haystack", "Needle"},
            {"This is a test", "not found"}
        };
        
        // Process each test case
        for (String[] testCase : testCases) {
            String text = testCase[0];
            String pattern = testCase[1];
            
            int bruteForceResult = findSubstring(text, pattern);
            int rabinKarpResult = findSubstringRabinKarp(text, pattern);
            
            System.out.println("Text: \"" + text + "\"");
            System.out.println("Pattern: \"" + pattern + "\"");
            System.out.println("Brute Force result: " + bruteForceResult);
            System.out.println("Rabin-Karp result: " + rabinKarpResult);
            
            if (bruteForceResult != -1) {
                System.out.println("Found at: \"" + 
                                  text.substring(0, bruteForceResult) + 
                                  "[" + text.substring(bruteForceResult, bruteForceResult + pattern.length()) + "]" + 
                                  text.substring(bruteForceResult + pattern.length()) + "\"");
            } else {
                System.out.println("Pattern not found in text");
            }
            System.out.println();
        }
    }
}