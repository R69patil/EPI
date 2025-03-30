package LeetCode_problem;
import  java.util.*;


public class Missing_number {
    public List<Integer> find_missing_number(int[] array){
        int i=0;
        while(i<array.length){
            int Correct=array[i]-1;
            if(array[i]!=array[Correct]){
                swap(array,i,Correct);
            }
            else{
                i++;
            }
        }

        List<Integer> list=new ArrayList<>();
        for(int index=0;index<array.length;index++){
            if(array[index]!=index+1){
                list.add(index+1);
        }
        }
        return list;
    }

    public static void swap(int[] array, int i, int correct) {
            int temp=array[i];
            array[i]=array[correct];
            array[correct]=temp;
    }

    public static void main(String[] rgs){
        int[] arr ={4,3,2,7,8,2,3,1};
        Missing_number m = new Missing_number();
        List<Integer> res=m.find_missing_number(arr);
        System.out.println(res);
    }
}
