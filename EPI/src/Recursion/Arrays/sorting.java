package Recursion.Arrays;

public class sorting {
    public static void main(String[] args){
        int[] arr={1,3,4,8,6,8};
        boolean ans=checksorting(arr,0);
        System.out.println(ans);
    }
    public static boolean checksorting(int[] arr, int index){
        if(index==arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1]&&checksorting(arr,index+1);
    }
}
