package String;

public class StringIntegerInterconversion {

    /**
     * Converts a string to an integer.
     */
    public static int stringToInt(String s) {
        boolean isNegative = s.startsWith("-");
        int result = 0;

        for (int i = isNegative ? 1 : 0; i < s.length(); i++) {
            final int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
        }

        return isNegative ? -result : result;
    }

    /**
     * Converts an integer to a string.
     */
    public static String intToString(int x) {
        boolean isNegative = x < 0;
        StringBuilder s = new StringBuilder();

        if (x == 0) {
            return "0";
        }

        if (isNegative) {
            x = -x;
        }

        while (x != 0) {
            s.append((char)('0' + x % 10));
            x /= 10;
        }

        if (isNegative) {
            s.append('-');
        }

        s.reverse();
        return s.toString();
    }

    public static void main(String[] args) {
        // Test stringToInt
        System.out.println(stringToInt("123"));   // 123
        System.out.println(stringToInt("-123"));  // -123
        System.out.println(stringToInt("0"));     // 0

        // Test intToString
        System.out.println(intToString(123));     // "123"
        System.out.println(intToString(-123));    // "-123"
        System.out.println(intToString(0));       // "0"
    }
}