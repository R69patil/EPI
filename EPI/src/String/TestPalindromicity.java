package String;

public class TestPalindromicity {
    /**
     * Tests if a string is a palindrome, considering only alphanumeric characters
     * and ignoring case.
     * 
     * @param s The string to test
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
        // Use two indices, one starting at the beginning, one at the end
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            // Skip non-alphanumeric characters from left
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            
            // Skip non-alphanumeric characters from right
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            
            // Compare characters (ignoring case)
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String[] testStrings = {
            "A man, a plan, a canal, Panama",
            "Able was I, ere I saw Elba!",
            "Race a car",
            "Was it a car or a cat I saw?",
            "No 'x' in Nixon",
            "1a2",
            ""
        };
        
        for (String test : testStrings) {
            boolean result = isPalindrome(test);
            System.out.println("\"" + test + "\" is " + (result ? "a palindrome" : "not a palindrome"));
        }
    }
}