package String;

/**
 * Implementation for EPI Problem 7.12: Run-Length Encoding and Decoding
 * This problem involves two operations:
 * 1. Encoding: Converting a string to its run-length encoded form
 * 2. Decoding: Converting a run-length encoded string back to its original form
 */
public class RunLengthEncoding {
    
    /**
     * Encodes a string using run-length encoding.
     * Each consecutive sequence of the same character is replaced with 
     * the count followed by the character.
     * 
     * Example: "aaaabcccaa" -> "4a1b3c2a"
     * 
     * @param s The input string to encode
     * @return The run-length encoded string
     */
    public static String encode(String s) {
        // Handle edge cases
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        StringBuilder encodedString = new StringBuilder();
        int count = 1;
        
        // Process each character in the string
        for (int i = 1; i < s.length(); i++) {
            // If current character is the same as the previous one, increment count
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                // If different, append the count and previous character to result
                encodedString.append(count);
                encodedString.append(s.charAt(i - 1));
                // Reset count for the new character
                count = 1;
            }
        }
        
        // Don't forget to append the last character sequence
        encodedString.append(count);
        encodedString.append(s.charAt(s.length() - 1));
        
        return encodedString.toString();
    }
    
    /**
     * Decodes a run-length encoded string back to its original form.
     * 
     * Example: "4a1b3c2a" -> "aaaabcccaa"
     * 
     * @param s The run-length encoded string
     * @return The decoded original string
     */
    public static String decode(String s) {
        // Handle edge cases
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        StringBuilder decodedString = new StringBuilder();
        int count = 0;
        
        // Process each character in the encoded string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If the character is a digit, update the count
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else {
                // If the character is not a digit, it's a character to be repeated
                // Append the character 'count' times to the result
                for (int j = 0; j < count; j++) {
                    decodedString.append(c);
                }
                // Reset count for the next sequence
                count = 0;
            }
        }
        
        return decodedString.toString();
    }
    
    /**
     * Main method to demonstrate the encoding and decoding functions.
     */
    public static void main(String[] args) {
        // Test cases
        String[] testStrings = {
            "aaaabcccaa",
            "a",
            "abcd",
            "aabbbccccddddd"
        };
        
        // Process each test case
        for (String str : testStrings) {
            String encoded = encode(str);
            String decoded = decode(encoded);
            
            System.out.println("Original: \"" + str + "\"");
            System.out.println("Encoded:  \"" + encoded + "\"");
            System.out.println("Decoded:  \"" + decoded + "\"");
            System.out.println("Correctly decoded: " + str.equals(decoded));
            System.out.println();
        }
    }
}