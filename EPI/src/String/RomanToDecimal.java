package String;

/**
 * Solution for converting Roman numerals to decimal integers
 * Time Complexity: O(n) where n is the length of the Roman numeral string
 * Space Complexity: O(1) as we use a fixed-size mapping of Roman numerals
 */
public class RomanToDecimal {
    
    /**
     * Converts a Roman numeral string to its decimal integer equivalent
     * 
     * @param s the Roman numeral string to convert
     * @return the decimal integer value
     * @throws IllegalArgumentException if the input contains invalid Roman numerals
     */
    public static int romanToDecimal(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input Roman numeral cannot be null or empty");
        }
        
        // Map to store the values of individual Roman numerals
        java.util.Map<Character, Integer> romanValues = new java.util.HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        int result = 0;
        int prevValue = 0;
        
        // Process the Roman numeral string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            
            // Verify that the character is a valid Roman numeral
            if (!romanValues.containsKey(currentChar)) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + currentChar);
            }
            
            int currentValue = romanValues.get(currentChar);
            
            // If current value is greater than or equal to previous value, add it
            // Otherwise, subtract it (handles cases like IV, IX, etc.)
            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }
            
            prevValue = currentValue;
        }
        
        return result;
    }
    
    /**
     * Sample usage of the Roman to decimal converter
     */
    public static void main(String[] args) {
        // Test cases
        String[] romanNumerals = {"I", "IV", "IX", "LVIII", "MCMXCIV", "MMMCMXCIX"};
        
        System.out.println("Roman to Decimal Conversion Examples:");
        for (String roman : romanNumerals) {
            System.out.println(roman + " = " + romanToDecimal(roman));
        }
    }
}