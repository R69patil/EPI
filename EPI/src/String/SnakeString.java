package String;

public class SnakeString {
    /**
     * Encodes a string in a zigzag (sinusoidal) pattern.
     * Example: For input "Hello_World",
     * The zigzag pattern would be:
     *    e   _   l
     *   H l o W r d
     *     l   o   
     * 
     * And the output would be "e_lHloWrdlo"
     * 
     * @param s The input string to encode
     * @return The snake string encoding
     */
    public static String snakeString(String s) {
        // If input is empty or null, return empty string
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        
        // Construct the first row (characters at indices 1, 5, 9, ...)
        for (int i = 1; i < s.length(); i += 4) {
            result.append(s.charAt(i));
        }
        
        // Construct the second row (characters at indices 0, 2, 4, 6, ...)
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        
        // Construct the third row (characters at indices 3, 7, 11, ...)
        for (int i = 3; i < s.length(); i += 4) {
            result.append(s.charAt(i));
        }
        
        return result.toString();
    }
    
    /**
     * Main method to demonstrate the snakeString function.
     */
    public static void main(String[] args) {
        // Test cases
        String[] testStrings = {
            "Hello_World",
            "Programming",
            "Interview",
            "a",
            "ab",
            "abc"
        };
        
        // Process each test case
        for (String str : testStrings) {
            String encoded = snakeString(str);
            System.out.println("Original: \"" + str + "\"");
            System.out.println("Encoded:  \"" + encoded + "\"");
            System.out.println();
        }
    }
}