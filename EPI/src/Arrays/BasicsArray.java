package Arrays;
import java.util.*;
public class BasicsArray {
    public static void main(String[] args){
       int[] array= new int[]{1,3,5,6,7};
     //  System.out.println(Arrays.toString(array));
        Integer[][] arr2D = new Integer[3][];  // 3 rows with undefined columns
        arr2D[0] = new Integer[]{1, 2};
        arr2D[1] = new Integer[]{3, 4, 5};
        arr2D[2] = new Integer[]{6};
        //System.out.println(Arrays.deepToString(arr2D));
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(Arrays.toString(list.toArray()));
        //binarySearch(): Searches for a value in a sorted array.
        int[] nums = {10, 20, 30, 40};
        int index = Arrays.binarySearch(nums, 30);
        // Output: 2/
       // System.out.println(index);
        //copyOf(): Copies the entire array or up to the specified length
        int[] original = {1, 2, 3,4,5,6};
        //int[] copy = Arrays.copyOf(original, 5);  // Output: [1, 2, 3, 0, 0]
        //System.out.println(Arrays.toString(copy));
        int[] rangeCopy = Arrays.copyOfRange(original, 1, 3);  // Output: [2, 3]
        //System.out.println(Arrays.toString(rangeCopy));
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
      //  System.out.println(Arrays.equals(arr1, arr2));  // Output: true
        Integer[][] deepArr1 = {{1, 2}, {3, 4}};
        Integer[][] deepArr2 = {{1, 2}, {3, 4}};
        ///System.out.println(Arrays.deepEquals(deepArr1, deepArr2));  // Output: true
        int[] num= new int[5];
        Arrays.fill(num, 42);  // Output: [42, 42, 42, 42, 42]
        int[] numsr = {4, 1, 3, 2};
        Arrays.sort(numsr);  // Output: [1, 2, 3, 4]
        System.out.println(Arrays.toString(numsr));

    }


}

