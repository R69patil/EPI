package Arrays;
import java.util.*;
import java.util.List;

public class DeleteduplicatesfromasortedArray {

    public static int deletedulicates(List<Integer> A){
        if (A.isEmpty()) return 0; // Edge case: Empty list

        int writeIdx = 1; // Position to write unique elements

        for (int i = 1; i < A.size(); i++) {
            if (!A.get(i).equals(A.get(writeIdx - 1))) { // New unique element
                A.set(writeIdx, A.get(i)); // Move unique element
                writeIdx++; // Move pointer
            }
        }

        return writeIdx; // Number of unique elements
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 5, 5, 7, 11, 11, 11, 13));

        int k = deletedulicates(list);
        System.out.println("Unique count: " + k);
        System.out.println("Modified list: " + list.subList(0, k));

    }


}
