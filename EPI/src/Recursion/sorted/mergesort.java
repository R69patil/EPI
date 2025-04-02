package Recursion.sorted;

import java.util.Arrays;

public class mergesort {
    public static void main(String[] args){
        int[] arr={8,7,9,5,4,3,2,1};
        arr=mergersorting(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static int[] mergersorting(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int[] left=mergersorting(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergersorting(Arrays.copyOfRange(arr,mid,arr.length));
        return marge(left,right);
    }
    private static int[] marge(int[] left,int[] right){
        int[] mix =new int[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                mix[k]=left[i];
                i++;
            }
            else{
                mix[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            mix[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            mix[k]=right[j];
            j++;
            k++;
        }
        return mix;

    }

}
