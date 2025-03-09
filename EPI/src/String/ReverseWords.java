package String;

public class ReverseWords {
    /**
     * Reverses the order of words in a string.
     * For example, "Alice likes Bob" becomes "Bob likes Alice".
     * 
     * @param s The string to process
     * @return A new string with all words reversed
     */
    public static String reverseWords(String s) {
        // First, reverse the entire string
        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        
        // Then reverse each individual word
        int start = 0;
        for (int i = 0; i <= chars.length; i++) {
            // When we reach a space or the end of the string, we've found a word boundary
            if (i == chars.length || chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        
        return new String(chars);
    }
    
    /**
     * Helper method to reverse characters in an array between start and end indices.
     */
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
    
    public static void main(String[] args) {
        String[] testStrings = {
            "Alice likes Bob",
            "Hello World",
            "The quick brown fox jumps over the lazy dog",
            "programming interview questions",
            "a",
            ""
        };
        
        for (String test : testStrings) {
            String result = reverseWords(test);
            System.out.println("Original: \"" + test + "\"");
            System.out.println("Reversed: \"" + result + "\"");
            System.out.println();
        }
    }
}