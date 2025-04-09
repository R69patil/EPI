package Pratice_Problem;
import java.util.*;

public class TwoPointer {
    public static void main(String[] args){
        int[] array= {1,2,3,4,5};
        //Brute force approach
//        int[] nums = new int[array.length];
//        for(int i=0;i<array.length;i++){
//            int product=1;
//            for(int j=0;j<array.length;j++){
//                if(i!=j){
//                    product*=array[j];
//                }
//                nums[i]=product;
//            }
//        }
//        for(int i=0;i<array.length;i++){
//            System.out.print(nums[i]+" ");
//        }
        int[] res=productExceptSelf(array);
        System.out.println(Arrays.toString(res));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Left product
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with right product
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;
    }


}
