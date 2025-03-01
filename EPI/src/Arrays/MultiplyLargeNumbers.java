package Arrays;

import java.util.*;

public class MultiplyLargeNumbers {
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        // Determine the sign of the result
        int sign = (num1.get(0) < 0 ^ num2.get(0) < 0) ? -1 : 1;
        
        // Convert numbers to their absolute values for processing
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        // Initialize result array with zeros
        int n = num1.size(), m = num2.size();
        List<Integer> result = new ArrayList<>(Collections.nCopies(n + m, 0));

        // Perform multiplication digit by digit
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = num1.get(i) * num2.get(j);
                int sum = mul + result.get(i + j + 1);

                result.set(i + j + 1, sum % 10);  // Store single digit
                result.set(i + j, result.get(i + j) + sum / 10); // Carry over
            }
        }

        // Remove leading zeros
        int index = 0;
        while (index < result.size() - 1 && result.get(index) == 0) {
            index++;
        }
        result = result.subList(index, result.size());

        // Restore the sign if needed
        if (sign == -1) {
            result.set(0, result.get(0) * -1);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> num1 = Arrays.asList(1, 2, 3);  // 123
        List<Integer> num2 = Arrays.asList(-4, 5, 6); // -456

        List<Integer> result = multiply(num1, num2);
        System.out.println(result); // Output: [-5, 6, 0, 8, 8]
    }
}
