package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneMnemonics {
    // Mapping from digit to corresponding characters on phone keypad
    private static final String[] MAPPING = {
        "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
    };
    
    /**
     * Computes all possible letter combinations that can be formed from a phone number.
     * 
     * @param phoneNumber The input phone number
     * @return List of all possible letter combinations
     */
    public static List<String> phoneMnemonic(String phoneNumber) {
        // Initialize result list and partial result array
        List<String> mnemonics = new ArrayList<>();
        char[] partialMnemonic = new char[phoneNumber.length()];
        
        // Generate mnemonics recursively
        phoneMnemonicHelper(phoneNumber, 0, partialMnemonic, mnemonics);
        
        return mnemonics;
    }
    
    /**
     * Recursive helper method to generate all possible mnemonics.
     * 
     * @param phoneNumber The input phone number
     * @param digit The current digit we're processing
     * @param partialMnemonic The current partial mnemonic
     * @param mnemonics The list to store all generated mnemonics
     */
    private static void phoneMnemonicHelper(String phoneNumber, int digit,
                                           char[] partialMnemonic, List<String> mnemonics) {
        // Base case: If we've processed all digits, add the complete mnemonic to result
        if (digit == phoneNumber.length()) {
            mnemonics.add(new String(partialMnemonic));
            return;
        }
        
        // Get the current digit and its corresponding characters
        int currentDigit = phoneNumber.charAt(digit) - '0';
        String letters = MAPPING[currentDigit];
        
        // Try each letter for the current digit
        for (int i = 0; i < letters.length(); i++) {
            partialMnemonic[digit] = letters.charAt(i);
            phoneMnemonicHelper(phoneNumber, digit + 1, partialMnemonic, mnemonics);
        }
    }
    
    public static void main(String[] args) {
        String[] testPhoneNumbers = {
            "23",       // AD, AE, AF, BD, BE, BF, CD, CE, CF
            "456",      // GJM, GJN, GJO, GKM, GKN, ...
            "2276696",  // ACRONYM, ACROPOD, ...
            "27",       // AP, AQ, AR, AS, BP, BQ, ...
            "0123"      // 01AD, 01AE, 01AF, 01BD, ...
        };
        
        for (String number : testPhoneNumbers) {
            List<String> mnemonics = phoneMnemonic(number);
            System.out.println("Phone number: " + number);
            System.out.println("Number of mnemonics: " + mnemonics.size());
            
            // Print all mnemonics for shorter numbers, just a sample for longer ones
            if (mnemonics.size() <= 27) {
                System.out.println("All mnemonics: " + mnemonics);
            } else {
                System.out.println("Sample mnemonics: " + mnemonics.subList(0, 10) + "...");
            }
            System.out.println();
        }
    }
}