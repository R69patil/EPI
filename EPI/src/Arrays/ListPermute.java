package Arrays;

import java.util.*;

public class ListPermute {
    public static void applyPermutation(List<Integer> P, List<String> A) {
        for (int i = 0; i < A.size(); i++) {
            while (P.get(i) != i) {
                int targetIdx = P.get(i);
                Collections.swap(A, i, targetIdx);
                Collections.swap(P, i, targetIdx);
            }
        }
    }

    public static void main(String[] args) {
        List<String> A = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        List<Integer> P = new ArrayList<>(Arrays.asList(2, 0, 1, 3));

        applyPermutation(P, A);
        System.out.println(A); // Output: [b, c, a, d]
    }
}
