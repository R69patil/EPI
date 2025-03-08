package String;

public class SpreadsheetColumnEncoding {
    
    /**
     * Converts a spreadsheet column ID (A-Z, AA-ZZ, etc.) to its corresponding integer value.
     * A = 1, B = 2, ..., Z = 26, AA = 27, AB = 28, ...
     * 
     * @param columnId the spreadsheet column ID
     * @return the integer value of the column
     */
    public static int decodeColumnId(String columnId) {
        if (columnId == null || columnId.isEmpty()) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < columnId.length(); i++) {
            char c = columnId.charAt(i);
            result = result * 26 + (c - 'A' + 1);
        }
        
        return result;
    }
    
    /**
     * Converts an integer to its corresponding spreadsheet column ID.
     * 1 = A, 2 = B, ..., 26 = Z, 27 = AA, 28 = AB, ...
     * 
     * @param columnNumber the integer value of the column
     * @return the spreadsheet column ID
     */
    public static String encodeColumnId(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;  // Adjust to 0-indexed for calculation
            result.insert(0, (char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Test cases for decoding
        System.out.println("A = " + decodeColumnId("A"));     // 1
        System.out.println("Z = " + decodeColumnId("Z"));     // 26
        System.out.println("AA = " + decodeColumnId("AA"));   // 27
        System.out.println("AZ = " + decodeColumnId("AZ"));   // 52
        System.out.println("BA = " + decodeColumnId("BA"));   // 53
        System.out.println("ZZ = " + decodeColumnId("ZZ"));   // 702
        System.out.println("AAA = " + decodeColumnId("AAA")); // 703
        
        // Test cases for encoding
        System.out.println("1 = " + encodeColumnId(1));     // A
        System.out.println("26 = " + encodeColumnId(26));   // Z
        System.out.println("27 = " + encodeColumnId(27));   // AA
        System.out.println("52 = " + encodeColumnId(52));   // AZ
        System.out.println("53 = " + encodeColumnId(53));   // BA
        System.out.println("702 = " + encodeColumnId(702)); // ZZ
        System.out.println("703 = " + encodeColumnId(703)); // AAA
    }
}