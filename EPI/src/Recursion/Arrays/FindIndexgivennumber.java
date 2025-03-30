package Recursion.Arrays;

import java.util.ArrayList;

public class FindIndexgivennumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 9, 7};
        int target = 7;
     //  System.out.print(findIndex(arr, target, 0));
       // System.out.print(findIndexAt(arr,target,0));
       // System.out.print(findIndexlast(arr,target,arr.length-1));

       // findIndexAll(arr,target,0);
        // System.out.print(list);
//        ArrayList<Integer> list= new ArrayList<>();
//        ArrayList<Integer> ans=findIndex(arr,target,0,list);
//        System.out.print(ans);


        System.out.print(findIndexwithoutlistargu(arr,target,0));


    }
    public static boolean findIndex(int[] arr, int target, int index) {
        if(index==arr.length){
            return false;
        }
        return arr[index]==target||findIndex(arr,target,index+1);
    }
    public static int findIndexAt(int[] arr,int target,int index){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        else{
            return findIndexAt(arr,target,index+1);
        }
    }
    static int findIndexlast(int[] arr,int target,int index){
        if(index==-1){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        else{
            return findIndexlast(arr,target,index-1);
        }
    }
    static ArrayList<Integer> list = new ArrayList<>();
    static void findIndexAll(int[] arr,int target,int index){
        if(index==arr.length){
            return;
        }
        if(arr[index]==target){
            list.add(index);
        }
        findIndexAll(arr,target,index+1);

    }
    static ArrayList<Integer> findIndex(int[] arr, int target,int index,ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return findIndex(arr,target,index+1,list);
    }
    static ArrayList<Integer> findIndexwithoutlistargu(int[] arr,int target,int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ans=findIndexwithoutlistargu(arr,target,index+1);
        list.addAll(ans);
        return list;
    }



}
