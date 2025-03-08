package String;

import java.util.Objects;

public class IsStringPalindromicWithOneDeletion {
    
    /**
     * Tests if a string can be made into a palindrome by removing at most one character.
     * 
     * @param s the string to check
     * @return true if the string is already a palindrome or can become a palindrome by
     *         removing at most one character; false otherwise
     */
    public static boolean canBecomePalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try removing character at left or right
                return isPalindrome(s, left + 1, right) || 
                       isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        
        // String is already a palindrome
        return true;
    }
    
    /**
     * Tests if the substring s[start...end] forms a palindrome.
     */
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(canBecomePalindrome("raceacar"));  // true - remove 'a' to get "racecar"
        System.out.println(canBecomePalindrome("abcba"));     // true - already a palindrome
        System.out.println(canBecomePalindrome("abccbda"));   // true - remove 'd'
        System.out.println(canBecomePalindrome("abcd"));      // false - need to remove more than one character
        System.out.println(canBecomePalindrome(""));          // true - empty string is a palindrome
        System.out.println(canBecomePalindrome("a"));         // true - single character is a palindrome
    }
}